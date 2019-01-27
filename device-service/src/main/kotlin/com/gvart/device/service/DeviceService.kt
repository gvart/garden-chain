package com.gvart.device.service

import com.gvart.device.domain.Device
import com.gvart.device.exception.NotFoundException
import com.gvart.device.repository.DeviceRepository
import com.gvart.device.extension.toObject
import com.gvart.device.transer.DeviceDto
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class DeviceService (
    private val repository: DeviceRepository
): BasicService<Device, DeviceDto> {
    private val log =  LoggerFactory.getLogger(DeviceService::class.java)

    override fun findAll(): Flux<Device> {
        log.info("Request to find all Devices")
        return repository.findAll()
    }

    override fun findOne(id: String): Mono<Device> {
        log.info("Request to find Device $id")
        return repository.findById(id)
    }

    override fun save(dto: Mono<DeviceDto>): Mono<Device> {
        log.info("Request to save Device")
        return dto.flatMap { repository.save(it.toObject()) }
    }

    override fun update(id: String, dto: Mono<DeviceDto>): Mono<Device> {
        log.info("Request to update Device $id")
        return repository.findById(id)
            .switchIfEmpty(Mono.error { NotFoundException("Device $id not found")})
            .zipWith(dto)
            .flatMap {
                val device = it.t1
                val deviceDto = it.t2
                device.name = deviceDto.name
                device.description = deviceDto.description
                device.hostname = deviceDto.hostname
                repository.save(device)
            }
    }

    override fun delete(id: String): Mono<Void> {
        log.info("Request to delete Device $id")
        return repository.deleteById(id)
    }

}