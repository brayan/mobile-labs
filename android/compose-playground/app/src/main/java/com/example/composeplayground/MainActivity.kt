package com.example.composeplayground

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeplayground.ui.theme.ComposePlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainActivityComposable()
        }
    }
}

@Composable
private fun MainActivityComposable() {
    ComposePlaygroundTheme {
        Surface {
            MyFirstComposable()
        }
    }
}

@Composable
private fun MyFirstComposable() {
    Text(text = "My first composable")
    Text(text = "My second text")
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun ColumnPreview() {
    Column(modifier = Modifier
        .background(Color.Blue)
        .padding(all = 16.dp) // Order matters!
        .fillMaxWidth()
        .wrapContentHeight()
    ) {
        MyFirstComposable()
    }
}

@Preview(showBackground = true)
@Composable
fun RowPreview() {
    Row {
        MyFirstComposable()
    }
}

@Preview(showBackground = true)
@Composable
fun BoxPreview() {
    Box {
        MyFirstComposable()
    }
}

@Preview(
    name = "New Preview",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
)
@Preview(
    name = "Text Preview",
    heightDp = 200,
    widthDp = 300,
    showBackground = true
)
@Composable
fun DefaultPreview() {
    MainActivityComposable()
}
