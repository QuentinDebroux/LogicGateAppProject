package com.example.logicgateappproject.operators

import android.content.Context

abstract class LogicGate(inPosX: Float, inPosY: Float, context: Context): Operator(inPosX, inPosY, context) {

    protected lateinit var inputs: ArrayList<Operator>    //List of operators that the current logic gate is inputting from
    protected lateinit var outputs: ArrayList<Operator>   //List of operators that the current logic gate is outputting to

    override fun onCreate() {
        inputs = ArrayList<Operator>()
        outputs = ArrayList<Operator>()
    }

    override fun updateSize(nSize: Float) {
        super.updateSize(nSize)
        size*=2
    }

    open fun connectIn(input: Any) {
        /*if the inputs list isn't full: adds the reference of
        the input logic gate to the inputs of
        the current logic gate
        And sends a message to add the reference of
        the current logic gate to the outputs of
        the input logic gate*/

        if (input !in inputs){
            when(input) {
                is LogicGate -> {
                    inputs.add(input)
                    input.connectOut(this)
                    compute()
                }
                is Switch -> {
                    inputs.add(input)
                    input.connectOut(this)
                    compute()
                }
            }
        }
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

    override fun callCompute() {
        //Sends a message to connected operators to compute their state
        for (gate in outputs) {
            gate.compute()
        }
    }
}
