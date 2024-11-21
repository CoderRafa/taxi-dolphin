package com.example.taxi.dolphin.model.entity

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DriverEntityTest {
    @Test
    fun `Happy pass - account entity add driver`() {
        val driverEntity = DriverEntity()
        val accountEntity = AccountEntity()
        accountEntity.user = driverEntity
    }
}