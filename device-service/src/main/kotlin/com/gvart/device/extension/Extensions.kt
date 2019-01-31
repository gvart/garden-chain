package com.gvart.device.extension

import com.gvart.device.domain.Device
import com.gvart.device.domain.Zone
import com.gvart.device.transer.DeviceDto
import com.gvart.device.transer.ZoneDto


fun DeviceDto.toObject(): Device {
    return Device(
        name = this.name,
        description = this.description,
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