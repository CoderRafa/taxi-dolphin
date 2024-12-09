package com.example.taxi.dolphin.model.dto

import com.example.taxi.dolphin.model.enumerated.AccountType
import com.example.taxi.dolphin.model.enumerated.SexType
import com.example.taxi.dolphin.model.enumerated.Title
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDate

class DriverDtoConvertTest {
    @Test
    fun `Happy pass - successfully convert dto to entity`() {
        val driverDto = DriverDto(
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
            5,
            7.4,
            120.5
        )

        driverDto.accountDto = AccountDto(
            1L,
            LocalDate.now(),
            AccountType.BASIC,
            4.0
        )

        driverDto.accountDto!!.user = driverDto

        val driverEntity = driverDto.toEntity()

//        assertThat(driverEntity.phoneNumber).isEqualTo("+37444556677")
//        assertThat(driverEntity.age).isEqualTo(25)
//        assertThat(driverEntity.averageMonthlyNumberOfPassengers).isEqualTo(7.4)
//        assertThat(driverEntity.account?.type).isEqualTo(AccountType.BASIC)
        assertThat(driverEntity.account?.user?.firstName).isEqualTo("Georg")
    }
}

