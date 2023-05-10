package com.example.logicgateappproject.operators

import android.content.Context
import com.example.logicgateappproject.R
import android.os.Handler
import android.os.Looper


class TimerSwitch(inPosX: Float, inPosY: Float, context: Context, private val DURATION : Long = 1000): Switch(inPosX, inPosY, context) {

    private val handler = Handler(Looper.getMainLooper())
    //The Handler allows you to post a Runnable (a task that will be executed)
    //to the main/UI thread.
    //In Android, only the main thread is allowed to modify the user interface (views),
    //otherwise you'll get the "CalledFromWrongThreadException" error.

    override fun onCreate() {
        super.onCreate()
        spriteId = R.drawable.timer_switch_off
    }

    //Switch is turned on for DURATION
    override fun switchState() {
        /*switches state
        And send a message to connected operators to compute their state*/

        if (state == 0) {
            state = 1
            spriteId = R.drawable.timer_switch_on  //Set the sprite of the object.
            handler.postDelayed({   //The Runnable will be executed after the specified amount of time.
                state = 0
                spriteId = R.drawable.timer_switch_off //Set the sprite of the object.
            }, DURATION)    //DURATION is the amount of time in milliseconds.
        }
    }
}
