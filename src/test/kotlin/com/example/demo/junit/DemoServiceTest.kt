package com.example.demo.junit

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DemoServiceTest {
    private val demoService: DemoService = DemoService()

    @Test
    fun testAddFunction() {
        assertTrue(demoService.add(1, 2) != 20)
    }

    @Test
    fun testAssertEquals() {
        assertEquals(demoService.add(5, 6), 11)
    }
}
