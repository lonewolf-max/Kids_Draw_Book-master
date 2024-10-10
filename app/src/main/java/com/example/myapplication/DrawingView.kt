package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.view.MotionEvent
import android.view.View

class DrawingView(context: Context) : View(context) {

    private val paint = Paint().apply {
        color = Color.BLACK
        isAntiAlias = true
        strokeWidth = 10f
        style = Paint.Style.STROKE
        strokeJoin = Paint.Join.ROUND
        strokeCap = Paint.Cap.ROUND
    }

    private val path = Path()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawPath(path, paint)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        val xPos = event.x
        val yPos = event.y

        when (event.action) {
            MotionEvent.ACTION_DOWN -> path.moveTo(xPos, yPos)
            MotionEvent.ACTION_MOVE -> {
                path.lineTo(xPos, yPos)
                invalidate() // Redraw the view
            }
        }
        return true
    }

    // Function to clear the canvas
    fun clearCanvas() {
        path.reset()
        invalidate()
    }
}
