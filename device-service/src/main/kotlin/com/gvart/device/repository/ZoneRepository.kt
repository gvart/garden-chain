package com.gvart.device.repository

import com.gvart.device.domain.Zone
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface ZoneRepository: ReactiveMongoRepository<Zone, String>