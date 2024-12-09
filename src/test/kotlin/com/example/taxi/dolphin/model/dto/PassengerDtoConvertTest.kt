package com.example.taxi.dolphin.model.dto

import com.example.taxi.dolphin.model.enumerated.AccountType
import com.example.taxi.dolphin.model.enumerated.SexType
import com.example.taxi.dolphin.model.enumerated.Title
import org.junit.jupiter.api.Test
import java.time.LocalDate
import kotlin.test.assertEquals

class PassengerDtoConvertTest {
    @Test
    fun `Happy pass - convert to entity`() {
        val passengerDto = PassengerDto(
            1,
            "George",
            "Smith",
            25,
            SexType.MALE,
            Title.MR,
            "+37444556677",
            "george@gmail.com",
            "First st., 28",
            "https://avatarlink.com",
            125.5,
            2.5,
            "Good trip",
            "106"
        )

        passengerDto.accountDto = AccountDto(
            1L,
            LocalDate.now(),
            AccountType.BASIC,
            4.0
        )

        passengerDto.accountDto!!.user = passengerDto

        val passengerEntity = passengerDto.toEntity()

        assertEquals(2.5, passengerEntity.averageTip)
        assertEquals(25, passengerEntity.age)
        assertEquals("George", passengerEntity.firstName)
        assertEquals(AccountType.BASIC, passengerEntity.account?.type)
    }
}