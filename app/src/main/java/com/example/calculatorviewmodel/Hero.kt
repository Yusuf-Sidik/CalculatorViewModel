package com.example.calculatorviewmodel

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hero(
    val name: String,
    val description: String
) : Parcelable
