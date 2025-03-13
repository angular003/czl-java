package com.czl.api.errors

import com.czl.api.core.http.Headers

class UnauthorizedException(headers: Headers, body: String, error: CzlError) :
    CzlServiceException(401, headers, body, error)
