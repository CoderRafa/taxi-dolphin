package com.example.taxi.dolphin.model.dto

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
    @JsonBackReference
    val driverDto: DriverDto,
    @JsonManagedReference
    var ratings: List<RatingDto>,
    @JsonBackReference
    val passengerDto: PassengerDto
) : Serializable

fun TripDto.toEntity(): TripEntity = TripEntity().apply {
    id = this@toEntity.id
    startTime = this@toEntity.startTime
    finishTime = this@toEntity.finishTime
    startPoint = this@toEntity.startPoint.toEntity()
    endPoint = this@toEntity.endPoint.toEntity()
    tripStatus = this@toEntity.tripStatus
    price = this@toEntity.price
    distance = this@toEntity.distance
    driverEntity = this@toEntity.driverDto.toEntity()
    ratingEntities = this@toEntity.ratings.map { it.toEntity() }.toMutableSet()
    passengerEntity = this@toEntity.passengerDto.toEntity()
}
