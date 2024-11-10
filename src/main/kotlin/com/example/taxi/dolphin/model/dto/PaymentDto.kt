package com.example.taxi.dolphin.model.dto

import com.example.taxi.dolphin.model.entity.PaymentEntity
import com.example.taxi.dolphin.model.enumerated.PaymentStatus
import java.io.Serializable
import java.time.LocalDateTime

/**
 * DTO for {@link com.example.taxi.dolphin.model.entity.PaymentEntity}
 */
data class PaymentDto(
    val id: Long? = null,
    val amount: Double = 0.0,
    val createdDate: LocalDateTime,
    val confirmedDate: LocalDateTime,
    val purpose: String,
    val paymentStatus: PaymentStatus,
    val moneyAccountDto: MoneyAccountDto
) : Serializable

fun PaymentDto.toEntity(): PaymentEntity = PaymentEntity().apply {
    id = this@toEntity.id
    amount= this@toEntity.amount
    createdDate = this@toEntity.createdDate
    confirmedDate = this@toEntity.confirmedDate
    purpose = this@toEntity.purpose
    paymentStatus = this@toEntity.paymentStatus
    moneyAccountEntity = this@toEntity.moneyAccountDto.toEntity()
}