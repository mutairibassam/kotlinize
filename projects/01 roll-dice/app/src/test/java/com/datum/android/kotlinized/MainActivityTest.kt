package com.datum.android.kotlinized

import android.util.Log
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Test

class MainActivityTest {

    val TAG = "MainActivityTest"

    @Test
    fun `assert the generated number is in range`() {
        var isTrue = false
        val randomNumber = ScreenUtils.generateRandomizedNumber()
        if(randomNumber in 1..6) isTrue = true
        Assert.assertSame(true, isTrue)
    }

    @Test
    fun `test if the return drawable is valid`() {
        val randomNumber = ScreenUtils.generateRandomizedNumber();
        val drawableResource = ScreenUtils.getDrawableResInt(randomNumber)

        val drawableResource2 = when (randomNumber) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        assertEquals(drawableResource, drawableResource2);
        Log.d(TAG, "test if the return drawable is valid: " + drawableResource)
    }

}