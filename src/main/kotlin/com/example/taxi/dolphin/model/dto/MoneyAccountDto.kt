package com.example.taxi.dolphin.model.dto

import com.example.taxi.dolphin.exception.PropertyShouldBeNotNullException
import com.example.taxi.dolphin.model.entity.AccountEntity
import com.example.taxi.dolphin.model.entity.MoneyAccountEntity
import com.example.taxi.dolphin.model.entity.PaymentEntity
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
) : Serializable {
    val fromPayments: MutableSet<PaymentDto> = mutableSetOf()
    val toPayments: MutableSet<PaymentDto> = mutableSetOf()
    var accountDto: AccountDto? = null
}

fun MoneyAccountDto.toEntity(
    accountEntity: AccountEntity? = null,
    fromPayments: MutableSet<PaymentEntity>? = null,
    toPayments: MutableSet<PaymentEntity>? = null
    ): MoneyAccountEntity = MoneyAccountEntity().apply {
    this.id = this@toEntity.id
    this.accountNumber = this@toEntity.accountNumber
    this.currency = this@toEntity.currency
    this.balance = this@toEntity.balance
    this.fromPaymentEntities = fromPayments ?: this@toEntity.fromPayments.map { it.toEntity(this) }.toMutableSet() ?: throw PropertyShouldBeNotNullException("The fromPayments has to be not null")
    this.toPaymentEntities = toPayments ?: this@toEntity.toPayments.map { it.toEntity(this) }.toMutableSet() ?: throw PropertyShouldBeNotNullException("The toPayments has to be not null")
    this.accountEntity = accountEntity ?: this@toEntity.accountDto?.toEntity() ?: throw PropertyShouldBeNotNullException("The account has to be not null")

}