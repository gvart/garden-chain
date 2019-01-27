package com.gvart.device.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Zone (
    @Id
    val id: String,
    val name: String,
    val description: String,

    @DBRef
    var device: List<Device>
)