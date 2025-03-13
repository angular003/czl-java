package com.czl.api.errors

import com.czl.api.core.http.Headers

class UnprocessableEntityException(headers: Headers, body: String, error: CzlError) :
    CzlServiceException(422, headers, body, error)
