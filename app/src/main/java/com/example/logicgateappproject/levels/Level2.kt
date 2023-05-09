package com.example.logicgateappproject.levels

import android.os.Bundle
import com.example.logicgateappproject.operators.*

class Level2: Level() {
    private var h: Float = 1f
    private var w: Float = 1f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        h = levelView.screenHeight
        w = levelView.screenWidth
        levelView.levelName = "Level 2"
    }

    override fun declareOperators() {
        //Create operators and put them in the list
        levelView.operators.add(MoreThanLight(w/2, h/4, this, 3, 2)) //0

        levelView.operators.add(Xor(2.5f*w/7, 5*h/8, this)) //1
        levelView.operators.add(And(4.5f*w/7, 5*h/8, this)) //2

        levelView.operators.add(ClockSwitch(w/6, h/2, this)) //3
        levelView.operators.add(NormalSwitch(w/4, 3*h/4, this)) //4
        levelView.operators.add(TimerSwitch(w/2, 3*h/4, this)) //5
        levelView.operators.add(TimerSwitch(3*w/4, 3*h/4, this)) //6

        //Connect operators
        connectOperators(output = levelView.operators[0],input = levelView.operators[3])
        connectOperators(output = levelView.operators[0],input = levelView.operators[1])
        connectOperators(output = levelView.operators[0],input = levelView.operators[2])

        connectOperators(output = levelView.operators[1],input = levelView.operators[4])
        connectOperators(output = levelView.operators[1],input = levelView.operators[5])
        connectOperators(output = levelView.operators[2],input = levelView.operators[5])
        connectOperators(output = levelView.operators[2],input = levelView.operators[6])

        //verifies if the level is cleared
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
