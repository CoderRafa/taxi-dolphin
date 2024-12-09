package com.example.taxi.dolphin.model.entity

import com.example.taxi.dolphin.model.dto.*
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

fun DriverEntity.toDto(
    account: AccountDto? = null,
    trips: MutableSet<TripDto>? = null,
    cars: MutableSet<CarDto>? = null,
    combinedRating: CombinedRatingDto? = null
): DriverDto {
    val driverDto = DriverDto(
        this.id, this.firstName, this.lastName, this.age,
        this.sex, this.title, this.phoneNumber, this.email,
        this.address, this.avatarLink,
        this.experience, this.averageMonthlyNumberOfPassengers,
        this.lastMonthWorkHours
    )

    driverDto.accountDto = this.account?.toDto() ?: account

    val tripDtos = this.tripEntities.map { it.toDto() }
        .takeIf { this.tripEntities.isNotEmpty() } ?: trips ?: emptySet()
    driverDto.trips.addAll(tripDtos)

    val carDtos = this.carEntities.map { it.toDto() }
        .takeIf { this.carEntities.isNotEmpty() } ?: cars ?: emptySet()
    driverDto.cars.addAll(carDtos)

    driverDto.combinedRatingDto = this.combinedRatingEntity?.toDto() ?: combinedRating

    return driverDto
}

//fun DriverEntity.toBasicDto(): BasicDriverDto = BasicDriverDto(
//    UserDto(id, firstName, lastName, age, sex,
//        title, phoneNumber, email, address,
//        avatarLink), experience
//)