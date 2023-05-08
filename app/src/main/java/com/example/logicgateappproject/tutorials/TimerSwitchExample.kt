package com.example.logicgateappproject.tutorials

import android.os.Bundle
import android.widget.ImageView
import com.example.logicgateappproject.R
import com.example.logicgateappproject.operators.TimerSwitch
import java.util.*
import android.os.Handler
import android.os.Looper


class TimerSwitchExample: InteractiveSwitchExample() {


    val DURATION : Long = 1000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.interactive_switch_example)

        name = findViewById(R.id.swName)
        description = findViewById(R.id.description__switch)
        s = findViewById(R.id.switch__switch)

        name.setText(R.string.TimerSwitch)
        description.setText(R.string.timerswitchDesc)
        s.setImageResource(R.drawable.timer_switch_off)

        switch = TimerSwitch(0f, 0f, this, DURATION)
        onConstruct()
    }

    override fun onConstruct() {

        l = findViewById(R.id.light__switch)
        l.setImageResource(R.drawable.lit_off_light_bulb)
        switchSpriteLight()

        light.connectIn(input = switch)
        val handler = Handler(Looper.getMainLooper())
        //The Handler allows you to post a Runnable (a task that will be executed)
        //to the main/UI thread.
        //In Android, only the main thread is allowed to modify the user interface (views),
        //otherwise you'll get the "CalledFromWrongThreadException" error.
        s.setOnClickListener {
            if (switch.state == 0) {
                switch.switchState()
                switchSpriteSwitch(s, switch.state)
                switchSpriteLight()
                handler.postDelayed({
                    switchSpriteSwitch(s, switch.state)
                    switchSpriteLight()
                }, DURATION)
            }
        }
    }

    override fun switchSpriteSwitch(switch: ImageView, state: Int) {
        when(state) {
            0 -> {switch.setImageResource(R.drawable.timer_switch_off)}
            1 -> {switch.setImageResource(R.drawable.timer_switch_on)}
        }
    }
}
