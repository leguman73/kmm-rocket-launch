package com.example.myfirstkmpapp

import android.content.Context
import java.io.File
import java.io.FileOutputStream

actual class FileWriter actual constructor(private val fileName: String, private val context: Any?) {
    actual fun write(text: String) {
        val file = File((context as Context).filesDir, fileName)
        return file.writeText(text)
    }
}
