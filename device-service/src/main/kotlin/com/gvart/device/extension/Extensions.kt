package com.gvart.device.extension

import com.gvart.device.domain.Device
import com.gvart.device.domain.Zone
import com.gvart.device.domain.enum.DeviceStatus
import com.gvart.device.transer.DeviceDto
import com.gvart.device.transer.ZoneDto
import java.time.LocalDateTime


fun DeviceDto.toObject(): Device {
    return Device(
        name = this.name,
        description = this.description,
        registeredAt = LocalDateTime.now(),
        owner = this.owner,
        status = DeviceStatus.INACTIVE,
        hostname = this.hostname
    )
}

fun ZoneDto.toObject(device: Device): Zone {
    return Zone(
        name = this.name,
        description = this.description,
        device = device
    )
}