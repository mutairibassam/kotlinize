    package com.datum.android.kotlinized

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.datum.android.kotlinized.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    /**
     * TODO lateinit var
     *
     * we have to initialize variables in Kotlin with a value,
     *
     *          var diceImage: ImageView // error!
     *
     * So we need to do something for this, since we don't know the value so we make it null
     *
     *          var diceImage: ImageView? = null
     *
     * But this will enforce us to handle the null every time! which more logic to type so, we can make it lateinit
     *
     *          lateinit var diceImage: ImageView
     *
     * @lateinit gives the activity promise that it will be initialized before assigning any value to it
     *
     */

    lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /**
         * TODO ViewBinding
         *
         * First you need to add
         *
         * android {
         *      .....
         *      viewBinding {
         *           enabled = true
         *       }
         *  }
         *
         * In gradle to generate @ActivityMainBinding for me, once we added the above code all the binding layouts will be generated
         * automatically for us by Gradle
         *
         * Second
         * we need to inflate the layout and store it in a variable, then we pass it in the @setContentView() method
         *
         * root == the root of my layout. in my case now ( it's the ConstraintLayout )
         *
         * This will help us to
         *      1- replace the findViewById() method
         *      2- Safer
         *      3- Less code
         *
         */

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        diceImage = findViewById(R.id.dice_image)

        // access xml views by using ViewBinding
        binding.rollButton.setOnClickListener {
            val selected = ScreenUtils.generateRandomizedNumber()
            val drawableResource = ScreenUtils.getDrawableResInt(selected)
            diceImage.setImageResource(drawableResource)
        }

        // access xml views by findViewById() method
//        val myRollButton: Button = findViewById(R.id.roll_button);


    }

}