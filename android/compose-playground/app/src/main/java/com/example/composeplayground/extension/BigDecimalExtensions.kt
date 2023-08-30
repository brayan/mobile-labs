package com.example.composeplayground.extension

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

fun BigDecimal.toBrazilianCurrency(): String {
    val locale = Locale("pt", "br")
    val format = NumberFormat.getCurrencyInstance(locale)
    return format.format(this)
}
