package com.example.logicgateappproject.operators

import android.content.Context
import android.graphics.Canvas
import android.graphics.RectF
import androidx.core.content.ContextCompat
import com.example.logicgateappproject.R
import kotlin.properties.Delegates

abstract class Operator constructor(var posX: Float, var posY: Float, val context: Context) {

    var size: Float
    var hitbox: RectF
    var spriteId: Int = R.drawable.and

    var state : Int = 0
    //var state: Int by Delegates.observable(0) {
    //        prop, old, new -> println("La variable state a été modifiée de $old à $new")
    //    // Appeler ici une autre fonction ou effectuer une autre action en cas de modification de la variable "state"
    //}

    init {
        size = 0f
        hitbox = RectF(posX-size/2, posY-size/2, posX+size/2, posY+size/2)  //The hitbox is a rectangle centered on the object.
        onCreate()
    }

    abstract fun onCreate()

    fun draw(canvas: Canvas) {

        val sprite = ContextCompat.getDrawable(context, spriteId)    //Get the sprite of the object.
        sprite?.setBounds((posX-size/2).toInt(), (posY-size/2).toInt(), (posX+size/2).toInt(), (posY+size/2).toInt())   //Set the position of the sprite.
        sprite?.draw(canvas)
    }

    fun updatePos(nPosX: Float, nPosY: Float) { //Update the position of the object when the size is changed.
        posX = nPosX
        posY = nPosY
        hitbox = RectF(posX, posY, posX + size, posY - size)
    }

    abstract fun compute()

    fun delete() {}
}