package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun PetDetail(petId: Int) {
    val pet = defaultPets[petId]
    val image = painterResource(pet.imageResource)
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text("Adopt Me!")
            })
        }) {
        Surface(shape = RoundedCornerShape(8.dp), elevation = 8.dp, modifier = Modifier.padding(16.dp)) {

            Column(modifier = Modifier.fillMaxWidth()) {
                Image(
                    image, "${pet.name} Pet Image",
                    Modifier
                        .aspectRatio(1.77f, true),
                    Alignment.Center, ContentScale.Fit,
                )

                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Hi! I am "+pet.name, style = MaterialTheme.typography.h4, modifier = Modifier.padding(bottom = 4.dp))
                    Text("My breed: "+pet.breed,style = MaterialTheme.typography.body1, modifier = Modifier.padding(bottom = 4.dp))
                    Text("About Me: "+pet.description,style = MaterialTheme.typography.body1, modifier = Modifier.padding(bottom = 4.dp))
                    Text("Please come, get me here! \n"+pet.publisher,style = MaterialTheme.typography.body1, modifier = Modifier.padding(bottom = 4.dp))
                }
            }
        }
    }
}