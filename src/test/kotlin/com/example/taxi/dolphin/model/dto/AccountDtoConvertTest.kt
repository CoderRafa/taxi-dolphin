package com.example.taxi.dolphin.model.dto

import com.example.taxi.dolphin.model.enumerated.AccountType
import com.example.taxi.dolphin.model.enumerated.SexType
import com.example.taxi.dolphin.model.enumerated.Title
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import java.time.LocalDate

@ExtendWith(MockitoExtension::class)
class AccountDtoConvertTest {

    @Test
    fun `Happy pass - success conversion a dto to the entity`() {
        val accountDto = AccountDto(
            1,
            LocalDate.now(),
            AccountType.GOLD,
            5.0
        )
        accountDto.user = UserDto(
            1,
            "Andrei",
            "Sokolov",
            27,
            SexType.MALE,
            Title.MR,
            "+359888765432",
            "andrei@gmail.com",
            "First st. 1",
            "https://www.link.com"
        )
        val accountEntity = accountDto.toEntity()
        assertThat(accountEntity).isNotNull
        assertThat(accountEntity).hasNoNullFieldsOrProperties()
    }
}