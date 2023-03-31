package com.example.myfirstkmpapp

expect class FileWriter(fileName: String, context: Any?) {
    fun write(text: String)
}