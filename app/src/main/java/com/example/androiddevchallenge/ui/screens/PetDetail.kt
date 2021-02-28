package com.example.androiddevchallenge.ui.screens


import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.example.androiddevchallenge.ui.components.PetDetailText
import com.example.androiddevchallenge.ui.components.PetImage
import com.example.androiddevchallenge.ui.theme.purple500
import dev.chrisbanes.accompanist.insets.statusBarsPadding
import kotlin.math.max
import kotlin.math.min

private val TitleHeight = 136.dp
private val GradientScroll = 180.dp
private val ImageOverlap = 115.dp
private val MinTitleOffset = 60.dp
private val MinImageOffset = 12.dp
private val MaxTitleOffset = ImageOverlap + MinTitleOffset + GradientScroll
private val ExpandedImageSize = 300.dp
private val CollapsedImageSize = 150.dp
private val HzPadding = Modifier.padding(horizontal = 24.dp)

@Composable
fun PetDetail(
    petId: Int,
    upPress: () -> Unit
) {
    val pet = remember(petId) {  PetRepo.getPet(petId) }

    Box(Modifier.fillMaxSize()) {
        val scroll = rememberScrollState(0)
        Header()
        pet?.let{
            Body(pet.moreDetails, scroll)
            Title(pet, scroll.value)
            Image(pet, scroll.value)
        }

        Up(upPress)
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

                    Spacer(Modifier.height(120.dp))

                    PetDetailText(
                        modifier = HzPadding,
                        text = "More Details:\n$details",
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
                shape = CircleShape
            )
    ) {
        Icon(
            imageVector = Icons.Outlined.ArrowBack,
            tint = Color.White,
            contentDescription = stringResource(R.string.label_back)
        )
    }
    Column( modifier = Modifier
        .fillMaxSize().padding(horizontal = 72.dp, vertical = 10.dp)) {

        Text( text = stringResource(id = R.string.topbar_title),
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
        Text(
            text = pet.breed,
            style = MaterialTheme.typography.subtitle2,
            fontSize = 20.sp,
            color = Color.DarkGray,
            modifier = HzPadding
        )
        Spacer(Modifier.height(4.dp))
        PetDetailText(
            modifier = HzPadding,
            text = pet.description,
        )

        Spacer(Modifier.height(8.dp))
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