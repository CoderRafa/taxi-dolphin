package com.example.taxi.dolphin.model.dto

import java.io.Serializable

/**
 * DTO for {@link com.example.taxi.dolphin.model.entity.CombinedRatingEntity}
 */
data class CombinedRatingDto(
    val id: Long? = null,
    val numberOfTrips: Int? = null,
    val numberOfFives: Int? = null,
    val numberOfFours: Int? = null,
    val numberOfThrees: Int? = null,
    val numberOfTwos: Int? = null,
    val numberOfOnes: Int? = null
) : Serializable