package com.example.taxi.dolphin.model.dto

import com.example.taxi.dolphin.model.entity.RatingEntity
import com.example.taxi.dolphin.model.entity.TripEntity
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
    val tripDto: TripDto
) : Serializable

fun RatingDto.toEntity(tripEntity: TripEntity? = null): RatingEntity = RatingEntity().apply {
    this.id = this@toEntity.id
    this.byWhom = this@toEntity.byWhom
    this.forWhom = this@toEntity.forWhom
    this.givenRating = this@toEntity.givenRating
    this.comment = this@toEntity.comment
    this.tripEntity = tripEntity ?:  this@toEntity.tripDto.toEntity()
}