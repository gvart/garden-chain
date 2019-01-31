package com.gvart.device.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Device (
    @Id
    val id: String? = null,
    var name: String,
    var description: String,
    var softwareInstalled: Boolean = false,
    var hostname: String,

    @DBRef
    val zones: Set<Zone> = emptySet()
)