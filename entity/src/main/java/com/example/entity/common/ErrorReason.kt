package com.example.entity.common


import java.io.Serializable

sealed class ErrorReason : Serializable {

    object Unknown : ErrorReason()

    data class UseCaseException(val exception: Throwable) : ErrorReason()

    sealed class Api : ErrorReason() {
        object NoConnection : Api()
        sealed class ErrorResponse : Api() {
            object NotFound : ErrorResponse()
            object Other : ErrorResponse()
        }

        object Other : Api()
    }
}