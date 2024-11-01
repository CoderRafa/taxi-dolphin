package com.example.taxi.dolphin.model.entity

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