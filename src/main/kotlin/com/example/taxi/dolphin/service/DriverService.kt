package com.example.taxi.dolphin.service

import com.example.taxi.dolphin.model.dto.DriverDto
import com.example.taxi.dolphin.model.enumerated.AvailabilityStatus

interface DriverService {

    fun save(driverDto: DriverDto): DriverDto

    fun setAvailability(id: Long): DriverDto

}