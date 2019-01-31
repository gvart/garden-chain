package com.gvart.device.transer

import java.time.LocalDateTime

data class OperationResponseDto (
    val success: Boolean,
    val dateTime: LocalDateTime = LocalDateTime.now()
)