package com.example.logicgateappproject.operators

import android.content.Context
import com.example.logicgateappproject.R

class EvenLight(inPosX: Float, inPosY: Float, context: Context, max : Int = 5): Light(inPosX, inPosY, context, max) {

    override fun onCreate() {
        super.onCreate()
        spriteId = R.drawable.lit_off_light_bulb
    }

    //Light is on if the number of on inputs is even
    override fun compute() {
        var nb_of_on = 0
        for (input in inputs){
            if (input.state == 1){
                nb_of_on++
            }
        }


        when(nb_of_on%2) {
            0 -> { state = 1 }
            1 -> { state = 0 }
        }

        super.compute()
    }
}