package com.example.logicgateappproject.operators

import android.content.Context
import com.example.logicgateappproject.R

class Not(inPosX: Float, inPosY: Float, context: Context): LogicGate(inPosX, inPosY, context) {

    override fun onCreate() {
        super.onCreate()
        spriteId = R.drawable.not
    }

    override fun compute() {
        val size = inputs.size

        when(size) {
            0 -> { state = 0 }
            1 -> { if (inputs[0].state==0) { state = 1 } else { state = 0} }
        }

        super.compute()
    }
}