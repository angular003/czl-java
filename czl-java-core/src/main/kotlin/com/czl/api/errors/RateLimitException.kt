package com.czl.api.errors

import com.czl.api.core.http.Headers

class RateLimitException(headers: Headers, body: String, error: CzlError) :
    CzlServiceException(429, headers, body, error)
