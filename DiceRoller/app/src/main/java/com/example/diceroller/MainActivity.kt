package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

    }

    private fun rollDice() {
//        Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
//        val resultText = findViewById<TextView>(R.id.result_text)
//        resultText.text = random.toString()

        val random = (1..6).random()
        val diceImage = findViewById<ImageView>(R.id.dice_Image)
        val drawableResource = when (random) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        
        diceImage.setImageResource(drawableResource)
    }
}