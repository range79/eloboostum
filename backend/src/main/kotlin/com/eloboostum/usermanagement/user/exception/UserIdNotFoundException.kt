package com.eloboostum.usermanagement.user.exception

import com.eloboostum.common.exception.AbstractExceptionHandler
import org.springframework.http.HttpStatus

class UserIdNotFoundException (msg: String): AbstractExceptionHandler(msg, HttpStatus.NOT_FOUND)