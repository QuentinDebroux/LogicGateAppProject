package com.example.logicgateappproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Menu : AppCompatActivity() {


    private lateinit var tutorials: Button
    private lateinit var levels: Button
    private lateinit var sandbox: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu)   // Link to the layout file

        tutorials = findViewById(R.id.tutobutton)   // Link to the tutorial button from the layout file
        levels = findViewById(R.id.levbutton)   // Link to the levels button from the layout file
        sandbox = findViewById(R.id.sanbutton)  // Link to the sandbox button from the layout file

        tutorials.setOnClickListener {
            val intent = Intent(this, TutorialsMenu::class.java)    //when the button is clicked, go to the tutorials menu
            startActivity(intent)
        }

        levels.setOnClickListener {
            val intent = Intent(this, LevelsMenu::class.java)   //when the button is clicked, go to the levels menu
            startActivity(intent)
        }

        sandbox.setOnClickListener {
            val intent = Intent(this, SandboxMenu::class.java)  //when the button is clicked, go to the sandbox menu
            startActivity(intent)
        }
    }
}