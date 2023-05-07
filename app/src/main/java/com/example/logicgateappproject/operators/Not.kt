package com.example.logicgateappproject.operators

import android.content.Context
import com.example.logicgateappproject.R

class Not(inPosX: Float, inPosY: Float, context: Context): LogicGate(inPosX, inPosY, context) {

    override fun onCreate() {
        super.onCreate()
        spriteId = R.drawable.not
    }

    override fun connectIn(input: Any) {
        /*if the inputs list isn't full: adds the reference of
        the input logic gate to the inputs of
        the current logic gate
        And sends a message to add the reference of
        the current logic gate to the outputs of
        the input logic gate*/

        if (input is LogicGate) {
            if (inputs.size == 0) {
                inputs.add(input)
                input.connectOut(this)
                compute()
            }
        }
        else if (input is Switch) {
            if (inputs.size == 0) {
                inputs.add(input)
                input.connectOut(this)
                compute()
            }
        }
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