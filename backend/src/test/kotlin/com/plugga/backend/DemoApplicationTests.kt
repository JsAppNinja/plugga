package com.plugga.backend

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension


@ExtendWith(SpringExtension::class)
@SpringBootTest
class DemoApplicationTests {

    @Test
    fun contextLoads() {
    }

    @Test
    fun testJunit() {
        assertTrue(true)
    }
}