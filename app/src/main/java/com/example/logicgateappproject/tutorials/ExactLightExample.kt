package com.example.logicgateappproject.tutorials

import android.annotation.SuppressLint
import android.os.Bundle
import com.example.logicgateappproject.R
import com.example.logicgateappproject.operators.ExactLight
import com.example.logicgateappproject.operators.NormalSwitch

class ExactLightExample:InteractiveLightExample() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.interactive_light_example)  // Link to the layout file

        //Redefine the variables from the InteractiveLightExample
        name = findViewById(R.id.lName)
        description = findViewById(R.id.description__light)
        l = findViewById(R.id.light__light)

        name.setText(R.string.ExactLight)
        description.setText(R.string.exactlightDesc)
        l.setImageResource(R.drawable.lit_off_light_bulb_exact)

        light = ExactLight(0f, 0f, this, 4, 2)
        switch1 = NormalSwitch(0f, 0f, this)
        onConstruct()
    }

    override fun switchSpriteLight() {  // Change the image of the light bulb depending on the state of the light
        when(light.state) {
            0 -> {l.setImageResource(R.drawable.lit_off_light_bulb_exact)}
            1 -> {l.setImageResource(R.drawable.lit_on_light_bulb_exact)}
        }
    }
}
