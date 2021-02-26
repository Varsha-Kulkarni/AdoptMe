package com.example.androiddevchallenge.models

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize


@Parcelize
data class Pet(
    val petId: Int,
    val name: String,
    val description: String,
    @DrawableRes val imageResource: Int,
    val publisher: String,
    val breed: String,
    val type: String
): Parcelable
