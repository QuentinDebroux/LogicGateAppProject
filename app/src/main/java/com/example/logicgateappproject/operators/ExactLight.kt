package com.example.logicgateappproject.operators

import android.content.Context
import com.example.logicgateappproject.R

class ExactLight(inPosX: Float, inPosY: Float, context: Context, max : Int = 5, nbNeeded: Int = 1): Light(inPosX, inPosY, context, max) {

    val NB_NEEDED: Int = nbNeeded

    override fun onCreate() {   //This function is called when the object is created.
        super.onCreate()
        spriteId = R.drawable.lit_off_light_bulb_exact
    }

    //Light is on if the number of on inputs is exactly equal to NB_NEEDED
    override fun compute() {    //This function is called when the object is clicked.
        var nb_of_on = 0
        for (input in inputs){
            if (input.state == 1){  //If the input is on, increment the counter.
                nb_of_on++
            }
        }

        if (nb_of_on == NB_NEEDED) {    //If the number of on inputs is exactly equal to NB_NEEDED, the light is on.
            state = 1
        }
        else {state = 0}    //Else, the light is off.

        spriteId = if (state == 0) R.drawable.lit_off_light_bulb_exact else R.drawable.lit_on_light_bulb_exact   //Set the sprite of the object.

        super.compute()
    }
}