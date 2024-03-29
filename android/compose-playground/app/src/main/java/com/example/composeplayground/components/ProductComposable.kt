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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeplayground.R
import com.example.composeplayground.domain.model.Product
import com.example.composeplayground.extension.toBrazilianCurrency
import com.example.composeplayground.ui.theme.Purple500
import com.example.composeplayground.ui.theme.Teal200
import java.math.BigDecimal

@Composable
fun ProductComposable(product: Product, onClick: () -> Unit) {
    Surface(
        Modifier.padding(end = 16.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = 4.dp,
    ) {
        Column(
            Modifier
                .heightIn(min = 250.dp, max = 300.dp) // min and height
                .width(200.dp)
                .background(Color.White)
                .clickable { onClick() }
        ) {
            val imageSize = 100.dp
            val imageOffset = imageSize / 2
            Box(
                Modifier
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Purple500,
                                Teal200
                            )
                        )
                    )
                    .height(imageSize)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = product.image),
                    contentDescription = null,
                    Modifier
                        .size(imageSize)
                        .offset(y = imageOffset)
                        .clip(CircleShape)
                        .align(Alignment.BottomCenter),
                    contentScale = ContentScale.Crop,
                )
            }
            Spacer(modifier = Modifier.height(imageOffset))
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = product.name,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight(700),
                    ),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                )
                Text(
                    text = product.price.toBrazilianCurrency(),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400),
                    ),
                    modifier = Modifier
                        .padding(top = 8.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductComposablePreview() {
    val product = Product(
        name = LoremIpsum(50).values.first(),
        price = BigDecimal("14.99"),
        image = R.drawable.placeholder,
    )
    ProductComposable(product) {

    }
}
