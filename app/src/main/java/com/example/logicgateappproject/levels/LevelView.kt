package com.example.logicgateappproject.levels

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import com.example.logicgateappproject.operators.*

class LevelView @JvmOverloads constructor (context: Context, attributes: AttributeSet? = null, defStyleAttr: Int = 0): SurfaceView(context, attributes, defStyleAttr), SurfaceHolder.Callback, Runnable {
    lateinit var canvas: Canvas
    val backgroundPaint = Paint()
    val textPaint = Paint()
    var drawing = false

    var screenWidth = 1f
    var screenHeight = 1f
    val opFract: Float = 8f                                               //largeur de l'ecran par rapport à la largeur d'un operateur

    lateinit var thread: Thread

    var operators: ArrayList<Operator> = ArrayList<Operator>()

    init {
        backgroundPaint.color = Color.WHITE
        textPaint.textSize = screenWidth / 20
        textPaint.color = Color.BLACK
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val action = event.action

        if (action == MotionEvent.ACTION_DOWN/* || action == MotionEvent.ACTION_MOVE*/) {
            for (obj in operators) {
                var out = false
                //println(event.x<obj.hitbox.right && event.x>obj.hitbox.left)
                println(event.y<obj.hitbox.top && event.y>obj.hitbox.bottom)

                if (obj is Switch && event.x<obj.hitbox.right && event.x>obj.hitbox.left
                    && event.y<obj.hitbox.top && event.y>obj.hitbox.bottom)  {
                    println("touch")

                    obj.switchState()

                    out = true
                }
                if (out) {break}
            }
        }
        return true
    }

    fun draw() {
        if (holder.surface.isValid) {
            canvas = holder.lockCanvas()
            canvas.drawRect(0f, 0f, canvas.width.toFloat(), canvas.height.toFloat(), backgroundPaint)

            for (obj in operators) {
                obj.draw(canvas)
            }


            holder.unlockCanvasAndPost(canvas)
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        for (obj in operators) {
            obj.updatePos(obj.posX*w/screenWidth, obj.posY*h/screenHeight)
            obj.updateSize(w/ opFract)
        }

        screenWidth = w.toFloat()
        screenHeight = h.toFloat()

        textPaint.setTextSize(w / 20f)
        textPaint.isAntiAlias = true
    }

    override fun run() {
        while (drawing) {
            draw()
        }
    }

    fun pause() {
        drawing = false
        thread.join()
    }

    fun resume() {
        drawing = true
        thread = Thread(this)
        thread.start()
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {}

    override fun surfaceCreated(holder: SurfaceHolder) {}

    override fun surfaceDestroyed(holder: SurfaceHolder) {}

}