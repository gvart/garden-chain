package com.gvart.device.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Zone (
    @Id
    val id: String? = null,
    var name: String,
    var description: String,

    @DBRef
    val device: Device,

    @DBRef
    var components: List<PiComponent> = emptyList()
)