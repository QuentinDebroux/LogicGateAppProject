package com.example.logicgateappproject.operators

import android.content.Context
import com.example.logicgateappproject.R

class Not(inPosX: Float, inPosY: Float, context: Context): LogicGate(inPosX, inPosY, context) {

    companion object {
        var spriteId = R.drawable.not
    }
    override fun onCreate() {   //This function is called when the object is created.
        super.onCreate()
    }

    override fun compute() {
        val size = inputs.size

        when(size) {    //The output is on if the input is off.
            0 -> { state = 0 }
            1 -> { if (inputs[0].state==0) { state = 1 } else { state = 0} }
        }
    }
}
