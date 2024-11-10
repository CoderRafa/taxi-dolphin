package com.example.taxi.dolphin.model.entity

import com.example.taxi.dolphin.model.dto.CombinedRatingDto
import jakarta.persistence.*

@Entity
@Table(name = "combined_rating")
open class CombinedRatingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "combined_rating_seq")
    @SequenceGenerator(name = "combined_rating_seq")
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "number_of_trips")
    open var numberOfTrips: Int? = null

    @Column(name = "number_of_fives")
    open var numberOfFives: Int? = null

    @Column(name = "number_of_fourss")
    open var numberOfFours: Int? = null

    @Column(name = "number_of_threes")
    open var numberOfThrees: Int? = null

    @Column(name = "number_of_twos")
    open var numberOfTwos: Int? = null

    @Column(name = "number_of_ones")
    open var numberOfOnes: Int? = null
}

fun CombinedRatingEntity.toDto(): CombinedRatingDto = CombinedRatingDto(
    id, numberOfTrips, numberOfFives, numberOfFours, numberOfThrees, numberOfTwos, numberOfOnes
)