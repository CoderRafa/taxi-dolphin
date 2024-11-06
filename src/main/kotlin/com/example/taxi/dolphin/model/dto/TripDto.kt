package com.example.taxi.dolphin.model.dto

import com.example.taxi.dolphin.model.enumerated.TripStatus
import java.io.Serializable
import java.time.LocalTime

/**
 * DTO for {@link com.example.taxi.dolphin.model.entity.TripEntity}
 */
data class TripDto(
    val id: Long? = null,
    val startTime: LocalTime? = null,
    val finishTime: LocalTime? = null,
    val startPoint: LocationDto? = null,
    val endPoint: LocationDto? = null,
    val tripStatus: TripStatus? = null,
    val price: Double = 0.0,
    val distance: Double = 0.0,
    val driverDto: DriverDto? = null,
    val passengerDto: PassengerDto? = null
) : Serializable