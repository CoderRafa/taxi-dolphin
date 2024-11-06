package com.example.taxi.dolphin.model.dto

import com.example.taxi.dolphin.model.enumerated.Currency
import java.io.Serializable

/**
 * DTO for {@link com.example.taxi.dolphin.model.entity.MoneyAccountEntity}
 */
data class MoneyAccountDto(
    val id: Long? = null,
    val accountNumber: String? = null,
    val currency: Currency? = null,
    val balance: Double = 0.0,
    val accountDto: AccountDto? = null
) : Serializable