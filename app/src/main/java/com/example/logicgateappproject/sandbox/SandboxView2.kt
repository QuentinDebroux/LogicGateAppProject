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

class SandboxView2 @JvmOverloads constructor (context: Context, attributes: AttributeSet? = null, defStyleAttr: Int = 0): SurfaceView(context, attributes, defStyleAttr), SurfaceHolder.Callback, Runnable {
    lateinit var canvas: Canvas
    val backgroundPaint = Paint()
    val textPaint = Paint()
    var drawing = false

    var screenWidth = 0f
    var screenHeight = 0f
    var menuHeight = 0f
    val opFract: Float = 8f                                               //largeur de l'ecran par rapport à la largeur d'un operateur

    var isTouchDown = false

    var operators: ArrayList<Operator> = ArrayList<Operator>()
    var menuOperators: ArrayList<Operator> = ArrayList<Operator>()

    init {
        backgroundPaint.color = Color.WHITE
        textPaint.textSize = screenWidth / 20
        textPaint.color = Color.BLACK
    }

    @SuppressLint("DiscouragedApi")
    fun getclass {val classList = mutableListOf<Class<*>>()

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
        for (className in classNames) {
            val clazz = Class.forName(className)
            val imageView = ImageView(context)
            // Récupérer le nom de la ressource d'image correspondante
            val resourceName = clazz.simpleName
            // Récupérer l'ID de la ressource d'image correspondante en utilisant le nom de la ressource
            val resourceId = context.resources.getIdentifier(resourceName, "drawable", context.packageName)
            // Définir l'image à partir de la ressource d'image correspondante
            imageView.setImageResource(resourceId)
            imageViewList.add(imageView)
        }


// Utiliser la liste d'ImageViews
        for (imageView in imageViewList) {
            // faire quelque chose avec imageView
        }
    }
    fun createMenu() {
        menuOperators.clear()

        val distance = screenWidth*((opFract-1)/(5*opFract))
        menuOperators.add(menuAnd (0f + screenWidth/opFract/2, screenHeight - distance, context))


}