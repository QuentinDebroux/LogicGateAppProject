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

    protected lateinit var name: TextView
    protected lateinit var description: TextView
    protected lateinit var lgSprite: ImageView

    protected val switch1: NormalSwitch = NormalSwitch(0f, 0f, this)
    protected val switch2: NormalSwitch = NormalSwitch(0f, 0f, this)
    lateinit var lg: LogicGate

    protected lateinit var s1: ImageView
    protected lateinit var s2: ImageView
    protected lateinit var light: ImageView

    open fun onConstruct() {
        s1 = findViewById(R.id.s1)
        s2 = findViewById(R.id.s2)
        light = findViewById(R.id.light)

        s1.setImageResource(R.drawable.normal_switch_off)
        s2.setImageResource(R.drawable.normal_switch_off)
        light.setImageResource(R.drawable.lit_off_light_bulb)
        switchStateLight()

        lg.connectIn(input = switch1)
        lg.connectIn(input = switch2)

        s1.setOnClickListener {
            switch1.switchState()
            switchStateSprite(s1, switch1.state)
            switchStateLight()
        }

        s2.setOnClickListener {
            switch2.switchState()
            switchStateSprite(s2, switch2.state)
            switchStateLight()
        }
    }

    fun switchStateSprite(switch: ImageView, state: Int) {
        when(state) {
            0 -> {switch.setImageResource(R.drawable.normal_switch_off)}
            1 -> {switch.setImageResource(R.drawable.normal_switch_on)}
        }
    }

    fun switchStateLight() {
        when(lg.state) {
            0 -> {light.setImageResource(R.drawable.lit_off_light_bulb)}
            1 -> {light.setImageResource(R.drawable.lit_on_light_bulb)}
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val intent = Intent(this, TutorialsMenu::class.java)
        startActivity(intent)
    }
}