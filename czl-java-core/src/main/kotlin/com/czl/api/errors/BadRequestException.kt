package com.czl.api.errors

import com.czl.api.core.http.Headers

class BadRequestException(headers: Headers, body: String, error: CzlError) :
    CzlServiceException(400, headers, body, error)
