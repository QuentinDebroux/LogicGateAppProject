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
import kotlinx.coroutines.*

abstract class InteractiveSwitchExample: AppCompatActivity() {

    protected lateinit var name: TextView
    protected lateinit var description: TextView

    protected lateinit var switch: Switch
    protected var light: ExactLight = ExactLight(0f, 0f, this, 1)

    protected lateinit var s: ImageView
    protected lateinit var l: ImageView

    @SuppressLint("MissingInflatedId")
    abstract fun onConstruct()

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