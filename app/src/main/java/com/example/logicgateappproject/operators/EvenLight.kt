package com.example.logicgateappproject.operators

import android.content.Context
import com.example.logicgateappproject.R

class EvenLight(inPosX: Float, inPosY: Float, context: Context, max : Int = 5): Light(inPosX, inPosY, context, max) {

    override fun onCreate() {   //This function is called when the object is created.
        super.onCreate()
        spriteId = R.drawable.lit_off_light_bulb    //Set the sprite of the object.
    }

    //Light is on if the number of on inputs is even
    override fun compute() {    //This function is called when the object is clicked.
        var nb_of_on = 0    //Count the number of on inputs.
        for (input in inputs){
            if (input.state == 1){  //If the input is on, increment the counter.
                nb_of_on++
            }
        }


        when(nb_of_on%2) {  //If the number of on inputs is even, the light is on.
            0 -> { state = 1 }
            1 -> { state = 0 }
        }
    }
}
