package com.example.logicgateappproject.tutorials

import android.annotation.SuppressLint
import android.os.Bundle
import com.example.logicgateappproject.R
import com.example.logicgateappproject.operators.OddLight
import com.example.logicgateappproject.operators.NormalSwitch

class OddLightExample:InteractiveLightExample() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.interactive_light_example)

        name = findViewById(R.id.lName)
        description = findViewById(R.id.description__light)
        l = findViewById(R.id.light__light)

        name.setText(R.string.OddLight)
        description.setText(R.string.oddlightDesc)
        l.setImageResource(R.drawable.lit_off_light_bulb_odd)

        light = OddLight(0f, 0f, this, 4)
        switch1 = NormalSwitch(0f, 0f, this)
        onConstruct()
    }

    override fun switchStateLight() {
        when(light.state) {
            0 -> {l.setImageResource(R.drawable.lit_off_light_bulb_odd)}
            1 -> {l.setImageResource(R.drawable.lit_on_light_bulb_odd)}
        }
    }
}