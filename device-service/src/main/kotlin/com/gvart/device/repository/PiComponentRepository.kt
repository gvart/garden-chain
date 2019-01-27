package com.gvart.device.repository

import com.gvart.device.domain.PiComponent
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface PiComponentRepository: ReactiveMongoRepository<PiComponent, String>