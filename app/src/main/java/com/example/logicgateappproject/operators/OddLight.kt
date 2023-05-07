package com.example.logicgateappproject.operators

import android.content.Context
import com.example.logicgateappproject.R

class OddLight(inPosX: Float, inPosY: Float, context: Context, max : Int = 5): Light(inPosX, inPosY, context, max) {

    override fun onCreate() {
        super.onCreate()
        spriteId = R.drawable.lit_off_light_bulb
    }

    //Light is on if the number of on inputs is odd
    override fun compute() {
        var nb_of_on = 0
        for (input in inputs){
            if (input.state == 1){
                nb_of_on++
            }
        }


        when(nb_of_on%2) {
            0 -> { state = 0 }
            1 -> { state = 1 }
        }

        super.compute()
    }
}