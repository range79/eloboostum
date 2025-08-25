package com.eloboostum.common.exception

import org.springframework.http.HttpStatus

class TokenException(msg: String) : AbstractExceptionHandler(msg, HttpStatus.UNAUTHORIZED)
{
}