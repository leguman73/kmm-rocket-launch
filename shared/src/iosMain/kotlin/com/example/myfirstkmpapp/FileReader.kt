package com.example.myfirstkmpapp

import platform.Foundation.*

actual class FileReader actual constructor(private val fileName: String, context: Any?) {
    actual fun read(): String {
        val filePath = NSSearchPathForDirectoriesInDomains(
            NSDocumentDirectory,
            NSUserDomainMask,
            true
        )[0] as String + "/$fileName"
        val url = NSURL.fileURLWithPath(filePath)
        val contents = NSString.stringWithContentsOfURL(url, encoding = NSUTF8StringEncoding, error = null)

        return contents ?: ""
    }
}