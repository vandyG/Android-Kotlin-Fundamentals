package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        val countUpButton = findViewById<Button>(R.id.countup_button)
        countUpButton.setOnClickListener { countUp() }

    }

    private fun countUp() {
        val resultText = findViewById<TextView>(R.id.result_text)
//        resultText.text.let { when(it){
//            "Hello World!" -> 1.toString()
//            "6" -> "6"
//            else ->  "${resultText.text.toString().toInt() + 1}"
//        } }

        resultText.run {
            text = when (text) {
                "Hello World!" -> 1.toString()
                "6" -> "6"
                else -> "${text.toString().toInt() + 1}"
            }
        }
    }

    private fun rollDice() {
//        Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
        val resultText = findViewById<TextView>(R.id.result_text)
        val random = (1..6).random()
        resultText.text = random.toString()
    }
}