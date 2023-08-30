package com.example.composeplayground.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeplayground.R
import com.example.composeplayground.domain.model.Product
import com.example.composeplayground.ui.theme.Purple200
import com.example.composeplayground.ui.theme.Purple500
import com.example.composeplayground.ui.theme.Purple700
import com.example.composeplayground.ui.theme.Teal200
import java.math.BigDecimal

@Composable
fun ProductKitComposable(description: String, onClick: () -> Unit) {
    Surface(Modifier.padding(16.dp), shape = RoundedCornerShape(15.dp), elevation = 4.dp) {
        Row(
            Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.White)
                .clickable { onClick() }
        ) {
            val imageSize = 100.dp
            val imageOffset = imageSize / 2
            Box(
                Modifier
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Purple700,
                                Purple500,
                                Purple200,
                            )
                        )
                    )
                    .width(imageSize)
                    .fillMaxHeight()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null,
                    Modifier
                        .size(imageSize)
                        .offset(x = imageOffset)
                        .clip(CircleShape)
                        .align(Alignment.Center)
                        .border(BorderStroke(3.dp, Purple200), CircleShape)
                )
            }
            Spacer(modifier = Modifier.width(imageOffset))
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = description,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight(500),
                    ),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 6,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(16.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun ProductKitComposablePreview() {
    val description = "Lorem ipsum is placeholder text"
    ProductKitComposable(description) {

    }
}