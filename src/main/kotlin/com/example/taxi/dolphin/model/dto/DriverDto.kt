package com.example.taxi.dolphin.model.dto

import com.example.taxi.dolphin.model.entity.DriverEntity
import com.example.taxi.dolphin.model.enumerated.SexType
import com.example.taxi.dolphin.model.enumerated.Title
import com.fasterxml.jackson.annotation.JsonManagedReference
import java.io.Serializable

/**
 * DTO for {@link com.example.taxi.dolphin.model.entity.DriverEntity}
 */
class DriverDto(
    id: Long? = null,
    firstName: String,
    lastName: String,
    age: String,
    sex: SexType,
    title: Title,
    phoneNumber: String,
    email: String,
    address: String,
    avatarLink: String,
    accountDto: AccountDto,
    val experience: Int? = null,
    val averageMonthlyNumberOfPassengers: Double? = null,
    val lastMonthWorkHours: Double? = null,
    @JsonManagedReference
    val trips: List<TripDto>,
    @JsonManagedReference
    val cars: List<CarDto>,
    val combinedRatingDto: CombinedRatingDto? = null
) : UserDto(id, firstName, lastName, age, sex, title, phoneNumber, email, address, avatarLink, accountDto)

fun DriverDto.toEntity(): DriverEntity = DriverEntity().apply {
    id = this@toEntity.id
    firstName = this@toEntity.firstName
    lastName = this@toEntity.lastName
    age = this@toEntity.age
    sex = this@toEntity.sex
    title = this@toEntity.title
    phoneNumber = this@toEntity.phoneNumber
    email = this@toEntity.email
    address = this@toEntity.address
    avatarLink = this@toEntity.avatarLink
    account = this@toEntity.accountDto.toEntity()
    experience = this@toEntity.experience
    averageMonthlyNumberOfPassengers = this@toEntity.averageMonthlyNumberOfPassengers
    lastMonthWorkHours = this@toEntity.lastMonthWorkHours
    tripEntities = this@toEntity.trips.map { it.toEntity() }.toMutableSet()
    carEntities = this@toEntity.cars.map { it.toEntity() }.toMutableSet()
    combinedRatingEntity = this@toEntity.combinedRatingDto?.toEntity()

}