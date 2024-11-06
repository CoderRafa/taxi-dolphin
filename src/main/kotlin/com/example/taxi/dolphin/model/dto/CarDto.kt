package com.example.taxi.dolphin.model.dto

import com.example.taxi.dolphin.model.enumerated.CarCategory
import com.example.taxi.dolphin.model.enumerated.CarColor
import java.io.Serializable

/**
 * DTO for {@link com.example.taxi.dolphin.model.entity.CarEntity}
 */
data class CarDto(
    val id: Long? = null,
    val make: String? = null,
    val model: String? = null,
    val color: CarColor? = null,
    val category: CarCategory? = null,
    val licencePlateNumber: String? = null,
    val locationDto: LocationDto? = null,
    val driverEntity: DriverDto? = null
) : Serializable