package com.gvart.device.handler

import com.gvart.device.domain.Zone
import com.gvart.device.extension.asJson
import com.gvart.device.extension.responseStatus
import com.gvart.device.service.ZoneService
import com.gvart.device.transer.ZoneDto
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class ZoneHandler(
    private val zoneService: ZoneService
): BasicHandler {
    override fun findAll(serverRequest: ServerRequest): Mono<ServerResponse> {
        val id = serverRequest.pathVariable("id")
        return zoneService.findAll(id).asJson(clazz = Zone::class)
    }

    override fun findOne(serverRequest: ServerRequest): Mono<ServerResponse> {
        val id = serverRequest.pathVariable("id")
        val zoneId = serverRequest.pathVariable("zoneId")
        return  zoneService.findOne(id, zoneId).asJson(clazz = Zone::class)
    }

    override fun save(serverRequest: ServerRequest): Mono<ServerResponse> {
        val id = serverRequest.pathVariable("id")
        val body = serverRequest.bodyToMono(ZoneDto::class.java)
        return zoneService.save(id, body).asJson(HttpStatus.CREATED, Zone::class)
    }

    override fun update(serverRequest: ServerRequest): Mono<ServerResponse> {
        val id = serverRequest.pathVariable("id")
        val zoneId = serverRequest.pathVariable("zoneId")
        val body = serverRequest.bodyToMono(ZoneDto::class.java)
        return zoneService.update(id, zoneId, body).asJson(HttpStatus.CREATED, Zone::class)
    }

    override fun delete(serverRequest: ServerRequest): Mono<ServerResponse> {
        val id = serverRequest.pathVariable("id")
        val zoneId = serverRequest.pathVariable("zoneId")
        return zoneService.delete(id, zoneId).responseStatus(HttpStatus.NO_CONTENT)
    }
}