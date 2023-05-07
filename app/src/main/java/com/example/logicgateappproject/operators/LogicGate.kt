package com.example.logicgateappproject.operators

import android.content.Context

abstract class LogicGate(inPosX: Float, inPosY: Float, context: Context): Operator(inPosX, inPosY, context) {

    lateinit var inputs: ArrayList<Operator>
    lateinit var outputs: ArrayList<Operator>

    override fun onCreate() {
        //paint.color = Color.BLUE                             /*Remplacer par une image*/
        inputs = ArrayList<Operator>()
        outputs = ArrayList<Operator>()
    }

    open fun connectIn(input: Any) {
        /*if the inputs list isn't full: adds the reference of
        the input logic gate to the inputs of
        the current logic gate
        And sends a message to add the reference of
        the current logic gate to the outputs of
        the input logic gate*/

        if (input !in inputs){
            if (input is LogicGate) {
                if (inputs.size < 2) {
                    inputs.add(input)
                    input.connectOut(this)
                    compute()
                }
            } else if (input is Switch) {
                if (inputs.size < 2) {
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

        if ((output !in outputs) && (output is LogicGate)) { outputs.add(output) }
        else if ((output !in outputs) && (output is Light)) { outputs.add(output) }
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