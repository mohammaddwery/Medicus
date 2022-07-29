package com.medicus.app.presentation.common

import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.Paint
import android.graphics.PixelFormat
import android.graphics.drawable.Drawable

class CircleDrawable(
    private val fillColor: Int,
    private val strokeColor: Int,
    private val radius: Float,
    private val stroke: Float
) : Drawable() {
    private val circlePaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    override fun draw(canvas: Canvas) {
        val x = bounds.centerX()
        val y = bounds.centerY()
        //draw fill color circle
        circlePaint.style = Paint.Style.FILL
        circlePaint.color = fillColor
        canvas.drawCircle(x.toFloat(), y.toFloat(), radius, circlePaint)
        // draw stroke circle
        circlePaint.style = Paint.Style.STROKE
        circlePaint.color = strokeColor
        circlePaint.strokeWidth = stroke
        canvas.drawCircle(x.toFloat(), y.toFloat(), radius, circlePaint)
    }

    override fun setAlpha(alpha: Int) {
        circlePaint.alpha = alpha
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        circlePaint.colorFilter = colorFilter
    }

    @Deprecated("Deprecated in Java",
        ReplaceWith("PixelFormat.TRANSLUCENT", "android.graphics.PixelFormat")
    )
    override fun getOpacity(): Int {
        return PixelFormat.TRANSLUCENT
    }

}