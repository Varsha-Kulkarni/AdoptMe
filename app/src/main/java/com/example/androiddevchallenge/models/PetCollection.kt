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

import androidx.compose.runtime.Immutable
import com.example.androiddevchallenge.R

/**
 * A fake repo
 */
object PetRepo {
    fun getPet(petId: Int): Pet? {
        return petCollections.flatMap {
            it.pets
        }.firstOrNull { pet ->
            pet.petId == petId
        }
    }

    fun getFilters() = filters
}

@Immutable
data class PetCollection(
    val id: Int,
    val name: String,
    val pets: List<Pet>
)

val petCollections = listOf(
    PetCollection(
        id = 0,
        name = "Dogs",
        pets = listOf(
            Pet(
                0,
                "Froyo",
                "Male",
                "2 Years old",
                listOf(
                    "smart", "energetic", "loyal", "affectionate", "smart", "active", "friendly",
                    "gentle", "calm", "loving", "sweet-tempered"
                ),
                R.drawable.afador,
                "Animals Matter To Me NGO, Mumbai",
                "Afador",
                "The Afador is a mixed breed dog–a cross between the Afghan Hound and " +
                    "Labrador Retriever dog breeds. Loyal, energetic, and affectionate, Afadors" +
                    " make excellent family pets, although they do better with older children.\n" +
                    "The most common Afador colors include black, brown, gray, red, and fawn.\n" +
                    "Shedding will definitely occur! Lots of grooming is required to keep the breed's" +
                    " coat in good condition--consider twice weekly brushing to be the minimum.\n" +
                    "The Afador does much better in colder climates rather than warm ones. Even so, kit " +
                    "your Afador out with a suitable winter coat if temperatures really drop.\n" +
                    "As an athletic mixed breed, the Afador will love to play fetch and folic in a safe" +
                    " off-leash environment. If you have a fenced-in yard, be warned that this is a" +
                    " dog that can easily leap over a six foot fence, so plan accordingly.\n" +
                    "Due to the breed's intelligence and stubborn streak, you'll want to make sure " +
                    "that both the dog and your children are properly trained to be around each " +
                    "other from day one."
            ),
            Pet(
                1,
                "Donut",
                "Male",
                "6 months old",
                listOf(
                    "smart", "energetic", "loyal", "affectionate", "smart", "active", "friendly",
                    "gentle", "calm", "loving", "sweet-tempered"
                ),
                R.drawable.beaglier,
                "PAWS, New Delhi",
                "Beaglier",
                "The Beaglier is a mixed breed dog, a cross between the Beagle and " +
                    "Cavalier King Charles Spaniel dog breeds. Compact, energetic, and loyal, " +
                    "these adorable pups make great family additions for active singles or " +
                    "families with older children.\n" +
                    "The main colors of Beagliers are combinations of brown, black, white, and cream. " +
                    "Sometimes their coats are solid, but usually they're a combination of these " +
                    "colors.\nThey typically have short, shiny coats, and they're generally " +
                    "pretty easy to groom. A good brushing per week will probably do.\n" +
                    "Beagliers are prone to weight gain, and they have high energy levels. Make sure" +
                    " your dog gets at least one good half-hour- to hour-long walk per day with " +
                    "a few good, active play sessions and shorter walks mixed in.\n" +
                    "As for training, it may come down to the luck of the draw. Some are easily " +
                    "trainable, while other Beaglier parents report them to be somewhat stubborn." +
                    " Positive enforcement is the way to go with these pups.\n" +
                    "Because the Beaglier is a small dog, they can be easily injured by overly excited " +
                    "children. Beagliers prefer to be mostly around adults or older kids who know " +
                    "how to play gently.\n" +
                    "When it comes to other pets, Beagliers can get along with other animals if they " +
                    "are introduced slowly and calmly, and early socialization will help this go" +
                    " smoothly. It's best if they get used to other pets early."
            ),
            Pet(
                2,
                "Eclair",
                "Male",
                "8 months old",
                listOf(
                    "smart", "loyal", "affectionate", "smart", "friendly",
                    "gentle", "calm", "loving", "sweet-tempered"
                ),
                R.drawable.bulldog,
                "Pet Lovers Society, Bangalore",
                "Bulldog",
                "The breed originated in England, the Bulldog is a medium-size dog with " +
                    "a thick-set, low-slung body. The Bulldog was originally used to drive cattle " +
                    "to market and to compete in a bloody sport called bullbaiting. Today, they’re " +
                    "gentle companions who love kids.\n" +
                    "Bulldogs can be stubborn and lazy. Your mature Bulldog may not be very " +
                    "enthusiastic about going to a walk, but it's important that he is exercised " +
                    "every day to keep him fit.\n" +
                    " Bulldogs can't tolerate heat and humidity. When your Bulldog is outdoors, " +
                    "watch him carefully for signs of overheating and take him inside immediately " +
                    "if he starts to show distress. Some people put kiddy play pools filled with " +
                    "water in a shaded spot for their Bulldogs to lie in when the weather is warm " +
                    "and everyone is outside. They definitely are housedogs and should not live " +
                    "outdoors all of the time.\n" +
                    "Bulldogs are sensitive to cold weather.\n" +
                    "Bulldogs wheeze, snort, and snore. They also are prone to sleep apnea.\n" +
                    "Bulldogs are well-known for having flatulence. If this problem seems excessive " +
                    "with yours, talk to your vet.\n" +
                    "Bulldogs' short noses make them prone to a number of respiratory ailments.\n" +
                    "Bulldogs can have pinched nostrils that make it difficult for them to breathe " +
                    "and may require surgery to correct.\n" +
                    "Bulldogs are greedy eaters and will overeat if given the chance. Since they " +
                    "gain weight easily, they can quickly become obese if you don't monitor " +
                    "their food intake.\n" +
                    "Because of the size of their heads and fronts, Bulldogs have difficulty giving " +
                    "birth. Most require caesareans to deliver their puppies. It isn't advised " +
                    "for inexperienced breeders to try to breed them.\n" +
                    "As a short-nosed breed, Bulldogs are sensitive to anesthesia. Be sure to talk " +
                    "with your vet about this before any surgeries are done.\n" +
                    "To get a healthy pet, never buy a puppy from a backyard breeder, puppy mill, " +
                    "or pet store. Find a reputable breeder who tests her breeding dogs for " +
                    "genetic health conditions and good temperaments."
            ),
            Pet(
                3,
                "Oreo",
                "Male",
                "3 Years old",
                listOf(
                    "devoted",
                    "smart",
                    "energetic",
                    "loyal",
                    "affectionate",
                    "smart",
                    "active",
                    "friendly",
                    "gentle",
                    "calm",
                    "loving",
                    "sweet-tempered"
                ),
                R.drawable.goldador,
                "Dog Temple, Goa",
                "Goldador",
                "Goldadors like to eat and can easily become overweight if they don't " +
                    "get enough exercise.\n" +
                    "Loving, devoted, and energetic, Goldador mixed breed dogs are prized for " +
                    "their good-natured trainability. As a cross between the Golden Retriever " +
                    "and Labrador Retriever, this mix inherited some of the best traits from " +
                    "both purebred parents.\n" +
                    "Goldadors are good family dogs and generally do well with children of all ages.\n" +
                    "The Goldador sheds moderately and requires weekly brushing.\n" +
                    "Goldadors usually get along well with other dogs and pets, especially when " +
                    "they're raised with them or socialized to them at an early age.\n" +
                    "Goldadors require about 30 minutes of exercise per day. They enjoy being " +
                    "outdoors and can make excellent jogging companions.\n" +
                    "Although a house with a fenced yard is the ideal home for a Goldador, he can " +
                    "do well in an apartment or condo with proper exercise.\n" +
                    "Goldadors can be a good choice for first-time dog owners.\n" +
                    "To get a healthy dog, never buy a puppy from a puppy mill, a pet store, or a " +
                    "breeder who doesn't provide health clearances or guarantees. Look for a " +
                    "reputable breeder who tests her breeding dogs to make sure they're free of " +
                    "genetic diseases that they might pass onto the puppies and who breeds for " +
                    "sound temperaments."
            ),

        )
    ),
    PetCollection(
        id = 1,
        name = "Cats",
        pets = listOf(
            Pet(
                4,
                "Pie",
                "Male",
                "1 Year old",
                listOf(
                    "cute",
                    "smart",
                    "energetic",
                    "loyal",
                    "affectionate",
                    "smart",
                    "active",
                    "friendly",
                    "gentle",
                    "calm",
                    "loving",
                    "sweet-tempered"
                ),
                R.drawable.munchkin,
                "Pet Lovers Society, Bangalore",
                "Munchkin",
                "\"The Munchkin cat is a relatively new breed of cat characterized by its very short legs. These cute, curious cats are known for snatching shiny objects, so don’t be surprised if you find your favorite piece of jewelry missing:)\n" +
                    "The Munchkin is considered to be the original breed of dwarf cat. It is a small to medium-sized cat with a moderate body type and medium-plush coat.The Munchkin comes in all coat colors and patterns." +
                    "The name \"munchkin\" derives from writer L. Frank Baum's diminutive inhabitants of Munchkin Country, originating in the 1900 novel, 'The Wonderful Wizard of Oz'. The Munchkin has similar characteristics to normal domestic cats, the hind legs can be slightly longer than the front which creates a slight rise from the shoulder to the rump. " +
                    "The Munchkin has been crossed with the curly-coated LaPerm to create the Skookum, the hairless Sphynx to create the Minskin and Bambino, another curly-coated Selkirk Rex to create the Lambkin, the Persian breed group (which includes Himalayans and Exotic Shorthair) to create the Napoleon, the curled-eared American Curl to create the Kinkalow, " +
                    "the folded-eared Scottish Fold to create the Scottish Kilts, and also with the Bengal to create the Genetta."
            ),

            Pet(
                5,
                "Ginger",
                "Female",
                "1 Year old",
                listOf(
                    "loyal", "affectionate", "smart", "active", "friendly",
                    "gentle", "calm", "loving", "sweet-tempered", "smart"
                ),
                R.drawable.himalayan,
                "CARE, Ahmedabad",
                "Himalayan",
                "\"The Himalayans are wonderful indoor cat companions, gentle, calm, and" +
                    " sweet-tempered. Himalayans have low exercise needs, but they are extremely" +
                    " playful and will get into mischief if they become bored. " +
                    "You can keep them entertained and engaged by providing plenty of cat toys and " +
                    "dedicating a few minutes to playtime each day. " +
                    "Because Himalayans have such playful personalities, something as simple as a " +
                    "ball of paper will keep them entertained for hours.\n" +
                    "The Himalayan (a.k.a. Himalayan Persian, or Colourpoint Persian as it is " +
                    "commonly referred to in Europe), is a breed or sub-breed of long-haired cat " +
                    "similar in type to the Persian, " +
                    "with the exception of its blue eyes and its point colouration, which were " +
                    "derived from crossing the Persian with the Siamese. " +
                    "Some registries may classify the Himalayan as a long-haired sub-breed of Siamese, " +
                    "or a colorpoint sub-breed of Persian. The World Cat Federation has merged " +
                    "them with the Colorpoint Shorthair and Javanese into a single breed, the " +
                    "Colorpoint. Like Persians more generally, the Himalayan tends to have a " +
                    "round (cobby) body with short legs, " +
                    "which makes it harder for them to jump as high as other cats do. The bulk of " +
                    "the fur on the body of a Himalayan is white or cream, " +
                    "but the points come in many different colors: Seal (or Black), Blue, Lilac, " +
                    "Chocolate, Red (Flame), and Cream. The points can also be Tabby, Lynx, or " +
                    "Tortoiseshell-patterned."
            ),
        )
    )
)
