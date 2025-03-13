package com.czl.api.errors

import com.czl.api.core.http.Headers

class InternalServerException(statusCode: Int, headers: Headers, body: String, error: CzlError) :
    CzlServiceException(statusCode, headers, body, error)
