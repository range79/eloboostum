package com.eloboostum.common.exception

import com.eloboostum.common.exception.AbstractExceptionHandler
import org.springframework.http.HttpStatus

class RoleMismatchException(msg: String): AbstractExceptionHandler(msg, HttpStatus.BAD_REQUEST) {
}