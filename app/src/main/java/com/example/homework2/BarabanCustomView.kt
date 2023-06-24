package com.example.homework2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import java.lang.Float.min
import android.view.View

class BarabanCustomView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val colors = intArrayOf(
        Color.RED,
        Color.parseColor("#FFA500"),
        Color.YELLOW,
        Color.GREEN,
        Color.BLUE,
        Color.parseColor("#4B0082"),
        Color.parseColor("#800080")
    )


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (isInEditMode){

        }
        val width = width.toFloat()
        val height = height.toFloat()
        val radius = min(width, height) / 2f
        val centerX = width / 2f
        val centerY = height / 2f
        val rectF = RectF(centerX - radius, centerY - radius, centerX + radius, centerY + radius)
        var startAngle = 38.5f
        for (i in colors.indices) {
            paint.color = colors[i]
            canvas.drawArc(rectF, startAngle, 360f / colors.size, true, paint)
            startAngle += 360f / colors.size
        }
    }
}