package com.rohitksingh.dicerollerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

/**
 * This activity allows user to roll dice and see the result on the screen
 */
class MainActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)
        diceImage = findViewById(R.id.diceimage)
        button.setOnClickListener { rollDice() }
        rollDice()
    }

    /**
     * Roll the dice and update the textview
     */


    private fun rollDice(){

        val diceImageRes = when ((1..6).random()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.dice_1
        }

        diceImage.setImageResource(diceImageRes)

    }
}