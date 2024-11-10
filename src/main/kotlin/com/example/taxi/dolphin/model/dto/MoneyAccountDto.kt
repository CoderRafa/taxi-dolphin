package com.example.taxi.dolphin.model.dto

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

fun MoneyAccountDto.toEntity(): MoneyAccountEntity = MoneyAccountEntity().apply {
    id = this@toEntity.id
    accountNumber = this@toEntity.accountNumber
    currency = this@toEntity.currency
    balance = this@toEntity.balance
    paymentEntities = this@toEntity.payments.map { it.toEntity() }.toMutableSet()
    accountEntity = this@toEntity.accountDto.toEntity()
}