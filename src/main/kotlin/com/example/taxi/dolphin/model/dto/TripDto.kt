package com.example.taxi.dolphin.model.dto

import com.example.taxi.dolphin.model.entity.DriverEntity
import com.example.taxi.dolphin.model.entity.PassengerEntity
import com.example.taxi.dolphin.model.entity.PaymentEntity
import com.example.taxi.dolphin.model.entity.TripEntity
import com.example.taxi.dolphin.model.enumerated.TripStatus
import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import java.io.Serializable
import java.time.LocalTime

/**
 * DTO for {@link com.example.taxi.dolphin.model.entity.TripEntity}
 */
data class TripDto(
    val id: Long? = null,
    val startTime: LocalTime,
    val finishTime: LocalTime,
    val startPoint: LocationDto,
    val endPoint: LocationDto,
    val tripStatus: TripStatus,
    val price: Double = 0.0,
    val distance: Double = 0.0,
    val driverDto: DriverDto,
    var ratings: List<RatingDto>,
    val passengerDto: PassengerDto,
    val paymentDto: PaymentDto?
) : Serializable

fun TripDto.toEntity(
    driverEntity: DriverEntity? = null,
    passengerEntity: PassengerEntity? = null,
    paymentEntity: PaymentEntity? = null
): TripEntity = TripEntity().apply {
    this.id = this@toEntity.id
    this.startTime = this@toEntity.startTime
    this.finishTime = this@toEntity.finishTime
    this.startPoint = this@toEntity.startPoint.toEntity()
    this.endPoint = this@toEntity.endPoint.toEntity()
    this.tripStatus = this@toEntity.tripStatus
    this.price = this@toEntity.price
    this.distance = this@toEntity.distance
    this.driverEntity = driverEntity ?: this@toEntity.driverDto.toEntity()
    this.ratingEntities = this@toEntity.ratings.map { it.toEntity(this) }.toMutableSet()
    this.passengerEntity = passengerEntity ?: this@toEntity.passengerDto.toEntity()
    this.paymentEntity = paymentEntity ?: this@toEntity.paymentDto?.toEntity()
}
