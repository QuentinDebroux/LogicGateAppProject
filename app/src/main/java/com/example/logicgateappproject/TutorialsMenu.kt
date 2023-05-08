package com.example.logicgateappproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.logicgateappproject.operators.*
import com.example.logicgateappproject.tutorials.*

class TutorialsMenu: AppCompatActivity() {

    private val tutoNumber: Int = 10
    private lateinit var buttonContainer: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.levels_menu)
        buttonContainer = findViewById<LinearLayout>(R.id.buttonContainer)

        for (i in 1..tutoNumber) {
            val button = Button(this)
            when(i) {
                1 -> {
                    button.setText(R.string.and)
                    button.setOnClickListener() {
                        val intent = Intent(this, AndGateExample::class.java)
                        startActivity(intent)
                    }
                }
                2 -> {
                    button.setText(R.string.or)
                    button.setOnClickListener() {
                        val intent = Intent(this, OrGateExample::class.java)
                        startActivity(intent)
                    }
                }
                3 -> {
                    button.setText(R.string.xor)
                    button.setOnClickListener() {
                        val intent = Intent(this, XorGateExample::class.java)
                        startActivity(intent)
                    }
                }
                4 -> {
                    button.setText(R.string.not)
                    button.setOnClickListener() {
                        val intent = Intent(this, NotGateExample::class.java)
                        startActivity(intent)
                    }
                }
                5 -> {
                    button.setText(R.string.ClockSwitch)
                    button.setOnClickListener() {
                        val intent = Intent(this, ClockSwitchExample::class.java)
                        startActivity(intent)
                    }
                }
                6 -> {
                    button.setText(R.string.TimerSwitch)
                    button.setOnClickListener() {
                        val intent = Intent(this, TimerSwitchExample::class.java)
                        startActivity(intent)
                    }
                }
                7 -> {
                    button.setText(R.string.MoreThanLight)
                    button.setOnClickListener() {
                        val intent = Intent(this, MoreThanLightExample::class.java)
                        startActivity(intent)
                    }
                }
                8 -> {
                    button.setText(R.string.ExactLight)
                    button.setOnClickListener() {
                        val intent = Intent(this, ExactLightExample::class.java)
                        startActivity(intent)
                    }
                }
                9 -> {
                    button.setText(R.string.EvenLight)
                    button.setOnClickListener() {
                        val intent = Intent(this, EvenLightExample::class.java)
                        startActivity(intent)
                    }
                }
                10 -> {
                    button.setText(R.string.OddLight)
                    button.setOnClickListener() {
                        val intent = Intent(this, OddLightExample::class.java)
                        startActivity(intent)
                    }
                }
                else -> { button.text = "Tutorial $i" }
            }
            buttonContainer.addView(button)
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val intent = Intent(this, Menu::class.java)
        startActivity(intent)
    }
}