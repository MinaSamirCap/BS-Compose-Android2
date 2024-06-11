package com.sample.compose_bs_android2.mine.solid

class MainRepository(
    private val authenticator: Authenticator,
    private val fileLogger: FileLogger
) {


    suspend fun loginUser(email: String, password: String) {
        try {
            // I do not care the authentication way here
            // if it Firebase, Google, or Api
            authenticator.signInWithEmailAndPassword(email, password)
        } catch (e: Exception) {
            fileLogger.logError(e.message.toString())
        }
    }
}