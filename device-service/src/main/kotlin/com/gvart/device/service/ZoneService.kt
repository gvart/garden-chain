package com.gvart.device.service


import com.gvart.device.domain.Zone
import com.gvart.device.exception.NotFoundException
import com.gvart.device.extension.toObject
import com.gvart.device.repository.DeviceRepository
import com.gvart.device.repository.ZoneRepository
import com.gvart.device.transer.ZoneDto
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class ZoneService (
    private val repository: ZoneRepository,
    private val deviceRepository: DeviceRepository
) {
    private val log =  LoggerFactory.getLogger(ZoneService::class.java)

    fun findAll(deviceId: String): Flux<Zone> {
        log.info("Request to find all zones")
        return repository.findAllByDeviceId(deviceId)
    }

    fun findOne(deviceId: String, id: String): Mono<Zone> {
        log.info("Request to find zone $id")
        return repository.findOneByDeviceIdAndId(deviceId, id)
            .switchIfEmpty(Mono.error { NotFoundException("Zone $id not found") })
    }

    fun save(deviceId: String, dto: Mono<ZoneDto>): Mono<Zone> {
        log.info("Request to save Zone")
        return deviceRepository.findById(deviceId)
            .switchIfEmpty(Mono.error { NotFoundException("Device $deviceId not found") })
            .flatMap { device -> dto.flatMap {
                val zone = it.toObject(device)
                repository.save(zone)
            } }
    }

    fun update(id: String, zoneId: String, dto: Mono<ZoneDto>): Mono<Zone> {
        log.info("Request to update Zone $zoneId from Device $id")
        return findOne(id, zoneId)
            .zipWith(dto)
            .flatMap {
                val zone = it.t1
                val zoneDto = it.t2
                zone.name = zoneDto.name
                zone.description = zoneDto.description
                repository.save(zone)
            }
    }

    fun delete(id: String, zoneId: String): Mono<Void> {
        log.info("Request to delete zone $id")
        return repository.deleteByDeviceIdAndId(id, zoneId)
    }
}