package com.example.tiktaktoe.ui

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class GameFieldView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var board = Array(3) { arrayOfNulls<Char>(3) }
    private var currentPlayer = 'X'

    private val paint = Paint().apply {
        color = Color.BLACK
        strokeWidth = 8f
        style = Paint.Style.STROKE
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = MeasureSpec.getSize(heightMeasureSpec)
        val size = Math.min(width, height)

        setMeasuredDimension(size, size)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val cellSize = width / 3
        // Рисуем сетку
        for (i in 0 until 4) {
            canvas.drawLine(cellSize * i.toFloat(), 0f, cellSize * i.toFloat(), height.toFloat(), paint)
            canvas.drawLine(0f, cellSize * i.toFloat(), width.toFloat(), cellSize * i.toFloat(), paint)
        }
        // Рисуем X и O
//        for (i in 0..2) {
//            for (j in 0..2) {
//                board[i][j]?.let {
//                    if (it == 'X') {
//                        drawX(canvas, i, j, cellSize)
//                    } else if (it == 'O') {
//                        drawO(canvas, i, j, cellSize)
//                    }
//                }
//            }
//        }
    }


    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if(event?.action == MotionEvent.ACTION_DOWN){

            return true
        }
        return true
    }

}