package com.example.woof

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Dog(
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    val age: Int,
               @StringRes val hobbies: Int)
val dogs = listOf(
    Dog(R.drawable.image1, R.string.country_name_1, 2, R.string.country_description_1),
    Dog(R.drawable.image2, R.string.country_name_2, 16, R.string.country_description_2),
    Dog(R.drawable.image3, R.string.country_name_3, 2, R.string.country_description_3),
    Dog(R.drawable.image4, R.string.country_name_4, 8, R.string.country_description_4),
    Dog(R.drawable.image5, R.string.country_name_5, 8, R.string.country_description_5),
    Dog(R.drawable.image6, R.string.country_name_6, 14, R.string.country_description_6),
    Dog(R.drawable.image7, R.string.country_name_7, 2, R.string.country_description_7),
    Dog(R.drawable.image8, R.string.country_name_8, 7, R.string.country_description_8),
    Dog(R.drawable.image9, R.string.country_name_9, 4, R.string.country_description_9)
)
