package com.example.taxi.dolphin.model.entity

import com.example.taxi.dolphin.model.enumerated.AccountType
import com.example.taxi.dolphin.model.enumerated.SexType
import com.example.taxi.dolphin.model.enumerated.Title
import org.junit.jupiter.api.Test
import java.time.LocalDate
import kotlin.test.assertEquals

class DriverEntityConvertTest {
    @Test
    fun `Happy pass - account entity add driver`() {
        val driverEntity = DriverEntity().apply {
            this.id = 1
            this.firstName = "George"
            this.lastName = "Smith"
            this.age = 25
            this.sex = SexType.MALE
            this.title = Title.MR
            this.phoneNumber = "+37444556677"
            this.email = "george@gmail.com"
            this.address = "First st., 28"
            this.avatarLink = "https://avatarlink.com"
            this.experience = 5
            this.averageMonthlyNumberOfPassengers = 7.4
            this.lastMonthWorkHours = 120.5
        }

        driverEntity.account = AccountEntity().apply {
                this.id = 1L
                this.registrationDate = LocalDate.now()
                this.type = AccountType.BASIC
                this.rating = 4.0
            }

        driverEntity.account!!.user = driverEntity

        val driverDto = driverEntity.toDto()

        assertEquals(25, driverDto.age)
        assertEquals("george@gmail.com", driverDto.email)
        assertEquals("https://avatarlink.com", driverDto.avatarLink)
        assertEquals(120.5, driverDto.lastMonthWorkHours)
    }
}