package com.example.logicgateappproject.tutorials

import android.os.Bundle
import android.widget.ImageView
import com.example.logicgateappproject.R
import com.example.logicgateappproject.operators.ClockSwitch
import kotlinx.coroutines.*

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

    override fun onConstruct() {
        l = findViewById(R.id.light__switch)

        l.setImageResource(R.drawable.lit_off_light_bulb)
        switchStateLight()

        light.connectIn(input = switch)

        var on = false
        lateinit var switch_on_thread: Job

        s.setOnClickListener {
            if (!on) {
                on = true
                switch.switchState()
                switch_on_thread = GlobalScope.launch {
                    while (on) {
                        withContext(Dispatchers.Main) {
                            //println(switch.state)
                            switchStateSprite(s, switch.state)
                            switchStateLight()
                        }
                    }
                }
            }
            else{
                on = false
                switch.switchState()
                switch_on_thread.cancel()
                switchStateSprite(s, switch.state)
                switchStateLight()
            }
        }

    }

    override fun switchStateSprite(switch: ImageView, state: Int) {
        when(state) {
            0 -> {switch.setImageResource(R.drawable.clock_switch_off)}
            1 -> {switch.setImageResource(R.drawable.clock_switch_on)}
        }
    }
}