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

    lateinit var name: TextView
    lateinit var description: TextView

    var switch1: NormalSwitch = NormalSwitch(0f, 0f, this)
    var switch2: NormalSwitch = NormalSwitch(0f, 0f, this)
    var switch3: NormalSwitch = NormalSwitch(0f, 0f, this)
    var switch4: NormalSwitch = NormalSwitch(0f, 0f, this)
    lateinit var light: Light

    lateinit var s1: ImageView
    lateinit var s2: ImageView
    lateinit var s3: ImageView
    lateinit var s4: ImageView
    lateinit var l: ImageView

    open fun onConstruct() {
        s1 = findViewById(R.id.s1__light)
        s2 = findViewById(R.id.s2__light)
        s3 = findViewById(R.id.s3__light)
        s4 = findViewById(R.id.s4__light)

        s1.setImageResource(R.drawable.normal_switch_off)
        s2.setImageResource(R.drawable.normal_switch_off)
        s3.setImageResource(R.drawable.normal_switch_off)
        s4.setImageResource(R.drawable.normal_switch_off)

        light.connectIn(input = switch1)
        light.connectIn(input = switch2)
        light.connectIn(input = switch3)
        light.connectIn(input = switch4)

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
        s3.setOnClickListener {
            switch3.switchState()
            switchStateSprite(s3, switch3.state)
            switchStateLight()
        }
        s4.setOnClickListener {
            switch4.switchState()
            switchStateSprite(s4, switch4.state)
            switchStateLight()
        }
    }

    fun switchStateSprite(switch: ImageView, state: Int) {
        when(state) {
            0 -> {switch.setImageResource(R.drawable.normal_switch_off)}
            1 -> {switch.setImageResource(R.drawable.normal_switch_on)}
        }
    }

    abstract fun switchStateLight()

    override fun onBackPressed() {
        val intent = Intent(this, TutorialsMenu::class.java)
        startActivity(intent)
    }
}