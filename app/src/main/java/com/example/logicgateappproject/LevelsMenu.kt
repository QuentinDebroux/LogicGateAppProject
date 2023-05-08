package com.example.logicgateappproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.logicgateappproject.levels.*

class LevelsMenu: AppCompatActivity() {

    private val levelNumber: Int = 2    //number of levels
    private lateinit var buttonContainer: LinearLayout  //container for the buttons
    //val levelList = mutableListOf<Level>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.levels_menu)    // Link to the layout file
        buttonContainer = findViewById<LinearLayout>(R.id.buttonContainer)  // Link to the button container from the layout file

        for (i in 1..levelNumber) {
            val button = Button(this)
            when(i) {
                1 -> {
                    button.setText("level $i")
                    button.setOnClickListener() {   //when the button is clicked, go to level 1
                        val intent = Intent(this, Level1::class.java)   //go to level 1
                        startActivity(intent)   //start the activity
                    }
                }
                2 -> {
                    button.setText("level $i")
                    button.setOnClickListener() {   //when the button is clicked, go to level 2
                        val intent = Intent(this, Level2::class.java)   //go to level 2
                        startActivity(intent)   //start the activity
                    }
                }
                else -> { button.text = "level $i" }
            }
            buttonContainer.addView(button) //add the button to the button container
        }

        /*for (i in 1..levelNumber) {
            val button = Button(this)
            button.text = "Level $i"
            buttonContainer.addView(button)
            button.setOnClickListener {
                val intent = Intent(this, Class.forName("com.example.logicgateappproject.levels.Level$i"))
                startActivity(intent)
            }

            val levelClass = Class.forName("com.example.logicgateappproject.levels.Level$i")
            val levelInstance = levelClass.newInstance() as Level
            levelList.add(levelInstance)
        }*/
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val intent = Intent(this, Menu::class.java)   //When the back button is pressed, the user is sent back to the menu
        startActivity(intent)
    }
}
