package com.example.taxi.dolphin.model.dto

import com.example.taxi.dolphin.model.entity.CarEntity
import com.example.taxi.dolphin.model.entity.DriverEntity
import com.example.taxi.dolphin.model.enumerated.SexType
import com.example.taxi.dolphin.model.enumerated.Title

/**
 * DTO for {@link com.example.taxi.dolphin.model.entity.DriverEntity}
 */
class DriverDto(
    val id: Long? = null,
    val firstName: String,
    val lastName: String,
    val age: Int,
    val sex: SexType,
    val title: Title,
    val phoneNumber: String,
    val email: String,
    val address: String,
    val avatarLink: String,
    val experience: Int? = null,
    val averageMonthlyNumberOfPassengers: Double? = null,
    val lastMonthWorkHours: Double? = null,
    var cars: MutableSet<CarDto>? = mutableSetOf()
) {
    var trips: MutableSet<TripDto> = mutableSetOf()
    var combinedRatingDto: CombinedRatingDto? = null
    lateinit var account: AccountDto
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
    this.carEntities = cars ?: this@toEntity.cars?.map { it.toEntity(this) }?.toMutableSet() ?: mutableSetOf()
}