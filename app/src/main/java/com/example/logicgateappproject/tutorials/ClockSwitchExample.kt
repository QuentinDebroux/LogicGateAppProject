package com.example.logicgateappproject.tutorials

import android.os.Bundle
import android.widget.ImageView
import com.example.logicgateappproject.R
import com.example.logicgateappproject.operators.ClockSwitch
import kotlinx.coroutines.*

class ClockSwitchExample: InteractiveSwitchExample() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.interactive_switch_example)     //Link to the layout file

        //Redefinition of the variables from InteractiveSwitchExample to suit the ClockSwitch
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
        l = findViewById(R.id.light__switch)    //Link to the light ImageView

        l.setImageResource(R.drawable.lit_off_light_bulb)   //Set the light to be off by default
        switchSpriteLight()

        light.connectIn(input = switch)         //Connect the light to the switch

        var on = false
        lateinit var switch_on_thread: Job    //Create a thread to check the state of the switch

        s.setOnClickListener {
            if (!on) {
                on = true
                switch.switchState()
                switch_on_thread = GlobalScope.launch {  //Launch a thread to check the state of the switch
                    while (on) {
                        withContext(Dispatchers.Main) {  //Only the main thread can change the UI so we use withContext to switch to it
                            switchSpriteSwitch(s, switch.state)
                            switchSpriteLight()
                        }
                    }
                }
            }
            else{   //If the switch is on, turn it off and cancel the thread
                on = false
                switch.switchState()
                switch_on_thread.cancel()
                switchSpriteSwitch(s, switch.state)
                switchSpriteLight()
            }
        }

    }

    override fun switchSpriteSwitch(switch: ImageView, state: Int) {    //Change the switch sprite depending on the state
        when(state) {
            0 -> {switch.setImageResource(R.drawable.clock_switch_off)}
            1 -> {switch.setImageResource(R.drawable.clock_switch_on)}
        }
    }
}
