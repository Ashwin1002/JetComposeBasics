package com.example.jetcomposebasics.lemonade

import com.example.jetcomposebasics.R

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.jetcomposebasics.ui.theme.WoofTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WoofTheme() {
                Scaffold (
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        CenterAlignedTopAppBar(
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = Color.Yellow,
                                titleContentColor = Color.Black,
                            ),

                            title = {
                                Text(
                                    stringResource(R.string.lemonade),
                                    fontWeight = FontWeight.W600,
                                    textAlign = TextAlign.Center
                                )
                            }
                        )
                    }
                ) {
                        innerPadding ->
                    Surface(
                        modifier = Modifier.padding(innerPadding),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        Lemonade()
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun Lemonade() {
    var currentStep by remember { mutableIntStateOf(1) }
    var squeezeCount by remember { mutableIntStateOf(0) }

    when(currentStep) {
        1 -> LemonadeImageButton(
            modifier = Modifier,
            onClick = {
                currentStep = 2
                squeezeCount = (2..4).random()
            },
            textLabelResourceId = R.string.tap_lemon,
            drawableResourceId = R.drawable.lemon_tree,
            contentDescriptionResourceId = R.string.tap_lemon,
        )
        2 -> LemonadeImageButton(
            modifier = Modifier,
            onClick = {
                squeezeCount--
                if(squeezeCount <= 0){
                    currentStep = 3
                }
            },
            textLabelResourceId = R.string.keep_tapping,
            drawableResourceId = R.drawable.lemon_squeeze,
            contentDescriptionResourceId = R.string.keep_tapping,
        )
        3 -> LemonadeImageButton(
            modifier = Modifier,
            onClick = {
                currentStep = 4
            },
            textLabelResourceId = R.string.drink_lemonade,
            drawableResourceId = R.drawable.lemon_drink,
            contentDescriptionResourceId = R.string.drink_lemonade,
        )
        else -> LemonadeImageButton(
            modifier = Modifier,
            onClick = {
                currentStep = 1
            },
            textLabelResourceId = R.string.start_again,
            drawableResourceId = R.drawable.lemon_restart,
            contentDescriptionResourceId = R.string.start_again,
        )
    }
}

@Composable
fun LemonadeImageButton(
    modifier: Modifier,
    onClick: () -> Unit,
    textLabelResourceId: Int,
    drawableResourceId: Int,
    contentDescriptionResourceId: Int
) {
    Column (
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Button(
            onClick = onClick,
            shape = RoundedCornerShape(dimensionResource(R.dimen.button_corner_radius)),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xff92CA91))
        ) {
            Image(
                painter = painterResource(drawableResourceId),
                contentDescription = stringResource(contentDescriptionResourceId),
                modifier = Modifier
                    .width(dimensionResource(R.dimen.button_image_width))
                    .height(dimensionResource(R.dimen.button_image_height))
                    .padding(dimensionResource(R.dimen.button_interior_padding))
            )
        }
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_vertical)))
        Text(
            text = stringResource(textLabelResourceId),
            style = MaterialTheme.typography.bodyLarge.copy(
                fontSize = 16.sp
            )
        )
    }
}

