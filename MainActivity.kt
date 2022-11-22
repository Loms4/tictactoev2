package com.example.tictactoe

import android.graphics.Color
import android.graphics.Color.RED
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var button1:Button
    private lateinit var button2:Button
    private lateinit var button3:Button
    private lateinit var button4:Button
    private lateinit var button5:Button
    private lateinit var button6:Button
    private lateinit var button7:Button
    private lateinit var button8:Button
    private lateinit var button9:Button
    private lateinit var reset: Button
    private lateinit var player1: TextView
    private lateinit var player2: TextView


    var activePlayer = 1
    var player1points = 0
    var player2points = 0

    private var firstPlayer= ArrayList<Int>()
    private var secondPlayer= ArrayList<Int>()





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        player1 = findViewById(R.id.player1)
        player2 = findViewById(R.id.player2)
        reset = findViewById(R.id.reset)



        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
    }

    val pointp1 =intent.getStringExtra("p1")
    val pointp2 =intent.getStringExtra("p2")

    val firstP =findViewById<TextView>(R.id.player1).apply {
        text= pointp1}
    val secondP=findViewById<TextView>(R.id.player2).apply {
        text= pointp2}


    override fun onClick(clickedView: View?) {
        if (clickedView is Button) {
            var buttonNumber = 0

            when (clickedView.id) {
                R.id.button1 -> buttonNumber = 1
                R.id.button2 -> buttonNumber = 2
                R.id.button3 -> buttonNumber = 3
                R.id.button4 -> buttonNumber = 4
                R.id.button5 -> buttonNumber = 5
                R.id.button6 -> buttonNumber = 6
                R.id.button7 -> buttonNumber = 7
                R.id.button8 -> buttonNumber = 8
                R.id.button9 -> buttonNumber = 9

            }


            if (buttonNumber != 0) {
                playGame(buttonNumber, clickedView)
            }
        }
    }

    fun updatescore(){
        player1.text = "Player 1: " + player1points.toString()
        player2.text = "Player 2: " + player2points.toString()
    }

    private fun reset(){
        button1.text = ""
        button1.setBackgroundColor(Color.CYAN)
        button1.isEnabled = true
        button2.text = ""
        button2.setBackgroundColor(Color.CYAN)
        button2.isEnabled = true
        button3.text = ""
        button3.setBackgroundColor(Color.CYAN)
        button3.isEnabled = true
        button4.text = ""
        button4.setBackgroundColor(Color.CYAN)
        button4.isEnabled = true
        button5.text = ""
        button5.setBackgroundColor(Color.CYAN)
        button5.isEnabled = true
        button6.text = ""
        button6.setBackgroundColor(Color.CYAN)
        button6.isEnabled = true
        button7.text = ""
        button7.setBackgroundColor(Color.CYAN)
        button7.isEnabled = true
        button8.text = ""
        button8.setBackgroundColor(Color.CYAN)
        button8.isEnabled = true
        button9.text = ""
        button9.setBackgroundColor(Color.CYAN)
        button9.isEnabled = true
        firstPlayer.clear()
        secondPlayer.clear()
        updatescore()
    }

    private fun playGame(buttonNumber: Int, clickedView: Button) {
        if (activePlayer == 1) {
            clickedView.text = "X"
            clickedView.setBackgroundColor(Color.MAGENTA)
            activePlayer = 2
            firstPlayer.add(buttonNumber)
        } else if (activePlayer == 2) {
            clickedView.text = "O"
            clickedView.setBackgroundColor(Color.CYAN)
            activePlayer = 1
            secondPlayer.add(2)
        }
        clickedView.isEnabled = false
        check()
    }


    private fun check() {

        var winnerPlayer = 0

        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)) {
            winnerPlayer = 2
        }

        if (winnerPlayer == 1) {
            player1points++
            Toast.makeText(this, "Player one wins", Toast.LENGTH_SHORT).show()}
        else if (winnerPlayer == 2) {
            player2points++
            Toast.makeText(this, "Player two wins", Toast.LENGTH_SHORT).show()
        }

    }
}