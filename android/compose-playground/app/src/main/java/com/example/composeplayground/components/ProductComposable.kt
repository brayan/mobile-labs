package com.example.composeplayground.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Colors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeplayground.domain.model.Product
import java.math.BigDecimal
import com.example.composeplayground.R
import com.example.composeplayground.ui.theme.Purple200
import com.example.composeplayground.ui.theme.Purple500
import com.example.composeplayground.ui.theme.Teal200

@Composable
fun ProductComposable(product: Product, onClick: () -> Unit) {
    Column(
        Modifier
            .height(250.dp)
            .width(200.dp)
            .background(Color.White)
            .clickable { onClick() }
    ) {
        Box(
            Modifier
                .background(brush = Brush.horizontalGradient(colors = listOf(Purple500, Teal200)))
                .height(100.dp)
                .fillMaxWidth()
        )
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            Modifier
                .size(100.dp)
                .offset(y = (-50).dp)
                .clip(CircleShape)
                .align(CenterHorizontally)
        )

        Column {
            Text(
                text = product.name,
                modifier = Modifier.fillMaxWidth().background(Color.Gray).padding(16.dp),
                fontSize = 14.sp
            )
            Text(
                text = product.price.toString(),
                modifier = Modifier.background(Color.LightGray).padding(16.dp),
            )
        }


    }
}

@Preview
@Composable
fun MyPrev() {
    val product = Product("Lorem ipsum is placeholder text", BigDecimal("14.99"))
    ProductComposable(product) {

    }
}