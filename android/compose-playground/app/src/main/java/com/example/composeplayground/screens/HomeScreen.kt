package com.example.composeplayground.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import com.example.composeplayground.R
import com.example.composeplayground.components.ProductSection
import com.example.composeplayground.domain.model.Product
import com.example.composeplayground.sample.productsSample
import java.math.BigDecimal

@Composable
fun HomeScreen() {
    val title = "Promoções"
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(bottom = 100.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(Modifier)
        ProductSection(title, productsSample)
        ProductSection(title, productsSample)
        ProductSection(title, productsSample)
        Spacer(Modifier)
    }
}

@Preview(
    name = "New Preview",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Preview(
    name = "Text Preview",
    heightDp = 200,
    widthDp = 300,
    showBackground = true
)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

@Preview(showSystemUi = true)
@Composable
fun AppPreview() {
    HomeScreen()
}
