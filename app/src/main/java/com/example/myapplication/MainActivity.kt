package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set up layout containing the clear button and the drawing view
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
        }

        val drawingView = DrawingView(this)
        val clearButton = Button(this).apply {
            text = "Clear Canvas"
            setOnClickListener { drawingView.clearCanvas() }
        }

        // Add the button and the canvas to the layout
        layout.addView(clearButton)
        layout.addView(drawingView)

        // Set the layout as the activity's content
        setContentView(layout)
    }
}
