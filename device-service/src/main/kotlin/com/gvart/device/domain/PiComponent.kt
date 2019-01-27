package com.gvart.device.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class PiComponent (
    @Id
    val id: String,
    val name: String,
    val description: String,
    val gpio: Int,
    val data: Any //todo decide type of incoming data.
)