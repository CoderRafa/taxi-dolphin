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
    id = this@toEntity.id
    latitude = this@toEntity.latitude
    longitude = this@toEntity.longitude
    time = this@toEntity.time
}
