package com.sample.compose_bs_android2.mine.solid

import java.io.File

open class FileLogger {

    open fun logError(error: String) {
        val file = File("error.txt")
        file.appendText(text = error)
    }
}

class CustomErrorFileLogger : FileLogger() {
    override fun logError(error: String) {
        val file = File("my_custom_error.txt")
        file.appendText(text = error)
    }

}