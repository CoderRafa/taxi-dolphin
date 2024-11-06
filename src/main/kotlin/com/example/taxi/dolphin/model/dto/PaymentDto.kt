package com.example.taxi.dolphin.model.dto

import com.example.taxi.dolphin.model.enumerated.PaymentStatus
import java.io.Serializable
import java.time.LocalDateTime

/**
 * DTO for {@link com.example.taxi.dolphin.model.entity.PaymentEntity}
 */
data class PaymentDto(
    val id: Long? = null,
    val amount: Double = 0.0,
    val createdDate: LocalDateTime? = null,
    val confirmedDate: LocalDateTime? = null,
    val purpose: String? = null,
    val paymentStatus: PaymentStatus? = null,
    val moneyAccountDto: MoneyAccountDto? = null
) : Serializable