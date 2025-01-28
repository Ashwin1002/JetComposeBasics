package com.example.jetcomposebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetcomposebasics.woofmaterial.data.Dog
import com.example.jetcomposebasics.woofmaterial.data.Dogs.dogs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.jetcomposebasics.superheroes.Hero
import com.example.jetcomposebasics.superheroes.HeroesRepository.heroes
import com.example.jetcomposebasics.ui.theme.JetComposeBasicsTheme


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetComposeBasicsTheme() {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SuperHeroesApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun SuperHeroesApp() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            SuperHeroesTopBar()
        }
    ) {
            it ->
        LazyColumn(contentPadding = it) {
            items(heroes.size) {
                SuperHeroCard(
                    hero = heroes[it],
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)// Animate each list item to slide in vertically

                )
            }
        }
    }
}

@Composable
fun SuperHeroCard(hero: Hero, modifier: Modifier = Modifier) {
    Card (
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        modifier = modifier

    ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .sizeIn(minHeight = 72.dp)
        ){
            Column (
                modifier = Modifier.weight(1f),
            ){
                Text(
                    text = stringResource(hero.nameRes),
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = stringResource(hero.descRes),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Spacer(modifier = Modifier.padding(end = 16.dp))
            Box(
                modifier = Modifier
                    .size(72.dp)
                    .clip(RoundedCornerShape(8.dp))
            ){
                Image(
                    painter = painterResource(hero.imageRes),
                    contentDescription = stringResource(hero.nameRes),
                    alignment = Alignment.TopCenter,
                    contentScale = ContentScale.FillWidth
                )
            }

        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperHeroesTopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = "Superheroes",
                style = MaterialTheme.typography.displayMedium
            )
        }
    )
}

/**
 * Composable that displays what the UI of the app looks like in light theme in the design tab.
 */
@Preview
@Composable
fun WoofPreview() {
    JetComposeBasicsTheme(darkTheme = false) {
        SuperHeroesApp()
    }
}

@Preview
@Composable
fun WoofDarkThemePreview() {
    JetComposeBasicsTheme(darkTheme = true) {
        SuperHeroesApp()
    }
}