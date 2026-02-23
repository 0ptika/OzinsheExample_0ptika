package com.example.ozinsheexample

import androidx.fragment.app.Fragment

fun Fragment.provideNavigationHost(): NavigationHostProvider? {
    return activity as? NavigationHostProvider
}
