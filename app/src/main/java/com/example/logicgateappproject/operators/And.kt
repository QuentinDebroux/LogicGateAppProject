package com.example.logicgateappproject.operators

import android.content.Context
import com.example.logicgateappproject.R

class And(inPosX: Float, inPosY: Float, context: Context): LogicGate(inPosX, inPosY, context) {

    companion object {
        var spriteId = R.drawable.and
    }

    override fun onCreate() {
        super.onCreate()

    }

    //And is on if all inputs are on

    override fun compute() {
        val size = inputs.size

        when(size) {
            0 -> { state = 0 }
            1 -> { state = inputs[0].state }
            2 -> { state = inputs[0].state*inputs[1].state }
        }
    }
}
