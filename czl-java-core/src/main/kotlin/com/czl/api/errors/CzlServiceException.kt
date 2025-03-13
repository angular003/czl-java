package com.czl.api.errors

import com.czl.api.core.http.Headers

abstract class CzlServiceException
@JvmOverloads
constructor(
    private val statusCode: Int,
    private val headers: Headers,
    private val body: String,
    private val error: CzlError,
    message: String = "$statusCode: $error",
    cause: Throwable? = null,
) : CzlException(message, cause) {

    fun statusCode(): Int = statusCode

    fun headers(): Headers = headers

    fun body(): String = body

    fun error(): CzlError = error
}
