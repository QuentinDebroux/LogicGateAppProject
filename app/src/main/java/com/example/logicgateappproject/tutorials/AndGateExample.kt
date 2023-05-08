package com.example.logicgateappproject.tutorials

import android.os.Bundle
import com.example.logicgateappproject.R
import com.example.logicgateappproject.operators.And

class AndGateExample: InteractiveGateExample() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.interactive_gate_example)

        name = findViewById(R.id.lgName)    // name is a TextView
        description = findViewById(R.id.description)    // description is a TextView
        lgSprite = findViewById(R.id.gateSprite)        // lgSprite is an ImageView

        name.setText(R.string.and)
        description.setText(R.string.andDesc)
        lgSprite.setImageResource(R.drawable.and)

        lg = And(0f, 0f, this)  // lg is an And object
        super.onConstruct()
    }
}