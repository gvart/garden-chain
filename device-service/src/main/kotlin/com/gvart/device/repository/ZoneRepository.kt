package com.gvart.device.repository

import com.gvart.device.domain.Zone
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface ZoneRepository: ReactiveMongoRepository<Zone, String> {
    fun findAllByDeviceId(deviceId: String): Flux<Zone>
    fun findOneByDeviceIdAndId(deviceId: String, id: String): Mono<Zone>
    fun deleteByDeviceIdAndId(deviceId: String, id: String): Mono<Void>
}