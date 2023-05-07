package com.example.logicgateappproject.tutorials

import android.annotation.SuppressLint
import android.content.Intent
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.logicgateappproject.R
import com.example.logicgateappproject.TutorialsMenu
import com.example.logicgateappproject.operators.ExactLight
import com.example.logicgateappproject.operators.Switch

abstract class InteractiveSwitchExample: AppCompatActivity() {

    lateinit var name: TextView
    lateinit var description: TextView

    lateinit var switch: Switch
    var light: ExactLight = ExactLight(0f, 0f, this, 1)

    lateinit var s: ImageView
    lateinit var l: ImageView

    @SuppressLint("MissingInflatedId")
    open fun onConstruct() {
        l = findViewById(R.id.light__switch)

        l.setImageResource(R.drawable.lit_off_light_bulb)
        switchStateLight()

        light.connectIn(input = switch)

        s.setOnClickListener {
            switch.switchState()
            switchStateSprite(s, switch.state)
            switchStateLight()
        }
    }

    abstract fun switchStateSprite(switch: ImageView, state: Int)

    fun switchStateLight() {
        when(light.state) {
            0 -> {l.setImageResource(R.drawable.lit_off_light_bulb)}
            1 -> {l.setImageResource(R.drawable.lit_on_light_bulb)}
        }
    }

    override fun onBackPressed() {
        val intent = Intent(this, TutorialsMenu::class.java)
        startActivity(intent)
    }
}