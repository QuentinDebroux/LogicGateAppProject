package com.example.logicgateappproject.operators

import android.content.Context


abstract class Switch(inPosX: Float, inPosY: Float, context: Context): Operator(inPosX, inPosY, context) {

    private lateinit var outputs: ArrayList<Operator>   //List of operators that the current logic gate is outputting to

    override fun onCreate() {
        outputs = ArrayList<Operator>()
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
        switchState()
    }

    override fun callCompute() {
        //Sends a message to connected operators to compute their state
        for (gate in outputs) {
            gate.compute()
        }
    }
}
