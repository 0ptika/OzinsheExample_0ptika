@file:Suppress("DEPRECATION")

package com.example.ozinsheexample

import android.app.Fragment


fun Fragment.provideNavigationHost(): NavigationHostProvider? {
    return try {
        activity as NavigationHostProvider
    } catch (e: Exception) {
        null
    }
}