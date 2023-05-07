package com.example.logicgateappproject.levels

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.logicgateappproject.LevelsMenu
import com.example.logicgateappproject.R
import com.example.logicgateappproject.operators.*

abstract class Level: AppCompatActivity() {

    lateinit var levelView: LevelView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.level)
        levelView = findViewById<LevelView>(R.id.vLevels)
        declareOperators()
    }

    abstract fun declareOperators()

    fun connectOperators(output: Operator, input: Operator) {
        when(output) {
            is LogicGate -> { output.connectIn(input) }
            is Light -> { output.connectIn(input) }
        }
    }

    override fun onPause() {
        super.onPause()
        levelView.pause()
    }

    override fun onResume() {
        super.onResume()
        levelView.resume()
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val intent = Intent(this, LevelsMenu::class.java)
        startActivity(intent)
    }
}