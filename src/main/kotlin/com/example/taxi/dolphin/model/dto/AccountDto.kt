package com.example.taxi.dolphin.model.dto

import com.example.taxi.dolphin.model.entity.AccountEntity
import com.example.taxi.dolphin.model.entity.UserEntity
import com.example.taxi.dolphin.model.enumerated.AccountType
import com.fasterxml.jackson.annotation.JsonManagedReference
import java.io.Serializable
import java.time.LocalDate

/**
 * DTO for {@link com.example.taxi.dolphin.model.entity.AccountEntity}
 */
data class AccountDto(
    val id: Long? = null,
    val registrationDate: LocalDate,
    val type: AccountType = AccountType.BASIC,
    val rating: Double? = null,
    val user: UserDto,
    val moneyAccounts: MutableSet<MoneyAccountDto> = mutableSetOf()
) : Serializable

fun AccountDto.toEntity(): AccountEntity = AccountEntity().apply {
    this.id = this@toEntity.id
    this.registrationDate = this@toEntity.registrationDate
    this.type = this@toEntity.type
    this.rating = this@toEntity.rating
    this.user = this@toEntity.user.toEntity(this)
    this.moneyAccountEntities = this@toEntity.moneyAccounts.map { it.toEntity(this) }.toMutableSet()
}