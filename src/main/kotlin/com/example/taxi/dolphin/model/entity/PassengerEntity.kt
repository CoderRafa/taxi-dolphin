package com.example.taxi.dolphin.model.entity

import com.example.taxi.dolphin.model.dto.CombinedRatingDto
import com.example.taxi.dolphin.model.dto.PassengerDto
import com.example.taxi.dolphin.model.dto.TripDto
import jakarta.persistence.*

@Entity
@Table(name = "passenger")
@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue("Passenger")
open class PassengerEntity : UserEntity() {

    @Column(name = "miles")
    open var miles: Double? = null

    @Column(name = "average_tip")
    open var averageTip: Double? = null

    @Column(name = "general_comment")
    open var generalComment: String? = null

    @Column(name = "favorite_radio_station")
    open var favoriteRadioStation: String? = null

    @OneToMany(mappedBy = "passengerEntity", cascade = [CascadeType.ALL], orphanRemoval = true)
    open var tripEntities: MutableSet<TripEntity> = mutableSetOf()

    @OneToOne(cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "combined_rating_entity_id")
    open var combinedRatingEntity: CombinedRatingEntity? = null
}

fun PassengerEntity.toDto(
    trips: MutableSet<TripDto>? = null,
    combinedRating: CombinedRatingDto? = null
): PassengerDto {
    val passengerDto = PassengerDto(
        this.id, this.firstName, this.lastName, this.age,
        this.sex, this.title, this.phoneNumber, this.email,
        this.address, this.avatarLink,
        this.miles, this.averageTip, this.generalComment,
        this.favoriteRadioStation,
    )

    val tripDtos = this.tripEntities.map { it.toDto() }
        .takeIf { this.tripEntities.isNotEmpty() } ?: trips ?: emptySet()

    passengerDto.trips.addAll(tripDtos)
    passengerDto.combinedRatingDto = this.combinedRatingEntity?.toDto() ?: combinedRating

    return passengerDto
}
