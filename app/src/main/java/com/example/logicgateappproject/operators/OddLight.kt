package com.example.logicgateappproject.operators

import android.content.Context
import com.example.logicgateappproject.R

class OddLight(inPosX: Float, inPosY: Float, context: Context, max : Int = 5): Light(inPosX, inPosY, context, max) {

    override fun onCreate() {       //This function is called when the object is created.
        super.onCreate()
        spriteId = R.drawable.lit_off_light_bulb
    }

    //Light is on if the number of on inputs is odd
    override fun compute() {
        var nb_of_on = 0
        for (input in inputs){    //Count the number of on inputs.
            if (input.state == 1){  //If the input is on, increment the counter.
                nb_of_on++
            }
        }


        when(nb_of_on%2) {  //If the number of on inputs is odd, the light is on.
            0 -> { state = 0 }
            1 -> { state = 1 }
        }

        super.compute()
    }
}