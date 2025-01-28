package com.example.jetcomposebasics.superheroes

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.jetcomposebasics.R

data class Hero(
    @StringRes val nameRes: Int,
    @StringRes val descRes: Int,
    @DrawableRes val imageRes: Int,
)

object HeroesRepository {
    val heroes = listOf(
        Hero(
            nameRes = R.string.hero1,
            descRes = R.string.description1,
            imageRes = R.drawable.android_superhero1
        ),
        Hero(
            nameRes = R.string.hero2,
            descRes = R.string.description2,
            imageRes = R.drawable.android_superhero2
        ),
        Hero(
            nameRes = R.string.hero3,
            descRes = R.string.description3,
            imageRes = R.drawable.android_superhero3
        ),
        Hero(
            nameRes = R.string.hero4,
            descRes = R.string.description4,
            imageRes = R.drawable.android_superhero4
        ),
        Hero(
            nameRes = R.string.hero5,
            descRes = R.string.description5,
            imageRes = R.drawable.android_superhero5
        ),
        Hero(
            nameRes = R.string.hero6,
            descRes = R.string.description6,
            imageRes = R.drawable.android_superhero6
        )
    )
}