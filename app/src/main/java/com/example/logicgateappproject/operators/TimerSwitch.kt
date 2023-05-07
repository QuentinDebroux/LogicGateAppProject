package com.example.logicgateappproject.operators

import android.content.Context
import com.example.logicgateappproject.R
import java.util.*

class TimerSwitch(inPosX: Float, inPosY: Float, context: Context, DURATION : Int = 1000): Switch(inPosX, inPosY, context) {

    val DURATION : Int = DURATION

    override fun onCreate() {
        super.onCreate()
        spriteId = R.drawable.normal_switch_off
    }

    //Switch is turned on for DURATION
    override fun switchState() {
        /*switches state
        And send a message to connected operators to compute their state*/

        if (state == 0) {
            state = 1
            Timer().schedule(object : TimerTask() {
                override fun run() {
                    state = 0
                }
            }, DURATION.toLong())
        } else {
            state = 0
        }

        super.compute()
    }
}