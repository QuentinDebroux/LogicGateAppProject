package com.example.logicgateappproject.operators

import android.content.Context
import com.example.logicgateappproject.R

class NormalSwitch(inPosX: Float, inPosY: Float, context: Context): Switch(inPosX, inPosY, context) {

    override fun onCreate() {
        super.onCreate()
        spriteId = R.drawable.normal_switch_off
    }

    override fun switchState() {
        //switchState
        /*switches state
        And send a message to connected operators to compute their state*/

        state = if (state == 1) 0 else 1
        spriteId = if (state == 0) R.drawable.normal_switch_off else R.drawable.normal_switch_on

        super.compute()
    }
}