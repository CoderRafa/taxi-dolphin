package com.example.taxi.dolphin.service

import com.example.taxi.dolphin.model.dto.PassengerDto
import com.example.taxi.dolphin.model.dto.RatingDto
import com.example.taxi.dolphin.model.dto.TripDto
import java.time.LocalDate

interface PassengerService {

    fun save(passengerDto: PassengerDto): PassengerDto

    fun seeTripHistory(passengerId: Long): List<TripDto>

    fun seeRatingsGiven(passengerId: Long): List<RatingDto>

    fun checkBalance(passengerId: Long): Double

    fun checkSpendingInPeriod(passengerId: Long, startDate: LocalDate, endDate: LocalDate): Double

}