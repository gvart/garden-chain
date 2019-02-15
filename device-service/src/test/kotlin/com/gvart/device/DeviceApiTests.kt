package com.gvart.device

import com.gvart.device.domain.Device
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBodyList
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
@EnableReactiveMongoRepositories
@ExtendWith(SpringExtension::class)
@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    properties = [
        "spring.cloud.config.enabled:false",
        "eureka.client.enabled:false"
    ]
)
class DeviceApiTests {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @Test
    fun getAllDevices() {
        webTestClient.get().uri("/api/v1/device")
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isOk
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectBodyList<Device>().hasSize(0)
    }
}