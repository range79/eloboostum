package com.eloboostum.usermanagement.user.exception

import com.eloboostum.common.exception.AbstractExceptionHandler
import org.springframework.http.HttpStatus

class UserNotFoundException(msg: String): AbstractExceptionHandler(msg, HttpStatus.NOT_FOUND) {
}