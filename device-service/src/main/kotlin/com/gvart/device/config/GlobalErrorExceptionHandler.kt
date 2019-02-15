package com.gvart.device.config

import com.gvart.device.exception.NotFoundException
import org.springframework.boot.autoconfigure.web.ResourceProperties
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes
import org.springframework.boot.web.reactive.error.ErrorAttributes
import org.springframework.context.ApplicationContext
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.codec.ServerCodecConfigurer
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.*
import org.springframework.web.server.ResponseStatusException
import reactor.core.publisher.Mono

/***
 * Error handler and map them to htpp status code
 * */
@Component
@Order(-2)
class GlobalErrorWebExceptionHandler(
    applicationContext: ApplicationContext,
    serverCodecConfigurer: ServerCodecConfigurer
): AbstractErrorWebExceptionHandler(DefaultErrorAttributes(), ResourceProperties(), applicationContext) {
    init {
        super.setMessageWriters(serverCodecConfigurer.writers)
        super.setMessageReaders(serverCodecConfigurer.readers)
    }
    override fun getRoutingFunction(errorAttributes: ErrorAttributes?): RouterFunction<ServerResponse> {
        return RouterFunctions.route(RequestPredicates.all(), HandlerFunction { readerErrorResponse(it) })

    }

    fun readerErrorResponse(request: ServerRequest): Mono<ServerResponse> {
        val statusCode  = when(getError(request)) {
            is NotFoundException -> HttpStatus.NOT_FOUND
            is ResponseStatusException -> {
                (getError(request) as ResponseStatusException).status
            }
            else -> HttpStatus.INTERNAL_SERVER_ERROR
        }

        val errorAttributes = getErrorAttributes(request, true)
        errorAttributes["status"] = statusCode.value()
        errorAttributes["error"] = statusCode.reasonPhrase

        return ServerResponse.status(statusCode)
            .contentType(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromObject(errorAttributes))
    }
}
