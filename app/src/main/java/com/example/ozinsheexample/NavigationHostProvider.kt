package com.example.ozinsheexample

import androidx.transition.Visibility

interface NavigationHostProvider {
    annotation class provideNavigationHost

    fun  setNavigationVisibility(visibility: Boolean)
}