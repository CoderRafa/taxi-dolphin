package com.example.taxi.dolphin.model.dto

import com.example.taxi.dolphin.exception.PropertyShouldBeNotNullException
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
    val licencePlateNumber: String
) : Serializable {
    lateinit var locationDtos: MutableSet<LocationDto>
    lateinit var driverDto: DriverDto
}

fun CarDto.toEntity(driverEntity: DriverEntity? = null, locationEntities: MutableSet<LocationEntity>? = null): CarEntity = CarEntity().apply {
    this.id = this@toEntity.id
    this.make = this@toEntity.make
    this.model = this@toEntity.model
    this.color = this@toEntity.color
    this.category = this@toEntity.category
    this.licencePlateNumber = this@toEntity.licencePlateNumber
    this.locationEntities = locationEntities ?: this@toEntity.locationDtos.map { it.toEntity() }.toMutableSet()
    this.driverEntity = driverEntity ?: this@toEntity.driverDto.toEntity(cars = mutableSetOf(this))
}
