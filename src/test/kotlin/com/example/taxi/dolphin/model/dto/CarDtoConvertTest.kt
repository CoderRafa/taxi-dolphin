package com.example.taxi.dolphin.model.dto

import com.example.taxi.dolphin.model.enumerated.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.LocalDateTime

class CarDtoConvertTest {
    @Test
    fun `Happy pass - convert to entity`() {
        val carDto = CarDto(
            1L,
            "BMW",
            "X5",
            CarColor.GREY,
            CarCategory.BUSINESS,
            "B9908PA"
        )
        carDto.locationDtos = mutableSetOf(
            LocationDto(
            1L,
            145452.3,
            256575.3,
            LocalDateTime.now()
            )
        )
        carDto.driverDto = DriverDto(
            1L,
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
        carDto.driverDto.accountDto = AccountDto(
            1L,
            LocalDate.now(),
            AccountType.BASIC,
            4.0
        )

        carDto.driverDto.accountDto!!.user = carDto.driverDto

        val carEntity = carDto.toEntity()
        assertThat(carEntity).isNotNull
        assertThat(carEntity).hasNoNullFieldsOrProperties()
    }
}