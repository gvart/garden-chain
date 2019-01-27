package com.gvart.device.service

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface BasicService<T, DTO> {
    fun findAll(): Flux<T>
    fun findOne(id: String): Mono<T>
    fun save(dto: Mono<DTO>): Mono<T>
    fun update(id: String, dto: Mono<DTO>): Mono<T>
    fun delete(id: String): Mono<Void>
}