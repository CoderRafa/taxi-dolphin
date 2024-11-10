package com.example.taxi.dolphin.model.dto

import com.example.taxi.dolphin.model.entity.AccountEntity
import com.example.taxi.dolphin.model.entity.MoneyAccountEntity
import com.example.taxi.dolphin.model.enumerated.Currency
import com.fasterxml.jackson.annotation.JsonBackReference
import java.io.Serializable

/**
 * DTO for {@link com.example.taxi.dolphin.model.entity.MoneyAccountEntity}
 */
data class MoneyAccountDto(
    val id: Long? = null,
    val accountNumber: String,
    val currency: Currency,
    val balance: Double = 0.0,
    val payments: MutableSet<PaymentDto>,
    @JsonBackReference
    val accountDto: AccountDto
) : Serializable

fun MoneyAccountDto.toEntity(accountEntity: AccountEntity? = null): MoneyAccountEntity = MoneyAccountEntity().apply {
    this.id = this@toEntity.id
    this.accountNumber = this@toEntity.accountNumber
    this.currency = this@toEntity.currency
    this.balance = this@toEntity.balance
    this.paymentEntities = this@toEntity.payments.map { it.toEntity() }.toMutableSet()
    this.accountEntity = accountEntity ?: this@toEntity.accountDto.toEntity()
}