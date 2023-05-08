package com.example.logicgateappproject.sandbox

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.widget.ImageView
import com.example.logicgateappproject.operators.Operator
import java.io.File


class SandboxView2 @JvmOverloads constructor (context: Context, attributes: AttributeSet? = null, defStyleAttr: Int = 0): SurfaceView(context, attributes, defStyleAttr), SurfaceHolder.Callback, Runnable  {
    lateinit var canvas: Canvas
    val backgroundPaint = Paint()
    val textPaint = Paint()
    var drawing = false
    var IMV = getclass()
    lateinit var thread: Thread

    var screenWidth = 0f
    var screenHeight = 0f
    var menuHeight = 0f
    val opFract: Float =
        8f                                               //largeur de l'ecran par rapport à la largeur d'un operateur

    var isTouchDown = false

    var operators: ArrayList<Operator> = ArrayList<Operator>()
    var menuOperators: ArrayList<ImageView> = ArrayList<ImageView>()

    init {
        backgroundPaint.color = Color.WHITE
        textPaint.textSize = screenWidth / 20
        textPaint.color = Color.BLACK
    }

    @SuppressLint("DiscouragedApi")
    fun getclass(): ArrayList<ImageView> {
        val classList = mutableListOf<Class<*>>()

// 1. Scanner le dossier contenant les classes et extraire les noms de classes
        val directory = File("../operators")
        val files = directory.listFiles()
        val classFiles = files?.filter { it.isFile && it.name.endsWith(".class") }
        val classNames = classFiles?.map { file ->
            val fileName = file.nameWithoutExtension
            val packageName = file.parentFile?.toString()?.replace('/', '.')
            "$packageName.$fileName"
        }

// 2. Itérer sur la liste de noms de classes et les initialiser comme des variables ImageView
        val imageViewList = mutableListOf<ImageView>()
        if (classNames != null) {
            for (className in classNames) {
                val clazz = Class.forName(className)
                val imageView = ImageView(context)
                // Récupérer le nom de la ressource d'image correspondante
                val resourceName = clazz.simpleName
                // Récupérer l'ID de la ressource d'image correspondante en utilisant le nom de la ressource
                val resourceId =
                    context.resources.getIdentifier(resourceName, "drawable", context.packageName)
                // Définir l'image à partir de la ressource d'image correspondante
                imageView.setImageResource(resourceId)
                imageViewList.add(imageView)
            }
        }


// Utiliser la liste d'ImageViews
        for (imageView in imageViewList) {
            // faire quelque chose avec imageView
        }
        return imageViewList as ArrayList<ImageView>
    }

    fun createMenu() {
        menuOperators.clear()

        val distance = screenWidth * ((opFract - 1) / (5 * opFract))
        //add each element in IMV to menuOperators
        for (i in 0 until IMV.size) {
            menuOperators.add(IMV[i])
            IMV[i].x = distance + i * screenWidth / opFract
            IMV[i].y = menuHeight / 2
            IMV[i].layoutParams.width = screenWidth.toInt() / opFract.toInt()
            IMV[i].layoutParams.height = menuHeight.toInt()
        }



    }
    fun draw(){
        //add a line of code that is the equivalent to pass in python
        if (!holder.surface.isValid) {
            return
        }
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