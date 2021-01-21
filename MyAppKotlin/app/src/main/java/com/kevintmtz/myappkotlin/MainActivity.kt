package com.kevintmtz.myappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val constant1: Int = 2
        val constant2 = 5

        var variable1: String = "Hello!"
        variable1 = "Hello, again!"

        var example = "Variable value: $variable1, ${constant1 * constant2}"

        var nonNullable: String = "I am not null!"
        var nullable: String? = null
        nullable = "I am a nullable"

        if (nullable != null) {
            Toast.makeText(this, "I am not null", Toast.LENGTH_SHORT).show()
        }

        var nullableLength = nullable?.length

        var elvis = nullable?.length ?: "Default"

        var length = nullable!!.length
    }

    fun square(number: Int) : Int {
        return number * number
    }

    fun product(a: Int, b: Int) = a * b

    fun subtraction (a: Int, b: Int = 0) : Int {
        return a - b
    }
}