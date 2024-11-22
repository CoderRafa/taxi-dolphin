package com.example.taxi.dolphin.model.dto

import com.example.taxi.dolphin.model.entity.AccountEntity
import com.example.taxi.dolphin.model.entity.MoneyAccountEntity
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
    val moneyAccounts: MutableSet<MoneyAccountDto> = mutableSetOf(),
    val user: UserDto? = null
) : Serializable

fun AccountDto.toEntity(user: UserEntity? = null, moneyAccountEntities: MutableSet<MoneyAccountEntity>? = null): AccountEntity = AccountEntity().apply {
    this.id = this@toEntity.id
    this.registrationDate = this@toEntity.registrationDate
    this.type = this@toEntity.type
    this.rating = this@toEntity.rating
    this.user = user ?: this@toEntity.user?.toEntity(this) ?: throw RuntimeException("The user has to be not null")
    this.moneyAccountEntities = moneyAccountEntities ?: this@toEntity.moneyAccounts.map { it.toEntity(this) }.toMutableSet()
}