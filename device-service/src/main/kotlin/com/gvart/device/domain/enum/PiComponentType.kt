package com.gvart.device.domain.enum

import com.fasterxml.jackson.annotation.JsonProperty

enum class PiComponentType {
    @JsonProperty("SOIL_HUMIDITY_SENSOR")
    SOIL_HUMIDITY_SENSOR,
    @JsonProperty("AIR_HUMIDITY_SENSOR")
    AIR_HUMIDITY_SENSOR,
    @JsonProperty("AIR_TEMPERATURE_SENSOR")
    AIR_TEMPERATURE_SENSOR;

    //todo add more type of pi-components
}