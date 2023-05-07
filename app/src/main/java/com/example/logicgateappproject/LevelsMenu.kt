package com.example.logicgateappproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.logicgateappproject.levels.Level

class LevelsMenu: AppCompatActivity() {

    val levelNumber: Int = 1
    lateinit var buttonContainer: LinearLayout
    val levelList = mutableListOf<Level>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.levels_menu)
        buttonContainer = findViewById<LinearLayout>(R.id.buttonContainer)

        for (i in 1..levelNumber) {
            val button = Button(this)
            button.text = "Level $i"
            buttonContainer.addView(button)
            button.setOnClickListener {
                val intent =
                    Intent(this, Class.forName("com.example.logicgateappproject.levels.Level$i"))
                startActivity(intent)
            }

            /*val levelClass = Class.forName("com.example.logicgateappproject.levels.Level$i")
            val levelInstance = levelClass.newInstance() as Level
            levelList.add(levelInstance)*/
        }

        /*for (i in 1..levelNumber) {
            val button = Button(this)
            button.text = "Level $i"
            // Add any other properties or event listeners to the button as needed
            buttonContainer.addView(button)

            /*val levelClass = Class.forName("com.example.logicgateappproject.levels.Level$i")
            val levelInstance = levelClass.newInstance() as Level
            levelList.add(levelInstance)*/
        }*/
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val intent = Intent(this, Menu::class.java)
        startActivity(intent)
    }
}