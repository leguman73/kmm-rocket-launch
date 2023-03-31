package com.example.myfirstkmpapp

expect class FileReader(fileName: String, context: Any?) {
    fun read(): String
}