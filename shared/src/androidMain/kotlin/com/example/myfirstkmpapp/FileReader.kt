package com.example.myfirstkmpapp

import android.content.Context
import java.io.File

actual class FileReader actual constructor(private val fileName: String, private val context: Any?) {

    actual fun read(): String {
        val file =  File((context as Context).filesDir, fileName)
        return file.readText()
    }
}