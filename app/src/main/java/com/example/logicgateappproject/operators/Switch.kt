package com.example.logicgateappproject.operators

import android.content.Context


abstract class Switch(inPosX: Float, inPosY: Float, context: Context): Operator(inPosX, inPosY, context) {

    lateinit var outputs: ArrayList<Operator>

    override fun onCreate() {
        outputs = ArrayList<Operator>()
        //paint.color = Color.GRAY
    }

    fun connectOut(output: Any) {
        /*adds the reference of
        the current logic gate to the outputs of
        the input logic gate*/

        if (output !in outputs) {
            when (output) {
                is LogicGate -> { outputs.add(output) }
                is Light -> { outputs.add(output) }
            }
        }
    }

    abstract fun switchState()

    override fun compute() {
        /*Switches state
        And send a message to connected operators to compute their state*/

        for (gate in outputs) {
            gate.compute()
        }
    }
}