package com.example.androiddevchallenge.models

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable

@Immutable
data class Pet(
    val petId: Int,
    val name: String,
    val description: String,
    @DrawableRes val imageResource: Int,
    val publisher: String,
    val breed: String,
    val moreDetails: String
)

