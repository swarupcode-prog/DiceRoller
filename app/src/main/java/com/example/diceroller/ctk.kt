package com.example.diceroller
//
//import android.os.Bundle
//import android.support.v7.app.AppCompatActivity
//import android.view.animation.Animation
//import android.view.animation.AnimationUtils
//import android.widget.Button
//import android.widget.ImageView
//import androidx.appcompat.app.AppCompatActivity
//import java.util.*
//
//class MainActivity : AppCompatActivity() {
//    private var rollDices: Button? = null
//    private var imageView1: ImageView? = null
//    private var imageView2: ImageView? = null
//    protected fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        rollDices = findViewById(R.id.rollDices) as Button?
//        imageView1 = findViewById(R.id.imageView1) as ImageView?
//        imageView2 = findViewById(R.id.imageView2) as ImageView?
//        rollDices!!.setOnClickListener {
//            val anim1: Animation = AnimationUtils.loadAnimation(this@MainActivity, R.anim.shake)
//            val anim2: Animation = AnimationUtils.loadAnimation(this@MainActivity, R.anim.shake)
//            val animationListener: Animation.AnimationListener =
//                object : Animation.AnimationListener {
//                    override fun onAnimationStart(animation: Animation) {}
//                    override fun onAnimationEnd(animation: Animation) {
//                        val value: Int = MainActivity.Companion.randomDiceValue()
//                        val res: Int = getResources().getIdentifier(
//                            "dice_$value",
//                            "drawable",
//                            "com.ssaurel.dicer"
//                        )
//                        if (animation === anim1) {
//                            imageView1!!.setImageResource(res)
//                        } else if (animation === anim2) {
//                            imageView2!!.setImageResource(res)
//                        }
//                    }
//
//                    override fun onAnimationRepeat(animation: Animation) {}
//                }
//            anim1.setAnimationListener(animationListener)
//            anim2.setAnimationListener(animationListener)
//            imageView1!!.startAnimation(anim1)
//            imageView2!!.startAnimation(anim2)
//        }
//    }
//
//    var rawMainActivity: view? = null
//
//    companion object {
//        val RANDOM = Random()
//        fun randomDiceValue(): Int {
//            return MainActivity.Companion.RANDOM.nextInt(6) + 1
//        }
//    }
//}