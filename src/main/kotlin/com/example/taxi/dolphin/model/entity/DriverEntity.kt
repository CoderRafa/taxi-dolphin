package com.example.taxi.dolphin.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "driver")
@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue("Driver")
open class DriverEntity : UserEntity() {

    @Column(name = "experience")
    open var experience: Int? = null

    @Column(name = "average_monthly_number_of_passengers")
    open var averageMonthlyNumberOfPassengers: Double? = null

    @Column(name = "last_month_work_hours")
    open var lastMonthWorkHours: Double? = null

    @OneToMany(mappedBy = "driverEntity", cascade = [CascadeType.ALL], orphanRemoval = true)
    open var tripEntities: MutableSet<TripEntity> = mutableSetOf()

    @OneToMany(mappedBy = "driverEntity", cascade = [CascadeType.ALL], orphanRemoval = true)
    open var carEntities: MutableSet<com.example.taxi.dolphin.model.entity.CarEntity> = mutableSetOf()

    @OneToOne(cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "combined_rating_entity_id")
    open var combinedRatingEntity: CombinedRatingEntity? = null
}