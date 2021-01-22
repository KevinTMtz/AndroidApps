package com.kevintmtz.myappkotlin

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    val PHOTO_CAPTURE = 1
    lateinit var imageView : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)


        // Kotlin basics
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

        val dog = Dog("Firulais", 20.0f)
        dog.name = "Juanin"
        Toast.makeText(this, "Dog's name: ${dog.name}", Toast.LENGTH_SHORT).show()
    }

    fun takePhoto(view: View) {
        var i = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        if (i.resolveActivity(packageManager) == null)
            return

        startActivityForResult(i, PHOTO_CAPTURE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PHOTO_CAPTURE && resultCode == Activity.RESULT_OK) {
            val image = data?.extras?.get("data") as Bitmap

            imageView.setImageBitmap(image)
        }
    }

    fun square(number: Int) : Int {
        return number * number
    }

    fun product(a: Int, b: Int) = a * b

    fun subtraction (a: Int, b: Int = 0) : Int {
        return a - b
    }
}