package com.example.androiddevchallenge.ui.screens

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.FilterList
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.models.Filter
import com.example.androiddevchallenge.models.Pet
import com.example.androiddevchallenge.models.PetCollection
import com.example.androiddevchallenge.models.PetRepo
import com.example.androiddevchallenge.ui.components.PetImage
import com.example.androiddevchallenge.ui.components.VerticalGrid
import com.example.androiddevchallenge.ui.components.getBackgroundColorForElevation
import dev.chrisbanes.accompanist.insets.statusBarsHeight

@Composable
fun FilterBar(filters: List<Filter>) {
    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(start = 8.dp, end = 8.dp),
        modifier = Modifier.heightIn(min = 56.dp)
    ) {
        item {
            IconButton(onClick = { /* todo */ }) {
                Icon(
                    imageVector = Icons.Rounded.FilterList,
                    tint = MaterialTheme.colors.primary,
                    contentDescription = stringResource(R.string.label_filters),
                    modifier = Modifier.background(
                        color = Color.White,
                        shape = RectangleShape
                    )

                )
            }
        }
        items(filters) { filter ->

            FilterChip(filter)
        }
    }
}

@Composable
fun FilterChip(
    filter: Filter,
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.small
) {
    val (selected, setSelected) = filter.enabled
    val backgroundColor by animateColorAsState(
        if (selected) MaterialTheme.colors.primary else Color.White
    )
    val textColor by animateColorAsState(
        if (selected) Color.LightGray else MaterialTheme.colors.secondary
    )
    Surface(
        modifier = modifier
            .height(30.dp),
        color = backgroundColor,
        contentColor = textColor,
        shape = shape,
        elevation = 2.dp
    ) {
        Box(
            modifier = Modifier.toggleable(
                value = selected,
                onValueChange = setSelected
            )
        ) {
            Text(
                text = filter.name,
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

@Composable
fun PetList(selectPet: (Int) -> Unit, petCollections: List<PetCollection>) {
    val filters = remember { PetRepo.getFilters() }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(id = R.string.appbar_title))
                }
            )
        }
    ) {

        LazyColumn {
            item {
                Spacer(Modifier.statusBarsHeight(additional = 4.dp))
                FilterBar(filters)
            }
            items(petCollections) { collection ->
                PetCollection(collection, selectPet)
            }
        }
        Spacer(Modifier.height(8.dp))
    }
}

@Composable
private fun PetCollection(
    collection: PetCollection,
    selectPet: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        Text(
            text = collection.name,
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.primary,
            modifier = Modifier
                .heightIn(min = 56.dp)
                .padding(horizontal = 24.dp, vertical = 4.dp)
                .wrapContentHeight()
        )
        VerticalGrid(Modifier.padding(horizontal = 16.dp)) {
            collection.pets.forEach { pet ->
                PetItem(pet, Modifier.padding(16.dp), openDetails = { selectPet(pet.petId) })
            }
        }
        Spacer(Modifier.height(4.dp))
    }
}

@Composable
private
fun PetItem(pet: Pet, modifier: Modifier, openDetails: () -> Unit = {}) {
    Card(
        elevation = 4.dp,
        modifier = modifier
            .padding(
                bottom = 4.dp,
                top = 4.dp,
            )
            .fillMaxWidth()
            .clickable(onClick = openDetails)
    ) {
        Column(
            modifier = Modifier
                .clickable(onClick = openDetails)
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .height(140.dp)
                    .fillMaxWidth()
                    .background(
                        color = getBackgroundColorForElevation(Color.White, 4.dp),
                    )
            ) {
                Box(
                    modifier = Modifier
                        .height(100.dp)
                        .fillMaxWidth()
                        .background(
                            color = getBackgroundColorForElevation(Color.LightGray, 4.dp),
                        )

                )
                PetImage(
                    imageResource = pet.imageResource,
                    contentDescription = null,
                    modifier = Modifier
                        .size(130.dp)
                        .align(Alignment.BottomCenter)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                pet.name,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                pet.breed,
                style = MaterialTheme.typography.caption,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}
