package com.example.logicgateappproject.tutorials

import android.os.Bundle
import android.widget.ImageView
import com.example.logicgateappproject.R
import com.example.logicgateappproject.operators.ClockSwitch

class ClockSwitchExample: InteractiveSwitchExample() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.interactive_switch_example)

        name = findViewById(R.id.swName)
        description = findViewById(R.id.description__switch)
        s = findViewById(R.id.switch__switch)

        name.setText(R.string.ClockSwitch)
        description.setText(R.string.clockswitchDesc)
        s.setImageResource(R.drawable.clock_switch_off)

        switch = ClockSwitch(0f, 0f, this, 500)
        onConstruct()
    }

    override fun switchStateSprite(switch: ImageView, state: Int) {
        when(state) {
            0 -> {switch.setImageResource(R.drawable.clock_switch_off)}
            1 -> {switch.setImageResource(R.drawable.clock_switch_on)}
        }
    }
}