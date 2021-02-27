package com.example.androiddevchallenge.utils

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import kotlinx.parcelize.Parcelize

/**
 * Models the screens in the app and any arguments they require.
 */
sealed class Destination : Parcelable {
    @Parcelize
    object Home : Destination()

    @Immutable
    @Parcelize
    data class Detail(val petId: Int) : Destination()
}
/**
 * Models the navigation actions in the app.
 */
class Actions(navigator: Navigator<Destination>) {
    val selectPet: (Int) -> Unit = { petId: Int ->
        navigator.navigate(Destination.Detail(petId))
    }
    val upPress: () -> Unit = {
        navigator.back()
    }
}
