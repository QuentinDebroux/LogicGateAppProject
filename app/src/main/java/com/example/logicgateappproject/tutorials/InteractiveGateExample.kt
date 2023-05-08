package com.example.logicgateappproject.tutorials

import android.content.Intent
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.logicgateappproject.R
import com.example.logicgateappproject.TutorialsMenu
import com.example.logicgateappproject.operators.LogicGate
import com.example.logicgateappproject.operators.NormalSwitch

abstract class InteractiveGateExample: AppCompatActivity() {

    // The following variables are used in the tutorial to display the name, description, and sprite of the gate.

    protected lateinit var name: TextView
    protected lateinit var description: TextView
    protected lateinit var lgSprite: ImageView

    protected val switch1: NormalSwitch = NormalSwitch(0f, 0f, this)
    protected val switch2: NormalSwitch = NormalSwitch(0f, 0f, this)
    protected lateinit var lg: LogicGate

    protected lateinit var s1: ImageView
    protected lateinit var s2: ImageView
    protected lateinit var l: ImageView

    open fun onConstruct() {
        s1 = findViewById(R.id.s1)   //Link to xml file
        s2 = findViewById(R.id.s2)   //Link to xml file
        l = findViewById(R.id.light) //Link to xml file

        s1.setImageResource(R.drawable.normal_switch_off)
        s2.setImageResource(R.drawable.normal_switch_off)
        l.setImageResource(R.drawable.lit_off_light_bulb)
        switchSpriteLight()

        lg.connectIn(input = switch1)   //Connects the switches to the gate
        lg.connectIn(input = switch2)

        s1.setOnClickListener {        //When the switch is clicked, their state and their sprite are changed
            switch1.switchState()
            switchSpriteSwitch(s1, switch1.state)
            switchSpriteLight()
        }

        s2.setOnClickListener {       //When the switch is clicked, their state and their sprite are changed
            switch2.switchState()
            switchSpriteSwitch(s2, switch2.state)
            switchSpriteLight()
        }
    }

    fun switchSpriteSwitch(switch: ImageView, state: Int) { //Changes the sprite of the switch depending on the state
        when(state) {
            0 -> {switch.setImageResource(R.drawable.normal_switch_off)}
            1 -> {switch.setImageResource(R.drawable.normal_switch_on)}
        }
    }

    fun switchSpriteLight() {   //Changes the sprite of the light depending on the state of the gate
        when(lg.state) {
            0 -> {l.setImageResource(R.drawable.lit_off_light_bulb)}
            1 -> {l.setImageResource(R.drawable.lit_on_light_bulb)}
        }
    }

    @Deprecated("Deprecated in Java")   //Deprecated function that is called when the back button is pressed
    override fun onBackPressed() {
        val intent = Intent(this, TutorialsMenu::class.java)    //Creates an intent to go back to the tutorial menu
        startActivity(intent)
    }
}
