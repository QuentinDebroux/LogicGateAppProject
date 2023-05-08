package com.example.logicgateappproject.tutorials

import android.os.Bundle
import com.example.logicgateappproject.R
import com.example.logicgateappproject.operators.Xor

class XorGateExample: InteractiveGateExample() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.interactive_gate_example)   // Link to the layout file

        //Redefine the variables from the InteractiveGateExample

        name = findViewById(R.id.lgName)
        description = findViewById(R.id.description)
        lgSprite = findViewById(R.id.gateSprite)

        name.setText(R.string.xor)
        description.setText(R.string.xorDesc)
        lgSprite.setImageResource(R.drawable.xor)

        lg = Xor(0f, 0f, this)  // Create an Xor gate
        super.onConstruct()
    }
}