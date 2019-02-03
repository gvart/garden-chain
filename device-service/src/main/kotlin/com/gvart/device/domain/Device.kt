package com.gvart.device.domain

import com.gvart.device.domain.enum.DeviceStatus
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document
data class Device (
    @Id
    val id: String? = null,
    var name: String,
    val owner: String,
    val registeredAt: LocalDateTime,
    val status: DeviceStatus,
    var description: String,
    var softwareInstalled: Boolean = false,
    var hostname: String,

    @DBRef
    val zones: Set<Zone> = emptySet()
)