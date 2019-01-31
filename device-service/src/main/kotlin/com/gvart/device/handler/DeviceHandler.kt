package com.gvart.device.handler

import com.gvart.device.domain.Device
import com.gvart.device.extension.asJson
import com.gvart.device.extension.responseStatus
import com.gvart.device.service.DeviceService
import com.gvart.device.transer.DeviceDto
import com.gvart.device.transer.OperationResponseDto
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class DeviceHandler(
    private val deviceService: DeviceService
): BasicHandler {
    override fun findAll(serverRequest: ServerRequest) =
        deviceService.findAll().asJson(clazz = Device::class)

    override fun findOne(serverRequest: ServerRequest): Mono<ServerResponse> {
        val id = serverRequest.pathVariable("id")
        return deviceService.findOne(id).asJson(clazz = Device::class)
    }

    override fun save(serverRequest: ServerRequest): Mono<ServerResponse> {
        val body = serverRequest.bodyToMono(DeviceDto::class.java)
        return deviceService.save(body).asJson(HttpStatus.CREATED, Device::class)
    }

    override fun update(serverRequest: ServerRequest): Mono<ServerResponse> {
        val id = serverRequest.pathVariable("id")
        val body = serverRequest.bodyToMono(DeviceDto::class.java)
        return deviceService.update(id, body).asJson(HttpStatus.CREATED, Device::class)
    }

    override fun delete(serverRequest: ServerRequest): Mono<ServerResponse> {
        val id = serverRequest.pathVariable("id")
        return deviceService.delete(id).responseStatus(HttpStatus.NO_CONTENT)
    }

    fun installSoftware(serverRequest: ServerRequest): Mono<ServerResponse> {
        val id = serverRequest.pathVariable("id")
        return deviceService.installSoftware(id).asJson(clazz = OperationResponseDto::class)
    }
}