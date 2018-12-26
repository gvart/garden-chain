package com.gvart.auth.domain

import com.gvart.auth.helper.StringJsonConverter
import java.time.LocalDateTime
import javax.persistence.Convert
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "audit")
data class Audit(
    @Id
    val id: Long,
    val type: String,
    val dateTime: LocalDateTime,
    @Convert(converter = StringJsonConverter::class)
    val data: Map<String, Any>
)