package com.example.taxi.dolphin.model.dto

import com.example.taxi.dolphin.model.entity.PassengerEntity
import com.example.taxi.dolphin.model.enumerated.SexType
import com.example.taxi.dolphin.model.enumerated.Title
import com.fasterxml.jackson.annotation.JsonManagedReference

/**
 * DTO for {@link com.example.taxi.dolphin.model.entity.PassengerEntity}
 */
class PassengerDto(
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
    val miles: Double? = null,
    val averageTip: Double? = null,
    val generalComment: String? = null,
    val favoriteRadioStation: String? = null,
    @JsonManagedReference
    val trips: List<TripDto>,
    val combinedRatingDto: CombinedRatingDto? = null
) : UserDto(id, firstName, lastName, age, sex, title, phoneNumber, email, address, avatarLink, accountDto)

fun PassengerDto.toEntity(): PassengerEntity = PassengerEntity().apply {
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
    miles = this@toEntity.miles
    averageTip = this@toEntity.averageTip
    generalComment = this@toEntity.generalComment
    favoriteRadioStation = this@toEntity.favoriteRadioStation
    tripEntities = this@toEntity.trips.map { it.toEntity() }.toMutableSet()
    combinedRatingEntity = this@toEntity.combinedRatingDto?.toEntity()

}