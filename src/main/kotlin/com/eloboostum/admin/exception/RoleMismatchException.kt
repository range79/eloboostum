package com.eloboostum.admin.exception

import com.eloboostum.user.exception.AbstractExceptionHandler
import org.springframework.http.HttpStatus

class RoleMismatchException(msg: String): AbstractExceptionHandler(msg, HttpStatus.BAD_REQUEST) {
}