# Adopt Me

<!--- Replace <OWNER> with your Github Username and <REPOSITORY> with the name of your repository. -->
<!--- You can find both of these in the url bar when you open your repository in github. -->
![Workflow result](https://github.com/Varsha-Kulkarni/AdoptMe/workflows/Check/badge.svg)


## :scroll: Description
<!--- Describe your app in one or two sentences -->
This is a Pet Adoption app UI, built with [Jetpack Compose](https://developer.android.com/jetpack/compose).

## :bulb: Motivation and Context

Jetpack Compose is Android’s modern toolkit for building native UI. It simplifies and accelerates UI development on Android. Quickly bring your app to life with less code, powerful tools, and intuitive Kotlin APIs.

## Features
### The app contains an overview screen that displays a list of pets, and a detail screen showing each pet's details.
These screens use prepoulated dummy data and compose different custom `Composable` functions.
- Use `Row` and `Column` to arrange the contents of the UI, the style setting.
- Add `TopAppBar`
- Use `Material` `Typography` to style the text
- Use `elevation` to make the Cards stand out from the background
- Use Navigation component, with passing arguments to a destination
- Use `LazyColumn` and `LazyRow` to show how only visible items are loaded into the list
- Use `painterResource` to load image drawable resources
- Use `Layout` to show [VerticalGrid](https://github.com/android/compose-samples/blob/main/Jetsnack/) of two columns
- Use `Box` with `ScrollState`, simulate [Collapsible Toolbar](https://github.com/android/compose-samples/blob/main/Jetsnack/)
- Use of [`FilterChip`](https://github.com/android/compose-samples/blob/main/Jetsnack/) to show filters
- Use `CircleShape` to display images

## :camera_flash: Screenshots
<!-- You can add more screenshots here if you like -->
<img src="/results/screenshot_1.png" width="260">&emsp;<img src="/results/screenshot_2.png" width="260">&emsp;<img src="/results/screenshot_3.png" width="260">
## :gif: Animated Preview of the App
<img src="/results/video.gif" width="260">

### Image Sources
- [Afador](https://www.dogtime.com/)
- [Beaglier](https://puppytoob.com/beaglier/)
- [Bulldog](https://dogtime.com/dog-breeds/bulldog)
- [Goldador](https://animalso.com/breeds/goldador/)
- [Munchkin](https://www.thehappycatsite.com/munchkin-cat/)
- [Himalayan](https://en.wikipedia.org/wiki/Himalayan_cat#/media/File:Himalayan-sharapova.jpg)

## License
```
Copyright 2020 The Android Open Source Project

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```