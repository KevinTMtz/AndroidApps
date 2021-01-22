package com.kevintmtz.myappkotlin

import android.util.Log

// class Dog (var name: String, var weight: Float)

open class Dog (var name: String, var weight: Float) {

    var favoriteFood: String
    private set

    init {
        Log.i("Init message: ", name)

        favoriteFood = "Meat"
    }

    constructor(name: String) : this(name, 10.0f)

    constructor(weight: Float) : this("Juanin", weight) {
        Log.i("Secondary constructor message: ", "Hello!")
    }

    fun bark() {
        Log.i("Dog's message: ", "Guau!")
    }
}
