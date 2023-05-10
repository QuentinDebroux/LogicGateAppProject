package com.example.logicgateappproject.operators

import android.content.Context
import com.example.logicgateappproject.R

class Or(inPosX: Float, inPosY: Float, context: Context): LogicGate(inPosX, inPosY, context) {

    companion object {
        var spriteId = R.drawable.or
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun compute() {
        val size = inputs.size

        when(size) {    //The output is on if at least one input is on.
            0 -> { state = 0 }
            1 -> { state = inputs[0].state }
            2 -> { if (inputs[0].state+inputs[1].state>0) { state = 1 } else { state = 0 }}
        }
    }
}
