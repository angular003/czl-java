// File generated from our OpenAPI spec by Stainless.

package com.czl.api.errors

import com.czl.api.core.JsonValue
import com.czl.api.core.http.Headers

abstract class CzlServiceException
protected constructor(message: String, cause: Throwable? = null) : CzlException(message, cause) {

    abstract fun statusCode(): Int

    abstract fun headers(): Headers

    abstract fun body(): JsonValue
}
