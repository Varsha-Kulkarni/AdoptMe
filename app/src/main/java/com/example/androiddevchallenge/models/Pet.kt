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
package com.example.androiddevchallenge.models

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable

@Immutable
data class Pet(
    val petId: Int,
    val name: String,
    val sex: String,
    val age: String,
    val characteristics: List<String>,
    @DrawableRes val imageResource: Int,
    val publisher: String,
    val breed: String,
    val breedDetails: String
)
