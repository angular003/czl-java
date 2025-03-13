package com.czl.api.errors

class CzlIoException @JvmOverloads constructor(message: String? = null, cause: Throwable? = null) :
    CzlException(message, cause)
