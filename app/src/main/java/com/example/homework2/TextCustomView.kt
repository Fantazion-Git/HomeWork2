package com.example.homework2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class TextCustomView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private var text = ""
    private var paint = Paint()
    fun setText(text:String){
        this.text=text
        invalidate()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = MeasureSpec.makeMeasureSpec(600,MeasureSpec.UNSPECIFIED)
        val height = MeasureSpec.makeMeasureSpec(100,MeasureSpec.UNSPECIFIED)
        setMeasuredDimension(width,height)
    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.textSize=50f
        paint.color=Color.GRAY
        canvas.drawText(text, width/3f,height/2f,paint)
    }
}