package com.example.ozinsheexample.data

import androidx.annotation.DrawableRes

data class OnbourdingModel(
    @DrawableRes val imageId: Int,
    val description: String,
    val title: String = "ÖZINŞE-ге қош келдің!"
)
