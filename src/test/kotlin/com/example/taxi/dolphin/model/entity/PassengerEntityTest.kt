package com.example.taxi.dolphin.model.entity

import com.example.taxi.dolphin.model.enumerated.AccountType
import com.example.taxi.dolphin.model.enumerated.SexType
import com.example.taxi.dolphin.model.enumerated.Title
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDate

class PassengerEntityTest {
    @Test
    fun `Happy pass - convert to dto`() {
        val passengerEntity = PassengerEntity().apply {
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
            this.miles = 120.5
            this.averageTip = 4.0
            this.generalComment = "Good trip"
            this.favoriteRadioStation = "105.5"
        }

        passengerEntity.account = AccountEntity().apply {
            this.id = 1L
            this.registrationDate = LocalDate.now()
            this.type = AccountType.BASIC
            this.rating = 4.0
        }

        passengerEntity.account!!.user = passengerEntity

        val passengerDto = passengerEntity.toDto()

        assertEquals(120.5, passengerDto.miles)
        assertEquals("Good trip", passengerDto.generalComment)
        assertEquals(4.0, passengerDto.averageTip)

    }
}