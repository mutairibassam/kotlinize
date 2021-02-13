package com.datum.android.kotlinized

import androidx.appcompat.app.AppCompatActivity
import java.util.*

class ScreenUtils {

companion object{

    fun getDrawableResInt(selectedNumber:Int): Int {
        val drawableResource = when (selectedNumber) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        return drawableResource
    }

    fun generateRandomizedNumber() = Random().nextInt(6) + 1

    }
}