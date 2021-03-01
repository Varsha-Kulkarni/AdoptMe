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
package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.models.Pet
import com.example.androiddevchallenge.models.PetRepo
import com.example.androiddevchallenge.ui.components.PetImage
import com.example.androiddevchallenge.ui.theme.purple500
import dev.chrisbanes.accompanist.insets.navigationBarsPadding
import dev.chrisbanes.accompanist.insets.statusBarsPadding
import kotlin.math.max
import kotlin.math.min

private val BottomBarHeight = 56.dp
private val TitleHeight = 136.dp
private val GradientScroll = 180.dp
private val ImageOverlap = 115.dp
private val MinTitleOffset = 60.dp
private val MinImageOffset = 12.dp
private val MaxTitleOffset = ImageOverlap + MinTitleOffset + GradientScroll
private val ExpandedImageSize = 300.dp
private val CollapsedImageSize = 150.dp
private val HzIndent = Modifier.padding(start = 24.dp)
private val HzPadding = Modifier.padding(horizontal = 24.dp)

@Composable
fun PetDetail(
    petId: Int,
    upPress: () -> Unit
) {
    val pet = remember(petId) { PetRepo.getPet(petId) }

    Box(Modifier.fillMaxSize()) {
        val scroll = rememberScrollState(0)
        Header()
        pet?.let {
            Body(pet.breedDetails, scroll)
            Title(pet, scroll.value)
            Image(pet, scroll.value)
        }

        Up(upPress)
        BottomBar(modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
private fun Body(
    details: String,
    scroll: ScrollState
) {
    Column {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .height(MinTitleOffset)
        )
        Column(
            modifier = Modifier.verticalScroll(scroll)
        ) {
            Spacer(Modifier.height(GradientScroll))
            Surface(Modifier.fillMaxWidth()) {
                Column {
                    Spacer(Modifier.height(ImageOverlap))
                    Spacer(Modifier.height(TitleHeight))

                    Spacer(Modifier.height(64.dp))
                    Text(
                        text = "Breed Details:",
                        color = Color.LightGray,
                        style = MaterialTheme.typography.caption,
                        fontSize = 14.sp,
                        modifier = HzPadding
                    )
                    Text(
                        modifier = HzPadding,
                        text = details,
                        style = MaterialTheme.typography.caption,
                        fontSize = 14.sp,
                        color = Color.Gray
                    )

                    Spacer(
                        modifier = Modifier
                            .padding(bottom = BottomBarHeight)
                            .navigationBarsPadding(left = false, right = false)
                            .height(12.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun Header() {
    Spacer(
        modifier = Modifier
            .height(280.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colors.primary)
    )
}

@Composable
private fun Up(upPress: () -> Unit) {
    IconButton(
        onClick = upPress,
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .size(36.dp)
            .background(
                color = purple500,
            )
    ) {
        Icon(
            imageVector = Icons.Outlined.ArrowBack,
            tint = Color.White,
            contentDescription = stringResource(R.string.label_back)
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 72.dp, vertical = 10.dp)
    ) {

        Text(
            text = stringResource(id = R.string.appbar_title),
            style = MaterialTheme.typography.h6,
            color = Color.White,
        )
    }
}

@Composable
private fun Title(pet: Pet, scroll: Int) {
    val maxOffset = with(LocalDensity.current) { MaxTitleOffset.toPx() }
    val minOffset = with(LocalDensity.current) { MinTitleOffset.toPx() }
    val offset = (maxOffset - scroll).coerceAtLeast(minOffset)
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .heightIn(min = TitleHeight)
            .statusBarsPadding()
            .graphicsLayer { translationY = offset }
            .background(color = Color.White)
    ) {
        Spacer(Modifier.height(24.dp))

        Text(
            text = pet.name,
            style = MaterialTheme.typography.h4,
            color = Color.Gray,
            modifier = HzPadding
        )

        Row {
            Text(
                text = pet.breed,
                style = MaterialTheme.typography.caption,
                color = Color.LightGray,
                modifier = HzIndent
            )
            Text(
                text = pet.sex,
                style = MaterialTheme.typography.caption,
                color = Color.LightGray,
                modifier = HzIndent
            )
            Text(
                text = pet.age,
                style = MaterialTheme.typography.caption,
                color = Color.LightGray,
                modifier = HzIndent
            )
        }
        CharacteristicsBar(pet.characteristics)
        Spacer(Modifier.height(8.dp))

        Row {
            Text(
                style = MaterialTheme.typography.caption,
                text = "Published by: ",
                color = Color.LightGray,
                modifier = HzIndent
            )
            Text(
                style = MaterialTheme.typography.caption,
                color = Color.Gray,
                modifier = Modifier.padding(start = 2.dp),
                text = pet.publisher,
            )
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Divider(
            modifier = Modifier,
            color = Color.LightGray,
            thickness = 1.dp,
            startIndent = 0.dp
        )
    }
}

@Composable
private fun Image(
    pet: Pet,
    scroll: Int
) {
    val collapseRange = with(LocalDensity.current) { (MaxTitleOffset - MinTitleOffset).toPx() }
    val collapseFraction = (scroll / collapseRange).coerceIn(0f, 1f)

    CollapsingImageLayout(
        collapseFraction = collapseFraction,
        modifier = HzPadding.then(Modifier.statusBarsPadding())
    ) {
        PetImage(
            imageResource = pet.imageResource,
            contentDescription = null,
            modifier = Modifier
                .size(160.dp)
        )
    }
}

@Composable
private fun CollapsingImageLayout(
    collapseFraction: Float,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->
        check(measurables.size == 1)

        val imageMaxSize = min(ExpandedImageSize.roundToPx(), constraints.maxWidth)
        val imageMinSize = max(CollapsedImageSize.roundToPx(), constraints.minWidth)
        val imageWidth = lerp(imageMaxSize, imageMinSize, collapseFraction)
        val imagePlaceable = measurables[0].measure(Constraints.fixed(imageWidth, imageWidth))

        val imageY = lerp(MinTitleOffset, MinImageOffset, collapseFraction).roundToPx()
        val imageX = lerp(
            (constraints.maxWidth - imageWidth) / 2, // centered when expanded
            constraints.maxWidth - imageWidth, // right aligned when collapsed
            collapseFraction
        )
        layout(
            width = constraints.maxWidth,
            height = imageY + imageWidth
        ) {
            imagePlaceable.place(imageX, imageY)
        }
    }
}

@Composable
private fun BottomBar(modifier: Modifier = Modifier) {
    Surface(modifier) {
        Column {
            Divider(
                modifier = Modifier,
                color = Color.LightGray,
                thickness = 1.dp,
                startIndent = 0.dp
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .navigationBarsPadding(left = false, right = false)
                    .then(Modifier.padding(start = 60.dp, end = 60.dp))
                    .heightIn(min = BottomBarHeight)
            ) {

                Button(
                    onClick = { /* todo */ },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = stringResource(R.string.appbar_title),
                        maxLines = 1
                    )
                }
            }
        }
    }
}

@Composable
fun CharacteristicsBar(characteristics: List<String>) {
    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(start = 8.dp, end = 8.dp),
        modifier = Modifier.heightIn(min = 56.dp)
    ) {
        items(characteristics) { characteristic ->

            CharacterChip(characteristic)
        }
    }
}

@Composable
fun CharacterChip(
    characteristic: String,
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.small
) {
    Surface(
        modifier = modifier
            .height(30.dp),
        color = Color.White,
        contentColor = MaterialTheme.colors.secondary,
        shape = shape,
        elevation = 2.dp
    ) {
        Box(
            modifier = Modifier
        ) {
            Text(
                text = characteristic,
                style = MaterialTheme.typography.caption,
                maxLines = 1,
                modifier = Modifier.padding(
                    horizontal = 20.dp,
                    vertical = 6.dp
                )
            )
        }
    }
}
