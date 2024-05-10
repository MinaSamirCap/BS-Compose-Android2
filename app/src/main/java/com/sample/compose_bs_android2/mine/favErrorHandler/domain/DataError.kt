package com.sample.compose_bs_android2.mine.favErrorHandler.domain

sealed interface DataError : Error {

    enum class Network: DataError{
        REQUEST_TIMEOUT,
        TOO_MANY_REQUESTS,
        NO_INTERNET,
        PAYLOAD_TOO_LARGE,
        SERVER_ERROR,
        SERIALIZATION_ERROR,
        UNKNOWN_ERROR
    }

    enum class Local: DataError{
        DISK_FULL,
    }
}