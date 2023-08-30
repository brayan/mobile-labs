package com.example.composeplayground.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeplayground.domain.model.Product
import com.example.composeplayground.sample.productsSample

@Composable
fun ProductSection(title: String, products: List<Product>) {
    Column {
        Text(
            text = title,
            modifier = Modifier.padding(horizontal = 16.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight(400),
        )
        Row(
            Modifier
                .horizontalScroll(rememberScrollState())
                .padding(top = 8.dp)
                .padding(horizontal = 16.dp)
        ) {
            for (product in products) {
                ProductComposable(product = product) {

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductSectionPreview() {
    ProductSection("Promoções", productsSample)
}
