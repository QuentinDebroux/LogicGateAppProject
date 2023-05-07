package com.example.logicgateappproject.tutorials

import android.os.Bundle
import android.widget.ImageView
import com.example.logicgateappproject.R
import com.example.logicgateappproject.operators.TimerSwitch

class TimerSwitchExample: InteractiveSwitchExample() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.interactive_switch_example)

        name = findViewById(R.id.swName)
        description = findViewById(R.id.description__switch)
        s = findViewById(R.id.switch__switch)

        name.setText(R.string.TimerSwitch)
        description.setText(R.string.timerswitchDesc)
        s.setImageResource(R.drawable.timer_switch_off)

        switch = TimerSwitch(0f, 0f, this, 1000)
        onConstruct()
    }

    override fun switchStateSprite(switch: ImageView, state: Int) {
        when(state) {
            0 -> {switch.setImageResource(R.drawable.timer_switch_off)}
            1 -> {switch.setImageResource(R.drawable.timer_switch_on)}
        }
    }
}