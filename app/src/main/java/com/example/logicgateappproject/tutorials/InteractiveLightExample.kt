package com.example.logicgateappproject.tutorials

import android.content.Intent
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.logicgateappproject.R
import com.example.logicgateappproject.TutorialsMenu
import com.example.logicgateappproject.operators.Light
import com.example.logicgateappproject.operators.NormalSwitch

abstract class InteractiveLightExample: AppCompatActivity() {

    // The following variables are used in the tutorial to display the name, description, and sprite of the gate.

    protected lateinit var name: TextView
    protected lateinit var description: TextView

    protected var switch1: NormalSwitch = NormalSwitch(0f, 0f, this)
    protected var switch2: NormalSwitch = NormalSwitch(0f, 0f, this)
    protected var switch3: NormalSwitch = NormalSwitch(0f, 0f, this)
    protected var switch4: NormalSwitch = NormalSwitch(0f, 0f, this)
    protected lateinit var light: Light

    protected lateinit var s1: ImageView
    protected lateinit var s2: ImageView
    protected lateinit var s3: ImageView
    protected lateinit var s4: ImageView
    protected lateinit var l: ImageView

    open fun onConstruct() {
        s1 = findViewById(R.id.s1__light)   //Links to xml file
        s2 = findViewById(R.id.s2__light)
        s3 = findViewById(R.id.s3__light)
        s4 = findViewById(R.id.s4__light)

        s1.setImageResource(R.drawable.normal_switch_off)
        s2.setImageResource(R.drawable.normal_switch_off)
        s3.setImageResource(R.drawable.normal_switch_off)
        s4.setImageResource(R.drawable.normal_switch_off)

        light.connectIn(input = switch1)    //Connects the switches to the light
        light.connectIn(input = switch2)
        light.connectIn(input = switch3)
        light.connectIn(input = switch4)

        //When the switches are clicked, their state and their sprite are changed
        s1.setOnClickListener {
            switch1.switchState()
            switchSpriteSwitch(s1, switch1.state)
            switchSpriteLight()
        }
        s2.setOnClickListener {
            switch2.switchState()
            switchSpriteSwitch(s2, switch2.state)
            switchSpriteLight()
        }
        s3.setOnClickListener {
            switch3.switchState()
            switchSpriteSwitch(s3, switch3.state)
            switchSpriteLight()
        }
        s4.setOnClickListener {
            switch4.switchState()
            switchSpriteSwitch(s4, switch4.state)
            switchSpriteLight()
        }
    }

    fun switchSpriteSwitch(switch: ImageView, state: Int) { //Changes the sprite of the switch depending on the state
        when(state) {
            0 -> {switch.setImageResource(R.drawable.normal_switch_off)}
            1 -> {switch.setImageResource(R.drawable.normal_switch_on)}
        }
    }

    abstract fun switchSpriteLight()

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val intent = Intent(this, TutorialsMenu::class.java)    //Links to the TutorialsMenu
        startActivity(intent)
    }
}
