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
    private lateinit var buttonContainer: LinearLayout  //container for the buttons

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.levels_menu)    // Link to the layout file
        buttonContainer = findViewById<LinearLayout>(R.id.buttonContainer)  // Link to the button container from the layout file

        for (i in 1..tutoNumber) {  //create a button for each tutorial
            val button = Button(this)
            when(i) {
                1 -> {
                    button.setText(R.string.and)
                    button.setOnClickListener() {
                        val intent = Intent(this, AndGateExample::class.java)
                        startActivity(intent)   //when the button is clicked, go to the and gate tutorial
                    }
                }
                2 -> {
                    button.setText(R.string.or)
                    button.setOnClickListener() {
                        val intent = Intent(this, OrGateExample::class.java)
                        startActivity(intent)   //when the button is clicked, go to the or gate tutorial
                    }
                }
                3 -> {
                    button.setText(R.string.xor)
                    button.setOnClickListener() {
                        val intent = Intent(this, XorGateExample::class.java)
                        startActivity(intent)   //when the button is clicked, go to the xor gate tutorial
                    }
                }
                4 -> {
                    button.setText(R.string.not)
                    button.setOnClickListener() {
                        val intent = Intent(this, NotGateExample::class.java)
                        startActivity(intent)   //when the button is clicked, go to the not gate tutorial
                    }
                }
                5 -> {
                    button.setText(R.string.ClockSwitch)
                    button.setOnClickListener() {
                        val intent = Intent(this, ClockSwitchExample::class.java)
                        startActivity(intent)   //when the button is clicked, go to the clock switch tutorial
                    }
                }
                6 -> {
                    button.setText(R.string.TimerSwitch)
                    button.setOnClickListener() {
                        val intent = Intent(this, TimerSwitchExample::class.java)
                        startActivity(intent)   //when the button is clicked, go to the timer switch tutorial
                    }
                }
                7 -> {
                    button.setText(R.string.MoreThanLight)
                    button.setOnClickListener() {
                        val intent = Intent(this, MoreThanLightExample::class.java)
                        startActivity(intent)   //when the button is clicked, go to the more than light tutorial
                    }
                }
                8 -> {
                    button.setText(R.string.ExactLight)
                    button.setOnClickListener() {
                        val intent = Intent(this, ExactLightExample::class.java)
                        startActivity(intent)   //when the button is clicked, go to the exact light tutorial
                    }
                }
                9 -> {
                    button.setText(R.string.EvenLight)
                    button.setOnClickListener() {
                        val intent = Intent(this, EvenLightExample::class.java)
                        startActivity(intent)   //when the button is clicked, go to the even light tutorial
                    }
                }
                10 -> {
                    button.setText(R.string.OddLight)
                    button.setOnClickListener() {
                        val intent = Intent(this, OddLightExample::class.java)
                        startActivity(intent)   //when the button is clicked, go to the odd light tutorial
                    }
                }
                else -> { button.text = "Tutorial $i" } //if the tutorial doesn't exist, display a button with the tutorial number
            }
            buttonContainer.addView(button) //add the button to the layout
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val intent = Intent(this, Menu::class.java)   //when the back button is pressed, go back to the menu
        startActivity(intent)
    }
}