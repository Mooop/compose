package com.example.androiddevchallenge.data

import androidx.annotation.DrawableRes
import com.example.androiddevchallenge.R

data class PlantTheme(val name: String, @DrawableRes val cover: Int)
data class Plant(val name: String, @DrawableRes val avatar: Int, val desc: String)

val PlantThemes = listOf(
    PlantTheme(
        name = "Desert chic",
        cover = R.drawable.plant_theme_one
    ),
    PlantTheme(
        name = "Tiny terrariums",
        cover = R.drawable.plant_theme_two
    ),
    PlantTheme(
        name = "Jungle vibes",
        cover = R.drawable.plant_theme_three
    ),
    PlantTheme(
        name = "Easy care",
        cover = R.drawable.plant_theme_four
    ),
    PlantTheme(
        name = "Statements",
        cover = R.drawable.plant_theme_five
    ),
)

val Plants = listOf(
    Plant(
        name = "Monstera",
        avatar = R.drawable.plant_one,
        desc = "This is a description"
    ),
    Plant(
        name = "Aglaonema",
        avatar = R.drawable.plant_two,
        desc = "This is a description"
    ),
    Plant(
        name = "Peace lily",
        avatar = R.drawable.plant_three,
        desc = "This is a description"
    ),
    Plant(
        name = "Fiddle leaf tree",
        avatar = R.drawable.plant_four,
        desc = "This is a description"
    ),
    Plant(
        name = "Snake plant",
        avatar = R.drawable.plant_five,
        desc = "This is a description"
    ),
    Plant(
        name = "Pothos",
        avatar = R.drawable.plant_six,
        desc = "This is a description"
    )
)
