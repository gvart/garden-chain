package com.gvart.device.config

import com.gvart.device.handler.DeviceHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.router

@Configuration
class RouterConfig(
    val deviceHandler: DeviceHandler
) {

    @Bean
    fun routes() = router {
        "/api/v1".nest {
            "/device".nest {
                GET("", deviceHandler::findAll)
                GET("/{id}", deviceHandler::findOne)
                POST("", deviceHandler::save)
                PUT("/{id}", deviceHandler::update)
                DELETE("/{id}", deviceHandler::delete)
            }
        }
    }
}