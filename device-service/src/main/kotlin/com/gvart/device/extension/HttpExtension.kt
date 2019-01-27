package com.gvart.device.extension

import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono
import kotlin.reflect.KClass

fun <T: Any> Flux<T>.asJson(status: HttpStatus = HttpStatus.OK, clazz: KClass<T>): Mono<ServerResponse> {
    return ServerResponse
        .status(status)
        .contentType(MediaType.APPLICATION_JSON)
        .body(this, clazz.java).toMono()
}

fun <T: Any> Mono<T>.asJson(status: HttpStatus = HttpStatus.OK, clazz: KClass<T>): Mono<ServerResponse> {
    return ServerResponse
        .status(status)
        .contentType(MediaType.APPLICATION_JSON)
        .body(BodyInserters.fromPublisher(this,  clazz.java))
}

fun <T: Any> Mono<T>.responseStatus(status: HttpStatus): Mono<ServerResponse> {
    return this.flatMap { ServerResponse.status(status).build() }
}