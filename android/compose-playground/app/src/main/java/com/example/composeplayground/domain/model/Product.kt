package com.example.composeplayground.domain.model

import java.math.BigDecimal

data class Product(
    val name: String,
    val price: BigDecimal,
    val image: Int,
)
