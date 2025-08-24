package com.eloboostum.common.model

import javax.lang.model.type.ErrorType

data class ErrorResponse(
    val status: Int,
    val message: String,
    val timestamp: String,
    val path: String,
    val errorType: ErrorType,
)

