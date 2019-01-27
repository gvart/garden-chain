package com.gvart.device.repository

import com.gvart.device.domain.Device
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface DeviceRepository: ReactiveMongoRepository<Device, String>