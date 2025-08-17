package com.eloboostum.services.exception

import com.eloboostum.user.exception.AbstractExceptionHandler
import org.springframework.http.HttpStatus

class ServiceNotFoundException(msg: String): AbstractExceptionHandler( msg,HttpStatus.NOT_FOUND) {
}