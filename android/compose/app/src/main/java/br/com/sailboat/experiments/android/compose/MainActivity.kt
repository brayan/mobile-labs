package br.com.sailboat.experiments.android.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .border(5.dp, Color.Magenta)
                    .padding(16.dp)
                    .border(5.dp, Color.Blue)
                    .padding(16.dp)
            ) {
                Text(
                    "My text 1",
                    modifier = Modifier
                        .border(5.dp, Color.Yellow)
                        .padding(5.dp)
                        .offset(20.dp, 20.dp)
                        .border(10.dp, Color.Blue)
                        .padding(10.dp)
                        .clickable { }
                )
                Text("My text 2")
                Spacer(modifier = Modifier.height(50.dp))
                Text("My text 3")
                Spacer(modifier = Modifier.height(50.dp))
                val painter = painterResource(id = R.drawable.animal)
                val description = "Animal, the Muppet!"
                val title = "Animal, the Muppet!"
                ImageCard(painter = painter, contentDescription = description, title = title)
            }
        }
    }
}

@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = 4.dp
    ) {
        Box(modifier = Modifier.height(200.dp)) { // It's like FrameLayout
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
            )
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Brush.verticalGradient(colors = listOf(Color.Transparent, Color.Black), startY = 300f))
            ) {

            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart,
            ) {
                Text(title, style = TextStyle(color = Color.White, fontSize = 16.sp))
            }
        }
    }
}
