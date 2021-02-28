package com.example.androiddevchallenge.models

import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateOf

@Stable
class Filter(
    val name: String,
    enabled: Boolean = false
) {
    val enabled = mutableStateOf(enabled)
}

val filters = listOf(
    Filter(name = "All"),
    Filter(name = "Dogs"),
    Filter(name = "Cats")
)
