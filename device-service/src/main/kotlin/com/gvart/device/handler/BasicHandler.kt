package com.gvart.device.handler

import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

interface BasicHandler {
    fun findAll(serverRequest: ServerRequest): Mono<ServerResponse>
    fun findOne(serverRequest: ServerRequest): Mono<ServerResponse>
    fun save(serverRequest: ServerRequest): Mono<ServerResponse>
    fun update(serverRequest: ServerRequest): Mono<ServerResponse>
    fun delete(serverRequest: ServerRequest): Mono<ServerResponse>
}