package com.eloboostum.user.exception

import org.springframework.http.HttpStatus

class AuthenticationException(msg: String): AbstractExceptionHandler(msg, HttpStatus.BAD_REQUEST) {
}