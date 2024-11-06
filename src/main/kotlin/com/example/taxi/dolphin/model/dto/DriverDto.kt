package com.example.taxi.dolphin.model.dto

import com.example.taxi.dolphin.model.enumerated.SexType
import com.example.taxi.dolphin.model.enumerated.Title
import java.io.Serializable

/**
 * DTO for {@link com.example.taxi.dolphin.model.entity.DriverEntity}
 */
data class DriverDto(
    val id: Long? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val age: String? = null,
    val sex: SexType? = null,
    val title: Title? = null,
    val phoneNumber: String? = null,
    val email: String? = null,
    val address: String? = null,
    val avatarLink: String? = null,
    val experience: Int? = null,
    val averageMonthlyNumberOfPassengers: Double? = null,
    val lastMonthWorkHours: Double? = null,
    val combinedRatingEntity: CombinedRatingDto? = null
) : Serializable