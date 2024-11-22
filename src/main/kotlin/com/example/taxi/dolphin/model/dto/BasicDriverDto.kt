package com.example.taxi.dolphin.model.dto

import com.example.taxi.dolphin.model.entity.DriverEntity
import java.lang.RuntimeException

data class BasicDriverDto(
    val user: UserDto,
    val experience: Int?
)

fun BasicDriverDto.toEntity(): DriverEntity = DriverEntity().apply {
    this.firstName = this@toEntity.user.firstName
    this.lastName = this@toEntity.user.lastName
    this.age = this@toEntity.user.age
    this.sex = this@toEntity.user.sex
    this.title = this@toEntity.user.title
    this.phoneNumber = this@toEntity.user.phoneNumber
    this.email = this@toEntity.user.email
    this.address = this@toEntity.user.address
    this.avatarLink = this@toEntity.user.avatarLink
    this.account = this@toEntity.user.accountDto?.toEntity() ?: throw RuntimeException("The account has to be not null")
    this.experience = this@toEntity.experience

}