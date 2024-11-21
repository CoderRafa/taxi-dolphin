package com.example.taxi.dolphin.model.dto

import com.example.taxi.dolphin.model.entity.CombinedRatingEntity
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

fun combinedRating(combinedRatingDto: CombinedRatingDto): Double {
    with(combinedRatingDto) {
        val ratingSum =
            (numberOfFives?.times(5) ?: 0) + (numberOfFours?.times(4) ?: 0) +
                    (numberOfThrees?.times(3) ?: 0) + (numberOfTwos?.times(2) ?: 0) +
                    (numberOfOnes ?: 0)

        val averageRating = ratingSum / (numberOfTrips ?: 1)

        return averageRating.toDouble()
    }
}

fun CombinedRatingDto.toEntity(): CombinedRatingEntity = CombinedRatingEntity().apply {
    this.id = this@toEntity.id
    this.numberOfTrips = this@toEntity.numberOfTrips
    this.numberOfFives = this@toEntity.numberOfFives
    this.numberOfFours = this@toEntity.numberOfFours
    this.numberOfThrees = this@toEntity.numberOfThrees
    this.numberOfTwos = this@toEntity.numberOfTwos
    this.numberOfOnes = this@toEntity.numberOfOnes
}