package com.example.logicgateappproject.tutorials

import android.os.Bundle
import com.example.logicgateappproject.R
import com.example.logicgateappproject.operators.Not

class NotGateExample: InteractiveGateExample() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.interactive_gate_example)

        name = findViewById(R.id.lgName)
        description = findViewById(R.id.description)
        lgSprite = findViewById(R.id.gateSprite)

        name.setText(R.string.not)
        description.setText(R.string.notDesc)
        lgSprite.setImageResource(R.drawable.not)

        lg = Not(0f, 0f, this)
        onConstruct()
    }

    override fun onConstruct() {
        s1 = findViewById(R.id.s1)
        light = findViewById(R.id.light)

        lg.connectIn(input = switch1)

        s1.setImageResource(R.drawable.normal_switch_off)
        light.setImageResource(R.drawable.lit_off_light_bulb)
        switchStateLight()

        s1.setOnClickListener {
            switch1.switchState()
            switchStateSprite(s1, switch1.state)
            switchStateLight()
        }
    }
}