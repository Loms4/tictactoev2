package com.example.tictactoe

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.tictactoe.R.id.move

class FirstPage : AppCompatActivity() {



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_page)

        val move = findViewById<Button>(R.id.move)
        move.setOnClickListener{
            val intent = Intent( this, MainActivity::class.java)
            startActivity(intent)
        }




    }
    private fun callActivity(){
        val playerone = findViewById<EditText>(R.id.player1)
        val playertwo = findViewById<EditText>(R.id.player2)

        val message1 = playerone.text.toString()
        val message2 = playertwo.text.toString()

        val intent =Intent(this, MainActivity::class.java).also {
            it.putExtra("p1",message1)
            it.putExtra("p2",message2)
        }
    }


}