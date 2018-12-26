package com.gvart.auth

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class ConfigServerApplication

fun main(args: Array<String>) {
    runApplication<ConfigServerApplication>(*args)
}
