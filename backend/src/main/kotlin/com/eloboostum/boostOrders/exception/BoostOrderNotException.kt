package com.eloboostum.boostOrders.exception

import com.eloboostum.common.exception.AbstractExceptionHandler
import org.springframework.http.HttpStatus

class BoostOrderNotException(msg: String): AbstractExceptionHandler(msg, HttpStatus.BAD_REQUEST)