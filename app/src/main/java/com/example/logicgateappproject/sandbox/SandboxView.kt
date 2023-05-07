package com.example.logicgateappproject.sandbox

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import com.example.logicgateappproject.operators.*

class SandboxView @JvmOverloads constructor (context: Context, attributes: AttributeSet? = null, defStyleAttr: Int = 0): SurfaceView(context, attributes, defStyleAttr), SurfaceHolder.Callback, Runnable {
    lateinit var canvas: Canvas
    val backgroundPaint = Paint()
    val textPaint = Paint()
    var drawing = false

    var screenWidth = 0f
    var screenHeight = 0f
    var menuHeight = 0f
    val opFract: Float = 8f                                               //largeur de l'ecran par rapport à la largeur d'un operateur

    lateinit var thread: Thread

    var isTouchDown = false

    var operators: ArrayList<Operator> = ArrayList<Operator>()
    var menuOperators: ArrayList<Operator> = ArrayList<Operator>()

    init {
        backgroundPaint.color = Color.WHITE
        textPaint.textSize = screenWidth / 20
        textPaint.color = Color.BLACK
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val action = event.action

        if ((action == MotionEvent.ACTION_DOWN/* || action == MotionEvent.ACTION_MOVE*/) && event.y>menuHeight) {
            for (obj in menuOperators) {
                var out = false
                println((event.x<obj.hitbox.right && event.x>obj.hitbox.left && event.y<obj.hitbox.top && event.y>obj.hitbox.bottom))

                if (event.x<obj.hitbox.right && event.x>obj.hitbox.left
                    && event.y<obj.hitbox.top && event.y>obj.hitbox.bottom)  {
                    println("touch")
                    when(obj) {
                        is And ->   {operators.add(And(event.x, event.y, context))}
                        is Or ->   {operators.add(Or(event.x, event.y, context))}
                        is Xor ->   {operators.add(Xor(event.x, event.y, context))}
                        is Not ->   {operators.add(Not(event.x, event.y, context))}
                        is NormalSwitch ->   {operators.add(NormalSwitch(event.x, event.y, context))}
                        is ExactLight ->   {operators.add(ExactLight(event.x, event.y, context))}
                    }
                    out = true
                    println(operators.size)
                    println(operators[0].posY)
                }
                if (out) {break}
            }
            if (!(operators.isEmpty())) {
                move(operators.last(), event)
            }
        }
        return true
    }

    fun move(obj: Operator, event: MotionEvent){
        Thread {
            //while (/*isScreenPressed()*/) {
            println("fun")
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    isTouchDown = true
                    println("down")
                }
                MotionEvent.ACTION_MOVE -> {
                    // Touch move event
                    // Update the position of the object while touch is down
                    println("move")
                    obj.updatePos(event.x, event.y)
                    draw(canvas)
                }
                MotionEvent.ACTION_UP -> {
                    isTouchDown = false
                    println("up")

                    if (event.y<=menuHeight) {
                        //delete object from operators
                        operators.remove(obj)
                    }
                }
            }
            //}
        }.start()
    }

    /* later (maybe modify)

    fun connect(input: LogicGate, output: LogicGate) {
        output.connectIn(input=input)
        textView.text=l.state.toString()
    }*/

    fun draw() {
        if (holder.surface.isValid) {
            canvas = holder.lockCanvas()
            canvas.drawRect(0f, 0f, canvas.width.toFloat(), canvas.height.toFloat(), backgroundPaint)

            for (obj in operators) {
                obj.draw(canvas)
            }

            for (obj in menuOperators) {
                obj.draw(canvas)
            }

            holder.unlockCanvasAndPost(canvas)
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        screenWidth = w.toFloat()
        screenHeight = h.toFloat()
        menuHeight = (2*h/ opFract)

        createMenu()

        for (obj in operators) {
            obj.size = (w/ opFract)
            obj.updatePos(obj.posX, obj.posY)
        }

        for (obj in menuOperators) {
            obj.size = (w/ opFract)
            obj.updatePos(obj.posX, obj.posY)
        }

        textPaint.setTextSize(w / 20f)
        textPaint.isAntiAlias = true
    }

    fun createMenu() {
        menuOperators.clear()

        val distance = screenWidth*((opFract-1)/(5*opFract))

        menuOperators.add(And(0f + screenWidth/opFract/2, screenHeight - distance, context))
        menuOperators.add(Or(0f + distance + screenWidth/opFract/2, screenHeight - distance, context))
        menuOperators.add(Xor(0f + 2*distance + screenWidth/opFract/2, screenHeight - distance, context))
        menuOperators.add(Not(0f + 3*distance + screenWidth/opFract/2, screenHeight - distance, context))
        menuOperators.add(NormalSwitch(0f + 4*distance + screenWidth/opFract/2, screenHeight - distance, context))
        menuOperators.add(ExactLight(0f + 5*distance + screenWidth/opFract/2, screenHeight - distance, context))
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