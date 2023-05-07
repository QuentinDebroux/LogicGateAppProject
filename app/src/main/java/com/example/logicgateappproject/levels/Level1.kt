package com.example.logicgateappproject.levels

import com.example.logicgateappproject.operators.ExactLight
import com.example.logicgateappproject.operators.NormalSwitch

class Level1: Level() {
    private var h: Float = 1f
    private var w: Float = 1f

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        h = levelView.screenHeight
        w = levelView.screenWidth
    }*/

    override fun declareOperators() {
        //Create operators and put them in the list
        levelView.operators.add(ExactLight(w/2, h/4, this, 1, 1))
        levelView.operators.add(NormalSwitch(w/2, 3*h/4, this))

        //Connect operators
        connectOperators(levelView.operators[0], levelView.operators[1])
    }
}