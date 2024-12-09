package com.example.taxi.dolphin.model.dto

import com.example.taxi.dolphin.exception.PropertyShouldBeNotNullException
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
    val comment: String? = null,
) : Serializable {
    var givenRating: Review? = null
    lateinit var tripDto: TripDto
}

fun RatingDto.toEntity(
    givenRating: Review? = null,
    tripEntity: TripEntity? = null
    ): RatingEntity = RatingEntity().apply {
    this.id = this@toEntity.id
    this.byWhom = this@toEntity.byWhom
    this.forWhom = this@toEntity.forWhom
    this.givenRating = givenRating ?: this@toEntity.givenRating ?: throw PropertyShouldBeNotNullException("The givenRating has to be not null")
    this.comment = this@toEntity.comment
    this.tripEntity = tripEntity ?: this@toEntity.tripDto.toEntity()
}