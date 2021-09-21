package br.com.sailboat.udemy_jetpack_compose

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.sailboat.udemy_jetpack_compose.ui.theme.UdemyjetpackcomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoreUiCompose()
        }
    }
}

@Composable
private fun CoreUiCompose() {
    Surface(
        color = Color.DarkGray,
        modifier = Modifier.fillMaxSize(), // match height and width
    ) {
//        PlayingWithColumnsRowsAndTexts()
        PlayingWithColumnsRowsAndSquares()
    }
}

@Composable
private fun PlayingWithColumnsRowsAndSquares() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ColoredSquare(color = Color.Red)
            ColoredSquare(color = Color.Magenta)
        }
        ColoredSquare(color = Color.Cyan)
        ColoredSquare(color = Color.Yellow)
        ColoredSquare(color = Color.Blue)
    }
}

@Composable
private fun PlayingWithColumnsRowsAndTexts() {
    Surface(
        color = Color.Blue,
//            modifier = Modifier.wrapContentSize(align = Alignment.TopStart),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
    ) {
        Column(
            modifier = Modifier.padding(all = 16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "One",
                    color = Color.White,
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(end = 16.dp),
                    style = MaterialTheme.typography.body1
                )
                Text(
                    text = "Two",
                    color = Color.White,
                    modifier = Modifier.wrapContentSize(),
                    style = MaterialTheme.typography.body1
                )
            }
            Text(
                text = "Wrapped content, height and width",
                color = Color.White,
                modifier = Modifier.wrapContentSize(),
                style = MaterialTheme.typography.body1
            )
            Text(
                text = "Wrapped content, height and width",
                color = Color.White,
                modifier = Modifier.wrapContentSize(),
                style = MaterialTheme.typography.body1
            )
        }
    }
}

@Composable
private fun ColoredSquare(color: Color) {
    Surface(
        color = color,
        modifier = Modifier
            .height(100.dp)
            .width(100.dp)
    ) {

    }
}

@Composable
private fun BasicMainActivityCompose(context: Context) {
    UdemyjetpackcomposeTheme {
        Surface(color = MaterialTheme.colors.background) {
            GreetingText("Android")
            GreetingButton("Android", onClick = {
                Toast.makeText(context, "Hey!", Toast.LENGTH_SHORT).show()
            })
        }
    }
}

@Composable
private fun GreetingText(name: String) {
    Text(
        text = "Hello, $name!",
        modifier = Modifier
//            .fillMaxHeight()
            .fillMaxWidth()
//            .wrapContentWidth()
            .wrapContentHeight()
//            .width(80.dp)
//            .height(240.dp)
            .clickable { }
//            .padding(all = 12.dp)
            .padding(horizontal = 16.dp, vertical = 8.dp),
//            style = TextStyle(
//                color = Color.White,
//                fontWeight = FontWeight.SemiBold,
//                fontSize = 18.sp
//            )
        style = MaterialTheme.typography.h5,
        fontWeight = FontWeight.SemiBold
    )
}

@Composable
private fun GreetingButton(name: String, onClick: () -> Unit) {
    Button(onClick = onClick) {
        GreetingText(name = "Click-me, $name!!")
        GreetingText(name = "Hello!")
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreviewMainActivity() {
    CoreUiCompose()
}