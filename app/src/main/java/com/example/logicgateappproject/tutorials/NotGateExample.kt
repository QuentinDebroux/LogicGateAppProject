package com.example.logicgateappproject.tutorials

import android.os.Bundle
import com.example.logicgateappproject.R
import com.example.logicgateappproject.operators.Not

class NotGateExample: InteractiveGateExample() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.interactive_gate_example)   // Link to the layout file

        //Redefine the variables from the InteractiveGateExample
        name = findViewById(R.id.lgName)
        description = findViewById(R.id.description)
        lgSprite = findViewById(R.id.gateSprite)

        name.setText(R.string.not)
        description.setText(R.string.notDesc)
        lgSprite.setImageResource(R.drawable.not)

        lg = Not(0f, 0f, this)
        onConstruct()
    }

    override fun onConstruct() {    // Redefine the variables from the InteractiveGateExample and s2 is not used
                                    // because the Not gate only has one input
        s1 = findViewById(R.id.s1)
        l = findViewById(R.id.light)

        lg.connectIn(input = switch1)   // Connect the switch to the Not gate

        s1.setImageResource(R.drawable.normal_switch_off)   // Set the image of the switch to off
        l.setImageResource(R.drawable.lit_off_light_bulb)   // Set the image of the light bulb to off
        switchSpriteLight()

        s1.setOnClickListener { // When the switch is clicked, change the state of the switch and the light
            switch1.switchState()
            switchSpriteSwitch(s1, switch1.state)
            switchSpriteLight()
        }
    }
}
