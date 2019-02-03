package com.gvart.device.domain.enum

import com.fasterxml.jackson.annotation.JsonProperty

enum class DeviceStatus {

    /**
     * If device don't sent heart-beats
     * */
    @JsonProperty("INACTIVE")
    INACTIVE,

    /**
     * If device send heart-beats
     * */
    @JsonProperty("ACTIVE")
    ACTIVE,

    /**
     * If administrator disable that device
     * */
    @JsonProperty("DISABLED")
    DISABLED,

    /**
     * If PIDevice do some work.
     * */
    @JsonProperty("WORKING")
    WORKING;
}