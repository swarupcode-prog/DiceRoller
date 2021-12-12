package com.example.diceroller

import android.media.MediaPlayer
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val rollButton: Button =
//            findViewById(R.id.button2)   //The code saves a reference to the Button (class/widget) in a variable called rollButton, not the Button object itself.
//
//        rollButton.setOnClickListener {
//            rollDice()
//            rollDiceMusic()
//        }

    }

    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll() //this gives random values from 1 to 6
        val diceImage: ImageView = findViewById(R.id.imageView)

        val drawableImage = when (diceRoll) {
            1 -> R.drawable.dice_1_2d
            2 -> R.drawable.dice_2_2d
            3 -> R.drawable.dice_3_2d
            4 -> R.drawable.dice_4_2d
            5 -> R.drawable.dice_5_2d
            else -> R.drawable.dice_6_2d
        }

       // diceImage.setImageResource(drawableImage)

        val anim1: Animation = AnimationUtils.loadAnimation(this@MainActivity, R.anim.shake) //this points to the shake.xmlfile

        val animationListener: Animation.AnimationListener =
            object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation) {
                    diceImage.setImageResource(drawableImage) //THIS CREATES A VERY SUBTLE DIFFRENCE WHEN YOU START THE APP YOU SPOT IT AFTER REMOVING THIS METHOD
                } //these are the methods called from the iterface
                override fun onAnimationEnd(animation: Animation) {

                        diceImage.setImageResource(drawableImage) //this sets the image accordingly

                }

                override fun onAnimationRepeat(animation: Animation) {}
            }

        anim1.setAnimationListener(animationListener) //when we pass the animationListner all the three methods get executed
        diceImage.startAnimation(anim1) //diceImage is like a pointer to imageview of dice


    }

      private fun rollDiceMusic(){
          val music: MediaPlayer = MediaPlayer.create(this@MainActivity, R.raw.rollmusic)
          music.start()
      }

    fun rollButton(view: android.view.View) {
        rollDice()
        rollDiceMusic()
    }


}

class Dice(private val diceSides: Int) //making diceSides Private makes it acessible only to Dice class
{
    fun roll(): Int {
        return (1..diceSides).random()
    }
}

