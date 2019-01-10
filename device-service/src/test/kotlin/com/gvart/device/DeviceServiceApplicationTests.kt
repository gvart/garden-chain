package com.gvart.device

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension


@ActiveProfiles("test")
@SpringBootTest
@ExtendWith(SpringExtension::class)
class DeviceServiceApplicationTests {

    @Test
    fun contextLoads() {}
}