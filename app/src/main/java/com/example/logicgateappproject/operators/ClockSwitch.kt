package com.example.logicgateappproject.operators

import android.content.Context
import com.example.logicgateappproject.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ClockSwitch(inPosX: Float, inPosY: Float, context: Context, private val DELAY : Long = 500): Switch(inPosX, inPosY, context) {
    private var on = false
    private lateinit var threadclock: Job   //Job represents a running task, initialized to null.
    // It is part of the coroutine package. Here, it represents the
    //coroutine used to make the switch blink. Since it is
    //initialized to null, threadclock is also initialized to null,
    //indicating that we have not yet created a coroutine for this
    //instance of ClockSwitch. When the coroutine is created with
    //launch(), threadclock is set to the corresponding Job instance.

    override fun onCreate() { //This function is called when the object is created.
        super.onCreate()
        spriteId = R.drawable.clock_switch_off
    }

    override fun switchState(){ //This function is called when the object is clicked.

        if (!on) {
            on = true  //This variable is used to know if the coroutine is running or not.
            state = 1
            threadclock = GlobalScope.launch {
                while (on) {
                    state = if (state == 1) 0 else 1    //Switch the state of the object.
                    spriteId = if (state == 0) R.drawable.clock_switch_off else R.drawable.clock_switch_on  //Change the sprite of the switch.
                    delay(DELAY)
                }
            }
        }
        else {
            on = false
            threadclock.cancel()    //Cancel the coroutine.
            state = 0
            spriteId = if (state == 0) R.drawable.clock_switch_off else R.drawable.clock_switch_on  //Change the sprite of the switch.
        }
    }
}
