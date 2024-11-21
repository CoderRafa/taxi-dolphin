package com.example.taxi.dolphin.model.dto

import com.example.taxi.dolphin.model.entity.CarEntity
import com.example.taxi.dolphin.model.entity.DriverEntity
import com.example.taxi.dolphin.model.entity.LocationEntity
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
    val driverDto: DriverDto
) : Serializable

fun CarDto.toEntity(driverEntity: DriverEntity? = null, locationEntity: LocationEntity? = null): CarEntity = CarEntity().apply {
    this.id = this@toEntity.id
    this.make = this@toEntity.make
    this.model = this@toEntity.model
    this.color = this@toEntity.color
    this.category = this@toEntity.category
    this.licencePlateNumber = this@toEntity.licencePlateNumber
    this.locationEntity = locationEntity ?: this@toEntity.locationDto.toEntity()
    this.driverEntity = driverEntity ?: this@toEntity.driverDto.toEntity( )
}
