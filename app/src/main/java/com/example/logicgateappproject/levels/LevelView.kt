package com.example.logicgateappproject.levels

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import com.example.logicgateappproject.LevelsMenu
import com.example.logicgateappproject.R
import com.example.logicgateappproject.operators.*
import kotlin.properties.Delegates

class LevelView @JvmOverloads constructor (context: Context, attributes: AttributeSet? = null, defStyleAttr: Int = 0): SurfaceView(context, attributes, defStyleAttr), SurfaceHolder.Callback, Runnable {

    var levelName: String = "Level"
    var win: Boolean by Delegates.observable(false) {
            prop, old, new -> showDialog(new)
        // Appeler ici une autre fonction ou effectuer une autre action en cas de modification de la variable "state"
    }

    private lateinit var canvas: Canvas
    private val activity = context as FragmentActivity
    private val backgroundPaint = Paint()
    private val textPaint = Paint()
    private var drawing = false
    private lateinit var thread: Thread

    var screenWidth = 1f
    var screenHeight = 1f
    val opFract: Float = 8f                                               //largeur de l'ecran par rapport à la largeur d'un operateur

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
                //println(event.y<obj.hitbox.top && event.y>obj.hitbox.bottom)

                if (obj is Switch && obj.contains(event)) {
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
            obj.updateSize(w/ opFract)
            obj.updatePos(obj.posX*w/screenWidth, obj.posY*h/screenHeight)
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

    private fun showDialog(gameState: Boolean) {

        println("dialog")
        class WinDialogFragment(val levelName: String) : DialogFragment() {
            override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
                return activity?.let {
                    val builder = AlertDialog.Builder(it)
                    builder.setTitle(levelName)
                    builder.setMessage(R.string.level_done)
                        .setPositiveButton(R.string.back) { dialog, id ->
                            val intent = Intent(activity, LevelsMenu::class.java)
                            startActivity(intent)
                        }
                    builder.create()
                } ?: throw IllegalStateException("Activity cannot be null")
            }
        }

        if (gameState) {
            val winDialog = WinDialogFragment(levelName)
            winDialog.show(activity.supportFragmentManager, "WinDialogFragment")
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
