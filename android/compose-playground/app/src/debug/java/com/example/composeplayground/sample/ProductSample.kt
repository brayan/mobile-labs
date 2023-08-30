package com.example.composeplayground.sample

import com.example.composeplayground.R
import com.example.composeplayground.domain.model.Product
import java.math.BigDecimal

val productsSample = listOf(
    Product(
        name = "Hamburger",
        price = BigDecimal("22.99"),
        image = R.drawable.burger
    ),
    Product(
        name = "Pizza",
        price = BigDecimal("25.99"),
        image = R.drawable.pizza
    ),
    Product(
        name = "Fries",
        price = BigDecimal("9.99"),
        image = R.drawable.fries
    ),
)
