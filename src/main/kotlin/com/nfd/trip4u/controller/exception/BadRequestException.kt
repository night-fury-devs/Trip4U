package com.nfd.trip4u.controller.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

/**
 * Author: Mary Kuchumova
 * Date: 23 June 2016
 * Time: 15:28
 */

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
open class BadRequestException(
        override var message: String? = null,
        override var cause: Throwable? = null) : HttpErrorException(message, cause) {
}