package com.example.taxi.dolphin.model.dto

import com.example.taxi.dolphin.model.entity.LocationEntity
import java.io.Serializable
import java.time.LocalDateTime

/**
 * DTO for {@link com.example.taxi.dolphin.model.entity.LocationEntity}
 */
data class LocationDto(
    val id: Long? = null,
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,
    val time: LocalDateTime
) : Serializable

fun LocationDto.toEntity(): LocationEntity = LocationEntity().apply {
    this.id = this@toEntity.id
    this.latitude = this@toEntity.latitude
    this.longitude = this@toEntity.longitude
    this.time = this@toEntity.time
}
