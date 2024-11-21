package com.example.taxi.dolphin.model.dto

import com.example.taxi.dolphin.model.entity.MoneyAccountEntity
import com.example.taxi.dolphin.model.enumerated.Currency

data class BasicMoneyAccountDto (
    val id: Long? = null,
    val accountNumber: String,
    val currency: Currency
)

fun BasicMoneyAccountDto.toEntity(): MoneyAccountEntity = MoneyAccountEntity().apply {
    this.id = this@toEntity.id
    this.accountNumber = this@toEntity.accountNumber
    this.currency = this@toEntity.currency
}