package com.example.taxi.dolphin.model.dto

import com.example.taxi.dolphin.exception.PropertyShouldBeNotNullException
import com.example.taxi.dolphin.model.entity.*
import com.example.taxi.dolphin.model.enumerated.SexType
import com.example.taxi.dolphin.model.enumerated.Title
import java.lang.RuntimeException

/**
 * DTO for {@link com.example.taxi.dolphin.model.entity.DriverEntity}
 */
class DriverDto(
    id: Long? = null,
    firstName: String,
    lastName: String,
    age: Int,
    sex: SexType,
    title: Title,
    phoneNumber: String,
    email: String,
    address: String,
    avatarLink: String,
    val experience: Int? = null,
    val averageMonthlyNumberOfPassengers: Double? = null,
    val lastMonthWorkHours: Double? = null
) : UserDto(id, firstName, lastName, age, sex, title, phoneNumber, email, address, avatarLink) {
    var trips: MutableSet<TripDto> = mutableSetOf()
    var cars: MutableSet<CarDto> = mutableSetOf()
    var combinedRatingDto: CombinedRatingDto? = null
}

fun DriverDto.toEntity(
    cars: MutableSet<CarEntity>? = null,
    ): DriverEntity = DriverEntity().apply {
    this.id = this@toEntity.id
    this.firstName = this@toEntity.firstName
    this.lastName = this@toEntity.lastName
    this.age = this@toEntity.age
    this.sex = this@toEntity.sex
    this.title = this@toEntity.title
    this.phoneNumber = this@toEntity.phoneNumber
    this.email = this@toEntity.email
    this.address = this@toEntity.address
    this.avatarLink = this@toEntity.avatarLink
    this.experience = this@toEntity.experience
    this.averageMonthlyNumberOfPassengers = this@toEntity.averageMonthlyNumberOfPassengers
    this.lastMonthWorkHours = this@toEntity.lastMonthWorkHours
    this.carEntities = cars ?: this@toEntity.cars.map { it.toEntity(this) }.toMutableSet()
}