package com.gvart.device.config

import com.gvart.device.handler.DeviceHandler
import com.gvart.device.handler.ZoneHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.router

@Configuration
class RouterConfig(
    val deviceHandler: DeviceHandler,
    val zoneHandler: ZoneHandler
) {

    @Bean
    fun routes() = router {
        "/api/v1".nest {
            "/device".nest {
                GET("", deviceHandler::findAll)
                GET("/{id}", deviceHandler::findOne)
                GET("/{id}/install", deviceHandler::installSoftware)
                POST("", deviceHandler::save)
                PUT("/{id}", deviceHandler::update)
                DELETE("/{id}", deviceHandler::delete)
                "/{id}/zone".nest {
                    GET("", zoneHandler::findAll)
                    GET("/{zoneId}", zoneHandler::findOne)
                    POST("", zoneHandler::save)
                    PUT("/{zoneId}", zoneHandler::update)
                    DELETE("/{zoneId}", zoneHandler::delete)
                }
            }
        }
    }
}