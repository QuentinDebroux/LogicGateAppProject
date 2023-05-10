package com.example.logicgateappproject.operators

import android.content.Context
import android.graphics.Canvas
import android.graphics.RectF
import android.view.MotionEvent
import androidx.core.content.ContextCompat
import com.example.logicgateappproject.R
import kotlin.properties.Delegates

abstract class Operator(var posX: Float, var posY: Float, val context: Context) {

    protected var size: Float
    private var hitbox: RectF
    protected var spriteId: Int = R.drawable.and

    var state: Int by Delegates.observable(0) {
            prop, old, new -> callCompute()
        //Calls compute when the state changes
    }

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
        hitbox = RectF(posX-size/2, posY-size/2, posX+size/2, posY+size/2)
    }

    open fun updateSize(nSize: Float) {
        size = nSize
    }

    fun contains(event: MotionEvent): Boolean {
        return (event.x<hitbox.right && event.x>hitbox.left && event.y>hitbox.top && event.y<hitbox.bottom)
    }

    abstract fun compute()

    abstract fun callCompute()

    fun delete() {}
}
