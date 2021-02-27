package com.example.androiddevchallenge.helpers

import com.example.androiddevchallenge.R

class CatHelper {
    fun getCatImage(catName: String): Int {
        when (catName) {
            "brady" -> return R.drawable.brady
            "Teddy" -> return R.drawable.teddy
            "Truffles" -> return R.drawable.truffles
            "Kasha" -> return R.drawable.kasha
            "Shady lady" -> return R.drawable.shadylady
            "Jubal" -> return R.drawable.jubal
            "Gabby" -> return R.drawable.gabby
            "Chancy" -> return R.drawable.chancy
            "Chancelor" -> return R.drawable.chancelor
            "T'Challa" -> return R.drawable.tchalla

            else -> {
                return R.drawable.notfound
            }
        }
    }
}