package com.example.taxi.dolphin.model.dto

import com.example.taxi.dolphin.exception.PropertyShouldBeNotNullException
import com.example.taxi.dolphin.model.entity.*
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
    val tripStatus: TripStatus,
    val price: Double = 0.0,
    val distance: Double = 0.0,
) : Serializable {
    var startPoint: LocationDto? = null
    var endPoint: LocationDto? = null
    var driverDto: DriverDto? = null
    var ratings: MutableSet<RatingDto> = mutableSetOf()
    lateinit var passengerDto: PassengerDto
    var paymentDto: PaymentDto? = null
}

fun TripDto.toEntity(
    startPoint: LocationEntity? = null,
    endPoint: LocationEntity? = null,
    driverEntity: DriverEntity? = null,
    passengerEntity: PassengerEntity? = null,
    paymentEntity: PaymentEntity? = null
): TripEntity = TripEntity().apply {
    this.id = this@toEntity.id
    this.startTime = this@toEntity.startTime
    this.finishTime = this@toEntity.finishTime
    this.startPoint = startPoint ?: this@toEntity.startPoint?.toEntity() ?: throw PropertyShouldBeNotNullException("The startPoint has to be not null")
    this.endPoint = endPoint ?: this@toEntity.endPoint?.toEntity() ?: throw PropertyShouldBeNotNullException("The startPoint has to be not null")
    this.tripStatus = this@toEntity.tripStatus
    this.price = this@toEntity.price
    this.distance = this@toEntity.distance
    this.driverEntity = driverEntity ?: this@toEntity.driverDto?.toEntity() ?: throw PropertyShouldBeNotNullException("The user has to be not null")
    this.ratingEntities = this@toEntity.ratings?.map { it.toEntity(tripEntity = this) }?.toMutableSet() ?: throw PropertyShouldBeNotNullException("The user has to be not null")
    this.passengerEntity = passengerEntity ?: this@toEntity.passengerDto.toEntity()
    this.paymentEntity = paymentEntity ?: this@toEntity.paymentDto?.toEntity()
}
