package com.example.taxi.dolphin.model.dto

import com.example.taxi.dolphin.exception.PropertyShouldBeNotNullException
import com.example.taxi.dolphin.model.entity.AccountEntity
import com.example.taxi.dolphin.model.entity.UserEntity
import com.example.taxi.dolphin.model.enumerated.SexType
import com.example.taxi.dolphin.model.enumerated.Title
import java.io.Serializable

/**
 * DTO for {@link com.example.taxi.dolphin.model.entity.UserEntity}
 */
open class UserDto(
    var id: Long? = null,
    val firstName: String,
    val lastName: String,
    val age: Int,
    val sex: SexType,
    val title: Title,
    val phoneNumber: String,
    val email: String,
    val address: String,
    val avatarLink: String
) : Serializable {
    var accountDto: AccountDto? = null
}

fun UserDto.toEntity(accountEntity: AccountEntity? = null): UserEntity = UserEntity().apply {
    this.id = this@toEntity.id
    this.firstName = this@toEntity.firstName
    this.lastName = this@toEntity.lastName
    this.age = this@toEntity.age
    this.sex = this@toEntity.sex
    this.title = this@toEntity.title
    this.phoneNumber = this@toEntity.phoneNumber
    this.email = this@toEntity.email
    this.address = this@toEntity.address
    this.avatarLink  = this@toEntity.avatarLink

    this.account?.user = this
    this.account = accountEntity ?: this@toEntity.accountDto?.toEntity(this) ?: throw PropertyShouldBeNotNullException("The account has to be not null")
}