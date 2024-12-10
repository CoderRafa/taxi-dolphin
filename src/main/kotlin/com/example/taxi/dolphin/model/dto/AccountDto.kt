package com.example.taxi.dolphin.model.dto

import com.example.taxi.dolphin.exception.PropertyShouldBeNotNullException
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
    val rating: Double? = null
) : Serializable {
    val moneyAccounts: MutableSet<MoneyAccountDto> = mutableSetOf()
}

fun AccountDto.toEntity(user: UserEntity? = null, moneyAccounts: MutableSet<MoneyAccountEntity>? = null): AccountEntity = AccountEntity().apply {
    this.id = this@toEntity.id
    this.registrationDate = this@toEntity.registrationDate
    this.type = this@toEntity.type
    this.rating = this@toEntity.rating ?: 0.0
    this.moneyAccountEntities = moneyAccounts ?: this@toEntity.moneyAccounts.map { it.toEntity(this) }.toMutableSet() ?: mutableSetOf<MoneyAccountEntity>()
}