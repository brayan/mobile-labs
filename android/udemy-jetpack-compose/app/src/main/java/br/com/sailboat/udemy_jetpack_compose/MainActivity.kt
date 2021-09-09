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
fun CoreUiCompose() {
    Surface(
        color = Color.DarkGray,
        modifier = Modifier.fillMaxSize(), // match height and width
    ) {
        Surface(
            color = Color.Blue,
            modifier = Modifier.wrapContentSize(align = Alignment.TopEnd),
        ) {
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
fun BasicMainActivityCompose(context: Context) {
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
fun GreetingText(name: String) {
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
fun GreetingButton(name: String, onClick: () -> Unit) {
    Button(onClick = onClick) {
        GreetingText(name = "Click-me, $name!!")
        GreetingText(name = "Hello!")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewMainActivity() {
    CoreUiCompose()
}