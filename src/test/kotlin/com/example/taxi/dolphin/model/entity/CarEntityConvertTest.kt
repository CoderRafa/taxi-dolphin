package com.example.taxi.dolphin.model.entity

import com.example.taxi.dolphin.model.enumerated.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.LocalDateTime

class CarEntityConvertTest {
    @Test
    fun `Happy pass - covert entity to dto`() {
        val carEntity = CarEntity().apply {
            this.id = 1L
            this.make = "BMW"
            this.model = "X5"
            this.color = CarColor.GREY
            this.category = CarCategory.BUSINESS
            this.licencePlateNumber = "B9908PA"
        }
        carEntity.locationEntities = mutableSetOf(
            LocationEntity().apply {
                this.id = 1L
                this.longitude = 145452.3
                this.latitude = 256575.3
                this.time = LocalDateTime.now()
            }
        )
        carEntity.driverEntity = DriverEntity().apply {
            this.id = 1L
            this.firstName = "Andrei"
            this.lastName = "Sokolov"
            this.age = 27
            this.sex = SexType.MALE
            this.title = Title.MR
            this.phoneNumber = "+359888765432"
            this.email = "andrei@gmail.com"
            this.address = "First st. 1"
            this.avatarLink = "https://www.link.com"
        }

        carEntity.driverEntity.account = AccountEntity().apply {
            this.id = 1L
            this.registrationDate = LocalDate.now()
            this.type = AccountType.BASIC
            this.rating = 4.0
        }

        carEntity.driverEntity.account!!.user = carEntity.driverEntity

        val carDto = carEntity.toDto()
        assertThat(carDto).isNotNull
        assertThat(carDto).hasNoNullFieldsOrProperties()
    }
}