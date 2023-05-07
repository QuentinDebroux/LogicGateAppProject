package com.example.logicgateappproject.operators

import android.content.Context

abstract class Light(inPosX: Float, inPosY: Float, context: Context,val MAXINPUTS : Int = 5): Operator(inPosX, inPosY, context) {

    lateinit var outputs: ArrayList<Operator>
    lateinit var inputs: ArrayList<Operator>

    override fun onCreate() {
        //paint.color = Color.GREEN                             /*Remplacer par une image*/
        inputs = ArrayList<Operator>()
        outputs = ArrayList<Operator>()
    }

    fun connectIn(input: Any) {
        /*if the inputs list isn't full: adds the reference of
        the input logic gate to the inputs of
        the current logic gate
        And sends a message to add the reference of
        the current logic gate to the outputs of
        the input logic gate*/


        if ((input !in inputs) && (inputs.size < MAXINPUTS)) {
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