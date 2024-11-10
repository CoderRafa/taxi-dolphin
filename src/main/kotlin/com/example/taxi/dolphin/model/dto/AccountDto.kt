package com.example.taxi.dolphin.model.dto

import com.example.taxi.dolphin.model.entity.AccountEntity
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
    val type: AccountType,
    val rating: Double? = null,
    @JsonManagedReference
    val user: UserDto,
    @JsonManagedReference
    val moneyAccounts: MutableSet<MoneyAccountDto>
) : Serializable

fun AccountDto.toEntity(): AccountEntity = AccountEntity().apply {
    id = this@toEntity.id
    registrationDate = this@toEntity.registrationDate
    type = this@toEntity.type
    rating = this@toEntity.rating
    user = this@toEntity.user.toEntity()
    user.account = this
    moneyAccountEntities = this@toEntity.moneyAccounts.map { it.toEntity() }.toMutableSet()
    moneyAccountEntities.map { it.accountEntity = this }
}



