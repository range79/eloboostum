package com.eloboostum.boostOrders.exception

import com.eloboostum.user.exception.AbstractExceptionHandler
import org.springframework.http.HttpStatus

class BoostAuthorException(msg: String): AbstractExceptionHandler(msg, HttpStatus.BAD_REQUEST) {
}