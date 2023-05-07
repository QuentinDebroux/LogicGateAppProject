package com.example.logicgateappproject.operators

import android.content.Context
import android.graphics.RectF

abstract class LogicGate(inPosX: Float, inPosY: Float, context: Context): Operator(inPosX, inPosY, context) {

    lateinit var inputs: ArrayList<Operator>
    lateinit var outputs: ArrayList<Operator>

    override fun onCreate() {
        size*=2
        inputs = ArrayList<Operator>()
        outputs = ArrayList<Operator>()
    }

    override fun updateSize(sz: Float) {
        super.updateSize(sz)
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

    override fun compute() {
        /*computes the state of the current logic gate
        depending on which logic gate it is
        And send a message to connected operators to compute their state*/

        for (gate in outputs) {
            gate.compute()
        }
    }

}