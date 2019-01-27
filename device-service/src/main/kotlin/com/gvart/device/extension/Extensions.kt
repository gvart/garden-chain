package com.gvart.device.extension

import com.gvart.device.domain.Device
import com.gvart.device.transer.DeviceDto


fun DeviceDto.toObject(): Device {
    return Device(
        name = this.name,
        description = this.description,
        hostname = this.hostname
    )
}