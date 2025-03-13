package com.czl.api.errors

import com.czl.api.core.http.Headers

class NotFoundException(headers: Headers, body: String, error: CzlError) :
    CzlServiceException(404, headers, body, error)
