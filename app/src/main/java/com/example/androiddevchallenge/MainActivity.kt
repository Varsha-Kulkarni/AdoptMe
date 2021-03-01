/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import com.example.androiddevchallenge.models.petCollections
import com.example.androiddevchallenge.ui.screens.PetDetail
import com.example.androiddevchallenge.ui.screens.PetList
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.utils.Actions
import com.example.androiddevchallenge.utils.Destination
import com.example.androiddevchallenge.utils.Navigator
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp(backDispatcher = onBackPressedDispatcher)
            }
        }
    }
}

// Start building your app here!

@Composable
fun MyApp(backDispatcher: OnBackPressedDispatcher) {
    val navigator: Navigator<Destination> = rememberSaveable(
        saver = Navigator.saver(backDispatcher)
    ) {
        Navigator(Destination.Home, backDispatcher)
    }
    val actions = remember(navigator) { Actions(navigator) }
    ProvideWindowInsets {
        MyTheme {
            Crossfade(navigator.current) { destination ->
                when (destination) {
                    Destination.Home -> PetList(actions.selectPet, petCollections)
                    is Destination.Detail -> PetDetail(
                        petId = destination.petId,
                        upPress = actions.upPress
                    )
                }
            }
        }
    }
}
