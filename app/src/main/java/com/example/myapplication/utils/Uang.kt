package com.example.myapplication.utils

import java.text.NumberFormat
import java.util.Locale

object Uang {
    fun indonesia(uang:Double):String
    {
        val localeId = Locale("in","ID")
        val kursId:NumberFormat = NumberFormat.getCurrencyInstance(localeId)

        return kursId.format(uang)

    }
}