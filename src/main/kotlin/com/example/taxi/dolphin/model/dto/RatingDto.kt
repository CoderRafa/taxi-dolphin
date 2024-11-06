package com.example.taxi.dolphin.model.dto

import com.example.taxi.dolphin.model.enumerated.Review
import java.io.Serializable

/**
 * DTO for {@link com.example.taxi.dolphin.model.entity.RatingEntity}
 */
data class RatingDto(
    val id: Long? = null,
    val byWhom: Long? = null,
    val forWhom: Long? = null,
    val givenRating: Review? = null,
    val comment: String? = null,
    val tripDto: TripDto? = null
) : Serializable