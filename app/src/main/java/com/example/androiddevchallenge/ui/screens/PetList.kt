package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.models.Pet


val defaultPets = listOf(
    Pet(0, "Sandy", "The Afador is a mixed breed dog–a cross between the Afghan Hound and Labrador Retriever dog breeds. Loyal, energetic, and affectionate, Afadors make excellent family pets, although they do better with older children.",R.drawable.afador,"Contact: Animals Matter To Me NGO, Mumbai","Afador","dog"),
    Pet(1, "Mat", "The Beaglier is a mixed breed dog — a cross between the Beagle and Cavalier King Charles Spaniel dog breeds. Compact, energetic, and loyal, these adorable pups make great family additions for active singles or families with older children in large homes or small apartments.",R.drawable.beaglier,"Contact: PAWS, New Delhi","Beaglier", "dog"),
    Pet(2, "Brownie", "The Bulldog was originally used to drive cattle to market and to compete in a bloody sport called bullbaiting. Today, they’re gentle companions who love kids.",R.drawable.bulldog,"Contact: Pet Lovers Society, Bangalore","Bulldog", "dog"),
    Pet(3, "Chetak", "Loving, devoted, and energetic, Goldador mixed breed dogs are prized for their good-natured trainability. As a cross between the Golden Retriever and Labrador Retriever, this mix inherited some of the best traits from both purebred parents.",R.drawable.goldador,"Contact: Dog Temple, Goa","Goldador", "dog"),
    Pet(4, "Pinky", "The Munchkin cat has no problem getting around the same as its longer-limbed feline friends — it just might take them a few extra steps along the way. These cute, curious cats are known for snatching shiny objects, so don’t be surprised if these “magpies” borrow your favorite piece of jewelry:)",R.drawable.munchkin,"Contact: Contact: Pet Lovers Society, Bangalore","Munchkin", "cat"),
    Pet(5, "Purr", "“Himmies,” as they are sometimes called, are wonderful indoor cat companions. They are gentle, calm, and sweet-tempered, and possess a playful side as well.",R.drawable.himalayan,"Contact: Charlie's Animal Rescue Centre (CARE), Ahmedabad","Himalayan", "cat"),
)

@Composable
fun PetList(openDetails: (Int) -> Unit, pets: List<Pet>) {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text("Adopt Me!")
            })
        }) {
        LazyColumn {
            items(pets) {
                PetCard(it, Modifier.padding(16.dp), openDetails = { openDetails(it.petId) })
            }
        }
    }
}

@Composable
fun PetCard(pet: Pet, modifier: Modifier, openDetails: () -> Unit = {}) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                bottom = 6.dp,
                top = 6.dp,
            )
            .fillMaxWidth()
            .clickable(onClick = openDetails),
        elevation = 8.dp,
    ){
        Surface(shape = RoundedCornerShape(8.dp), elevation = 8.dp, modifier = modifier) {
            val image = painterResource(id = pet.imageResource)
            Column(modifier = Modifier.fillMaxWidth()) {
                Image(
                    image,"${pet.name} Pet Image",
                    Modifier
                        .aspectRatio(1.77f, true)
                        , Alignment.Center,ContentScale.Fit, )

                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Hi! I am "+pet.name, style = MaterialTheme.typography.h4, modifier = Modifier.padding(bottom = 4.dp))
                    Text("My breed: "+pet.breed,style = MaterialTheme.typography.body1, modifier = Modifier.padding(bottom = 4.dp))
                }
            }
        }
    }
}