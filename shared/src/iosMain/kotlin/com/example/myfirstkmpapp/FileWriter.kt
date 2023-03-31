package com.example.myfirstkmpapp

import platform.Foundation.*

actual class FileWriter actual constructor(fileName: String, context: Any?) {
    private val fileHandle: NSFileHandle

    init {
        val filePath = NSSearchPathForDirectoriesInDomains(
            NSDocumentDirectory,
            NSUserDomainMask,
            true
        )[0] as String + "/$fileName"
        NSFileManager.defaultManager.createFileAtPath(filePath, null, null)
        fileHandle = NSFileHandle.fileHandleForWritingAtPath(filePath)!!
    }

    actual fun write(text: String) {
        val data = text.toNSData()
        fileHandle.writeData(data)
        fileHandle.closeFile()
    }
}

private fun String.toNSData(): NSData =
    NSString.create(string = this).dataUsingEncoding(NSUTF8StringEncoding)!!
