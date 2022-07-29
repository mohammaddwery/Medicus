package com.medicus.app.presentation.common

import android.graphics.Color
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import com.medicus.app.R
import com.medicus.app.presentation.utils.parseColor


@BindingAdapter("biomarkerTextColor")
fun AppCompatTextView.setBiomarkerTextColor(color: String?) {
    this.setTextColor(parseColor(color))
}

@BindingAdapter("biomarkerDrawable")
fun ImageView.setBiomarkerDrawable(color: String?) {
    val stroke = context.resources.getDimensionPixelSize(R.dimen.dp_2)
    val radius = context.resources.getDimensionPixelSize(R.dimen.dp_96)/2 - stroke

    this.setImageDrawable(CircleDrawable(
        fillColor=parseColor(ColorOpacityHelper.transparentColor(parseColor(color), 30)),
        strokeColor=parseColor(color),
        radius=radius.toFloat(),
        stroke=stroke.toFloat()
    ))
}