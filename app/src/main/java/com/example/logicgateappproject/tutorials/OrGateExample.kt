package com.example.logicgateappproject.tutorials

import android.os.Bundle
import com.example.logicgateappproject.R
import com.example.logicgateappproject.operators.Or

class OrGateExample: InteractiveGateExample() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.interactive_gate_example)

        name = findViewById(R.id.lgName)
        description = findViewById(R.id.description)
        lgSprite = findViewById(R.id.gateSprite)

        name.setText(R.string.or)
        description.setText(R.string.orDesc)
        lgSprite.setImageResource(R.drawable.or)

        lg = Or(0f, 0f, this)
        super.onConstruct()
    }
}