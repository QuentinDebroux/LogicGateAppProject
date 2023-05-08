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

    // The following variables are used in the tutorial to display the name, description, and sprite of the gate.

    protected lateinit var name: TextView
    protected lateinit var description: TextView

    protected lateinit var switch: Switch
    protected var light: ExactLight = ExactLight(0f, 0f, this, 1)

    protected lateinit var s: ImageView
    protected lateinit var l: ImageView

    @SuppressLint("MissingInflatedId")
    abstract fun onConstruct()  //This function is used to construct the gate and set the name and description
                                //It is redefined in each switch tutorial because each switch tutorial has it's
                                //own OnClick listener that has to be aware that the state can change
                                //even when the switch is not clicked

    abstract fun switchSpriteSwitch(switch: ImageView, state: Int)

    fun switchSpriteLight() {   //Changes the sprite of the light depending on the state
        when(light.state) {
            0 -> {l.setImageResource(R.drawable.lit_off_light_bulb)}
            1 -> {l.setImageResource(R.drawable.lit_on_light_bulb)}
        }
    }

    override fun onBackPressed() {
        val intent = Intent(this, TutorialsMenu::class.java)    //When the back button is pressed, the user is sent back to the tutorial menu
        startActivity(intent)
    }
}
