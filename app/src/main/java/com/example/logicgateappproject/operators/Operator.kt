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
    //val paint = Paint()

    var state : Int = 0
    //var state: Int by Delegates.observable(0) {
    //        prop, old, new -> println("La variable state a été modifiée de $old à $new")
    //    // Appeler ici une autre fonction ou effectuer une autre action en cas de modification de la variable "state"
    //}

    init {
        size = 0f
        hitbox = RectF(posX-size/2, posY-size/2, posX+size/2, posY+size/2)
        onCreate()
    }

    abstract fun onCreate()

    fun draw(canvas: Canvas) {
        /*size = (view.screenWidth/ opFract)
        hitbox = RectF(posX, posY, posX + size, posY - size)*/
        //canvas.drawRect(posX, posY, posX + size, posY - size, paint)

        val sprite = ContextCompat.getDrawable(context, spriteId)
        sprite?.setBounds((posX-size/2).toInt(), (posY-size/2).toInt(), (posX+size/2).toInt(), (posY+size/2).toInt())
        sprite?.draw(canvas)
    }

    fun updatePos(nPosX: Float, nPosY: Float) {
        posX = nPosX
        posY = nPosY
        hitbox = RectF(posX, posY, posX + size, posY - size)
    }

    abstract fun compute()

    fun delete() {}
}