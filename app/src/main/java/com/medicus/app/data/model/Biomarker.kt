package com.medicus.app.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Biomarker(
    val id: Long,
    val date: String,
    val info: String,
    val color: String,
    val value: String,
    val symbol: String,
    val insight: String,
    val category: String
): Parcelable