package com.example.taxi.dolphin.model.dto

import com.example.taxi.dolphin.model.entity.AccountEntity
import com.example.taxi.dolphin.model.entity.MoneyAccountEntity
import com.example.taxi.dolphin.model.enumerated.Currency
import java.io.Serializable

/**
 * DTO for {@link com.example.taxi.dolphin.model.entity.MoneyAccountEntity}
 */
data class MoneyAccountDto(
    val id: Long? = null,
    val accountNumber: String,
    val currency: Currency,
    val balance: Double = 0.0,
    val fromPayments: MutableSet<PaymentDto>,
    val toPayments: MutableSet<PaymentDto>,
    val accountDto: AccountDto
) : Serializable

fun MoneyAccountDto.toEntity(accountEntity: AccountEntity? = null): MoneyAccountEntity = MoneyAccountEntity().apply {
    this.id = this@toEntity.id
    this.accountNumber = this@toEntity.accountNumber
    this.currency = this@toEntity.currency
    this.balance = this@toEntity.balance
    this.fromPaymentEntities = this@toEntity.fromPayments.map { it.toEntity(this) }.toMutableSet()
    this.toPaymentEntities = this@toEntity.toPayments.map { it.toEntity(this) }.toMutableSet()
    this.accountEntity = accountEntity ?: this@toEntity.accountDto.toEntity()
}