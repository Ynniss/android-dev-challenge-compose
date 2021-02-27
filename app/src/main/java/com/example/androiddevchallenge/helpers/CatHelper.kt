/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.helpers

import com.example.androiddevchallenge.R

object CatHelper {
    fun getCatImage(catName: String): Int {
        when (catName) {
            "Brady" -> return R.drawable.brady
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
