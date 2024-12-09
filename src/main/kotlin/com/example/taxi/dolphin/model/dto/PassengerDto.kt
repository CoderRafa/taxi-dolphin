package com.example.taxi.dolphin.model.dto

import com.example.taxi.dolphin.exception.PropertyShouldBeNotNullException
import com.example.taxi.dolphin.model.entity.AccountEntity
import com.example.taxi.dolphin.model.entity.CombinedRatingEntity
import com.example.taxi.dolphin.model.entity.PassengerEntity
import com.example.taxi.dolphin.model.entity.TripEntity
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
    val miles: Double? = null,
    val averageTip: Double? = null,
    val generalComment: String? = null,
    val favoriteRadioStation: String? = null,
) : UserDto(id, firstName, lastName, age, sex, title, phoneNumber, email, address, avatarLink) {
    var trips: MutableSet<TripDto> = mutableSetOf()
    var combinedRatingDto: CombinedRatingDto? = null
}

fun PassengerDto.toEntity(
    accountEntity: AccountEntity? = null,
    trips: MutableSet<TripEntity>? = null,
    combinedRating: CombinedRatingEntity? = null
    ): PassengerEntity = PassengerEntity().apply {
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
    this.account =  accountEntity ?: this@toEntity.accountDto?.toEntity() ?: throw PropertyShouldBeNotNullException("The account has to be not null")
    this.miles = this@toEntity.miles
    this.averageTip = this@toEntity.averageTip
    this.generalComment = this@toEntity.generalComment
    this.favoriteRadioStation = this@toEntity.favoriteRadioStation
    this.tripEntities = trips ?: this@toEntity.trips?.map { it.toEntity(passengerEntity = this) }?.toMutableSet() ?: throw PropertyShouldBeNotNullException("The passenger has to be not null")
    this.combinedRatingEntity = combinedRating ?: this@toEntity.combinedRatingDto?.toEntity()

    this.account!!.user = this
    this.account = accountEntity ?: this@toEntity.accountDto?.toEntity() ?: throw PropertyShouldBeNotNullException("The account has to be not null")
}