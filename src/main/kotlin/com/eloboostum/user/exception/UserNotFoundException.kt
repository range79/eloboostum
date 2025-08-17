package com.eloboostum.user.exception

import org.springframework.http.HttpStatus

class UserNotFoundException(msg: String): AbstractExceptionHandler(msg, HttpStatus.NOT_FOUND) {
}