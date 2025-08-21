package com.eloboostum.error.exception

import com.eloboostum.common.exception.AbstractExceptionHandler
import org.springframework.http.HttpStatus

class ErrorNotFoundException (msg: String) : AbstractExceptionHandler(msg, HttpStatus.NOT_FOUND) {}