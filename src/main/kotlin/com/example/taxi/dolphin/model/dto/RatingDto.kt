package com.example.taxi.dolphin.model.dto

import com.example.taxi.dolphin.model.entity.RatingEntity
import com.example.taxi.dolphin.model.enumerated.Review
import com.fasterxml.jackson.annotation.JsonBackReference
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
    @JsonBackReference
    val tripDto: TripDto
) : Serializable

fun RatingDto.toEntity(): RatingEntity = RatingEntity().apply {
    id = this@toEntity.id
    byWhom = this@toEntity.byWhom
    forWhom = this@toEntity.forWhom
    givenRating = this@toEntity.givenRating
    comment = this@toEntity.comment
    tripEntity = this@toEntity.tripDto.toEntity()
}