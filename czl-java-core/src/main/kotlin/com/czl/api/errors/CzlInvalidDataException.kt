package com.czl.api.errors

class CzlInvalidDataException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) : CzlException(message, cause)
