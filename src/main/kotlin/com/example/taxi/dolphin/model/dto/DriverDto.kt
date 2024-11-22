package com.example.taxi.dolphin.model.dto

import com.example.taxi.dolphin.model.entity.AccountEntity
import com.example.taxi.dolphin.model.entity.DriverEntity
import com.example.taxi.dolphin.model.enumerated.SexType
import com.example.taxi.dolphin.model.enumerated.Title
import com.fasterxml.jackson.annotation.JsonManagedReference
import java.io.Serializable
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
    accountDto: AccountDto,
    val experience: Int? = null,
    val averageMonthlyNumberOfPassengers: Double? = null,
    val lastMonthWorkHours: Double? = null,
    val trips: MutableSet<TripDto>,
    val cars: MutableSet<CarDto>,
    val combinedRatingDto: CombinedRatingDto? = null
) : UserDto(id, firstName, lastName, age, sex, title, phoneNumber, email, address, avatarLink, accountDto)

fun DriverDto.toEntity(accountEntity: AccountEntity? = null): DriverEntity = DriverEntity().apply {
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
    this.account = accountEntity ?: this@toEntity.accountDto?.toEntity() ?: throw RuntimeException("The account has to be not null")
    this.experience = this@toEntity.experience
    this.averageMonthlyNumberOfPassengers = this@toEntity.averageMonthlyNumberOfPassengers
    this.lastMonthWorkHours = this@toEntity.lastMonthWorkHours
    this.tripEntities = this@toEntity.trips.map { it.toEntity(this) }.toMutableSet()
    this.carEntities = this@toEntity.cars.map { it.toEntity(this) }.toMutableSet()
    this.combinedRatingEntity = this@toEntity.combinedRatingDto?.toEntity()
    this.account.user = this
}