package com.example.jetcomposebasics.gridviewcard

import android.os.Bundle
import android.widget.GridView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetcomposebasics.ui.theme.JetComposeBasicsTheme
import com.example.jetcomposebasics.R

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetComposeBasicsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    GridViewApp()
                }
            }
        }
    }
}


@Composable
fun GridViewApp() {
    val layoutDirection = LocalLayoutDirection.current
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(
                start = WindowInsets.safeDrawing.asPaddingValues()
                    .calculateStartPadding(layoutDirection),
                end = WindowInsets.safeDrawing.asPaddingValues()
                    .calculateEndPadding(layoutDirection),
            ),
    ) {
        GridViewList(
            topics = DataSource.topics
        )

    }
}

@Composable
fun GridViewList(topics: List<Topic>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(topics.size) { index ->
            GridViewCard(topic = topics[index], modifier = modifier)
        }
    }
}

@Composable
fun GridViewCard(topic: Topic, modifier: Modifier = Modifier) {
    Card(modifier = modifier, shape = RoundedCornerShape(size = 12.dp)) {
        Row {
            Image(
                painter = painterResource(topic.imageResourceId),
                contentDescription = stringResource(topic.stringResourceId),
                modifier = Modifier.size(68.dp),
                contentScale = ContentScale.Crop
            )

            Column (
                modifier = Modifier.padding(horizontal = 16.dp).padding(top = 16.dp).fillMaxWidth()
            ){
                Text(
                    stringResource(topic.stringResourceId),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Row (
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        painter = painterResource(R.drawable.percent),
                        contentDescription = "icon",
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(
                        text = "${topic.count}",
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun GridViewAppPreview() {
    GridViewCard(Topic(R.string.architecture, 321, R.drawable.image1))
}
