package com.czl.api.errors

import com.czl.api.core.http.Headers

class PermissionDeniedException(headers: Headers, body: String, error: CzlError) :
    CzlServiceException(403, headers, body, error)
