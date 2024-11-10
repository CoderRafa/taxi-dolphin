package com.example.taxi.dolphin.model.dto

import com.example.taxi.dolphin.model.entity.UserEntity
import com.example.taxi.dolphin.model.enumerated.SexType
import com.example.taxi.dolphin.model.enumerated.Title
import com.fasterxml.jackson.annotation.JsonBackReference
import java.io.Serializable

/**
 * DTO for {@link com.example.taxi.dolphin.model.entity.UserEntity}
 */
open class UserDto(
    val id: Long? = null,
    val firstName: String,
    val lastName: String,
    val age: String,
    val sex: SexType,
    val title: Title,
    val phoneNumber: String,
    val email: String,
    val address: String,
    val avatarLink: String,
    @JsonBackReference
    val accountDto: AccountDto
) : Serializable

fun UserDto.toEntity(): UserEntity = UserEntity().apply {
    id = this@toEntity.id
    firstName = this@toEntity.firstName
    lastName = this@toEntity.lastName
    age = this@toEntity.age
    sex = this@toEntity.sex
    title = this@toEntity.title
    phoneNumber = this@toEntity.phoneNumber
    email = this@toEntity.email
    address = this@toEntity.address
    avatarLink  = this@toEntity.avatarLink
    account = this@toEntity.accountDto.toEntity()
}