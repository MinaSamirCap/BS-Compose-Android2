package com.sample.compose_bs_android2.mine.solid

interface Authenticator {

    suspend fun signInWithEmailAndPassword(email: String, password: String)
}

class FirebaseAuthenticator : Authenticator {
    override suspend fun signInWithEmailAndPassword(email: String, password: String) {
        // Firebase.getInstance().signInWithEmailAndPassword(email, password)
    }
}

class GoogleAuthenticator : Authenticator {
    override suspend fun signInWithEmailAndPassword(email: String, password: String) {
        // Firebase.getInstance().signInWithGoogle(email, password)
    }
}

class ApiAuthenticator : Authenticator {
    override suspend fun signInWithEmailAndPassword(email: String, password: String) {
        // Retrofit.getInstance().signInWithEmailAndPassword(email, password)
    }
}