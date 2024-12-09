package com.example.taxi.dolphin.model.dto

import com.example.taxi.dolphin.model.entity.MoneyAccountEntity
import com.example.taxi.dolphin.model.entity.PaymentEntity
import com.example.taxi.dolphin.model.entity.TripEntity
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
) : Serializable {
    lateinit var from: MoneyAccountDto
    lateinit var to: MoneyAccountDto
    lateinit var tripDto: TripDto
}

fun PaymentDto.toEntity(
    moneyAccountEntity: MoneyAccountEntity? = null,
    trip: TripEntity? = null
    ): PaymentEntity = PaymentEntity().apply {
    this.id = this@toEntity.id
    this.amount= this@toEntity.amount
    this.createdDate = this@toEntity.createdDate
    this.confirmedDate = this@toEntity.confirmedDate
    this.purpose = this@toEntity.purpose
    this.paymentStatus = this@toEntity.paymentStatus
    this.from = moneyAccountEntity ?: this@toEntity.from.toEntity()
    this.to = moneyAccountEntity ?: this@toEntity.from.toEntity()
    this.tripEntity = trip ?: this@toEntity.tripDto.toEntity(paymentEntity = this)
}