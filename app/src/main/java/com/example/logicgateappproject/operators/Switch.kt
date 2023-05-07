package com.example.logicgateappproject.operators

import android.content.Context

abstract class Switch(inPosX: Float, inPosY: Float, context: Context): Operator(inPosX, inPosY, context) {

    lateinit var outputs: ArrayList<LogicGate>

    override fun onCreate() {
        outputs = ArrayList<LogicGate>()
        //paint.color = Color.GRAY
    }

    fun connectOut(output: Any) {
        /*adds the reference of
        the current logic gate to the outputs of
        the input logic gate*/

        if ((output is LogicGate) && (output !in outputs)) { outputs.add(output) }
        //else if (output is Light) { outputs.add(output) }
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