package com.example.logicgateappproject.levels

import android.os.Bundle
import com.example.logicgateappproject.operators.*

class Level1: Level() {
    private var h: Float = 1f
    private var w: Float = 1f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        h = levelView.screenHeight
        w = levelView.screenWidth
        levelView.levelName = "Level 1"
    }

    override fun declareOperators() {
        //Create operators and put them in the list
        levelView.operators.add(ExactLight(w/2, h/4, this, 1, 1))

        levelView.operators.add(And(w/2, h/2, this))

        levelView.operators.add(NormalSwitch(w/3, 3*h/4, this))
        levelView.operators.add(NormalSwitch(2*w/3, 3*h/4, this))

        //Connect operators
        connectOperators(output = levelView.operators[0],input = levelView.operators[1])
        connectOperators(output = levelView.operators[1],input = levelView.operators[2])
        connectOperators(output = levelView.operators[1],input = levelView.operators[3])

        thread = Thread(Runnable {
            while (true) {
                if (levelView.operators[0].state == 1) {
                    levelView.win = true
                    println("win")
                    break
                }
            }
        })
        thread.start()
    }
}
