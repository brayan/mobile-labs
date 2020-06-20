package br.com.alura.aluraviagens.util

import java.text.SimpleDateFormat
import java.util.*

fun Int.toDatePeriod(): String {
    val departureDate = Calendar.getInstance()
    val returnDate = Calendar.getInstance().apply { add(Calendar.DATE, this@toDatePeriod) }
    val simpleDateFormat = SimpleDateFormat("dd/MM")

    return simpleDateFormat.format(departureDate.time) + " - " +
            simpleDateFormat.format(returnDate.time) + " de " + returnDate.get(Calendar.YEAR)
}