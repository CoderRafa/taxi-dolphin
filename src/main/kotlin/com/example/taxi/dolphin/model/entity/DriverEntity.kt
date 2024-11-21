package com.example.taxi.dolphin.model.entity

import com.example.taxi.dolphin.model.dto.BasicDriverDto
import com.example.taxi.dolphin.model.dto.DriverDto
import com.example.taxi.dolphin.model.dto.UserDto
import com.example.taxi.dolphin.model.enumerated.AvailabilityStatus
import jakarta.persistence.*

@Entity
@Table(name = "driver")
@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue("Driver")
open class DriverEntity : UserEntity() {
    @Enumerated(EnumType.STRING)
    @Column(name = "availability_status")
    open var availabilityStatus: AvailabilityStatus = AvailabilityStatus.NOT_AVAILABLE

    @Column(name = "experience")
    open var experience: Int? = null

    @Column(name = "average_monthly_number_of_passengers")
    open var averageMonthlyNumberOfPassengers: Double? = null

    @Column(name = "last_month_work_hours")
    open var lastMonthWorkHours: Double? = null

    @OneToMany(mappedBy = "driverEntity", cascade = [CascadeType.ALL], orphanRemoval = true)
    open var tripEntities: MutableSet<TripEntity> = mutableSetOf()

    @OneToMany(mappedBy = "driverEntity", cascade = [CascadeType.ALL], orphanRemoval = true)
    open var carEntities: MutableSet<CarEntity> = mutableSetOf()

    @OneToOne(cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "combined_rating_entity_id")
    open var combinedRatingEntity: CombinedRatingEntity? = null
}

fun DriverEntity.toDto(): DriverDto = DriverDto(
    id, firstName, lastName, age,
    sex, title, phoneNumber, email,
    address, avatarLink, account.toDto(),
    experience, averageMonthlyNumberOfPassengers,
    lastMonthWorkHours, tripEntities.map { it.toDto() }.toMutableSet(),
    carEntities.map { it.toDto() }.toMutableSet(),
    combinedRatingEntity?.toDto()
)

fun DriverEntity.toBasicDto(): BasicDriverDto = BasicDriverDto(
    UserDto(id, firstName, lastName, age, sex,
        title, phoneNumber, email, address,
        avatarLink, account.toDto()), experience
)