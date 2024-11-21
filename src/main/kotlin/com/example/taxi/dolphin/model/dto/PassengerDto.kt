package com.example.taxi.dolphin.model.dto

import com.example.taxi.dolphin.model.entity.AccountEntity
import com.example.taxi.dolphin.model.entity.PassengerEntity
import com.example.taxi.dolphin.model.enumerated.SexType
import com.example.taxi.dolphin.model.enumerated.Title
import com.fasterxml.jackson.annotation.JsonManagedReference
import java.lang.RuntimeException

/**
 * DTO for {@link com.example.taxi.dolphin.model.entity.PassengerEntity}
 */
class PassengerDto(
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
    val miles: Double? = null,
    val averageTip: Double? = null,
    val generalComment: String? = null,
    val favoriteRadioStation: String? = null,
    val trips: List<TripDto>,
    val combinedRatingDto: CombinedRatingDto? = null
) : UserDto(id, firstName, lastName, age, sex, title, phoneNumber, email, address, avatarLink, accountDto)

fun PassengerDto.toEntity(accountEntity: AccountEntity? = null): PassengerEntity = PassengerEntity().apply {
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
    this.account =  accountEntity ?: this@toEntity.accountDto.toEntity()
    this.miles = this@toEntity.miles
    this.averageTip = this@toEntity.averageTip
    this.generalComment = this@toEntity.generalComment
    this.favoriteRadioStation = this@toEntity.favoriteRadioStation
    this.tripEntities = this@toEntity.trips.map { it.toEntity(passengerEntity = this) }.toMutableSet()
    this.combinedRatingEntity = this@toEntity.combinedRatingDto?.toEntity()

}