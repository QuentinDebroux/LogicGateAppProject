package com.example.logicgateappproject.operators

import android.content.Context
import com.example.logicgateappproject.R

class Xor(inPosX: Float, inPosY: Float, context: Context): LogicGate(inPosX, inPosY, context) {

    companion object {
        var spriteId = R.drawable.xor
    }
    override fun onCreate() {   //This function is called when the object is created.
        super.onCreate()
    }

    override fun compute() {
        val size = inputs.size

        when(size) {    //The output is on if only one input is on.
            0 -> { state = 0 }
            1 -> { state = inputs[0].state }
            2 -> { state = (inputs[0].state+inputs[1].state)%2 }
        }

        super.compute()
    }
}