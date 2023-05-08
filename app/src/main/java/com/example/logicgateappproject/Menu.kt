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
        setContentView(R.layout.menu)

        tutorials = findViewById(R.id.tutobutton)
        levels = findViewById(R.id.levbutton)
        sandbox = findViewById(R.id.sanbutton)

        tutorials.setOnClickListener {
            val intent = Intent(this, TutorialsMenu::class.java)
            startActivity(intent)
        }

        levels.setOnClickListener {
            val intent = Intent(this, LevelsMenu::class.java)
            startActivity(intent)
        }

        sandbox.setOnClickListener {
            val intent = Intent(this, SandboxMenu::class.java)
            startActivity(intent)
        }
    }
}