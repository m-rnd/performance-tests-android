package com.example.finews.datasource.api

import com.example.entity.AppResult
import com.example.entity.common.ErrorReason
import com.example.entity.common.TraceSection
import com.example.traceutil.traceAsync
import retrofit2.Response
import timber.log.Timber
import java.net.ConnectException
import java.net.UnknownHostException

suspend fun <ApiModel, EntityModel> callApi(
    call: suspend () -> Response<ApiModel>,
    mapper: (ApiModel) -> EntityModel,
): AppResult<EntityModel> {
    return traceAsync(TraceSection.NATIVE_API_CALL.traceName) {
        try {
            val response = call()
            when {
                response.isSuccessful -> AppResult.Success(response.body()!!).mapSuccess(mapper)
                else -> {
                    Timber.e("API returned error code: ${response.code()}")
                    AppResult.Error(
                        when (response.code()) {
                            404 -> ErrorReason.Api.ErrorResponse.NotFound
                            else -> ErrorReason.Api.ErrorResponse.Other
                        }
                    )
                }
            }
        } catch (e: Exception) {
            val reason = when (e) {
                is UnknownHostException,
                is ConnectException -> ErrorReason.Api.NoConnection

                else -> ErrorReason.Api.Other
            }

            e.message?.let {
                Timber.e("exception in API: ${e.message ?: "unknown"}")
            }

            AppResult.Error(reason)
        }
    }
}