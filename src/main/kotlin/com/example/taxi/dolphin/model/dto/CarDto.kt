package com.example.taxi.dolphin.model.dto

import com.example.taxi.dolphin.model.entity.CarEntity
import com.example.taxi.dolphin.model.enumerated.CarCategory
import com.example.taxi.dolphin.model.enumerated.CarColor
import com.fasterxml.jackson.annotation.JsonBackReference
import java.io.Serializable

/**
 * DTO for {@link com.example.taxi.dolphin.model.entity.CarEntity}
 */
data class CarDto(
    val id: Long? = null,
    val make: String,
    val model: String,
    val color: CarColor,
    val category: CarCategory,
    val licencePlateNumber: String,
    val locationDto: LocationDto,
    @JsonBackReference
    val driverDto: DriverDto
) : Serializable

fun CarDto.toEntity(): CarEntity = CarEntity().apply {
    id = this@toEntity.id
    make = this@toEntity.make
    model = this@toEntity.model
    color = this@toEntity.color
    category = this@toEntity.category
    licencePlateNumber = this@toEntity.licencePlateNumber
    locationEntity = this@toEntity.locationDto.toEntity()
    driverEntity = this@toEntity.driverDto.toEntity()
}
