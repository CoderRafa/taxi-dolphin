package com.example.taxi.dolphin.service

import com.example.taxi.dolphin.model.dto.DriverDto
import com.example.taxi.dolphin.model.dto.RatingDto
import com.example.taxi.dolphin.model.dto.TripDto
import com.example.taxi.dolphin.model.enumerated.AvailabilityStatus

interface DriverService {

    fun save(driverDto: DriverDto): DriverDto

    fun setAvailability(id: Long): DriverDto

    fun seeNumberOfTripsH(driverId: Long): Int

    fun seeRatingsGiven(driverId: Long): List<RatingDto>

    fun checkEarnings(driverId: Long): Double

    fun checkOwnRating(driverId: Long): Double

}