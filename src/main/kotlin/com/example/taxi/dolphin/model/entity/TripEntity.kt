package com.example.taxi.dolphin.model.entity

import com.example.taxi.dolphin.model.dto.PaymentDto
import com.example.taxi.dolphin.model.dto.RatingDto
import com.example.taxi.dolphin.model.dto.TripDto
import com.example.taxi.dolphin.model.enumerated.TripStatus
import jakarta.persistence.*
import org.hibernate.proxy.HibernateProxy
import java.time.LocalTime

@Entity
@Table(name = "trip")
open class TripEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trip_seq")
    @SequenceGenerator(name = "trip_seq")
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "start_time")
    open lateinit var startTime: LocalTime

    @Column(name = "finish_time")
    open lateinit var finishTime: LocalTime

    @OneToOne(cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "start_point_id")
    open lateinit var startPoint: LocationEntity

    @OneToOne(cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "end_point_id")
    open lateinit var endPoint: LocationEntity

    @Enumerated(EnumType.STRING)
    @Column(name = "trip_status")
    open lateinit var tripStatus: TripStatus

    @Column(name = "price")
    open var price: Double = 0.0

    @Column(name = "distance")
    open var distance: Double = 0.0

    @ManyToOne(cascade = [CascadeType.REFRESH])
    @JoinColumn(name = "driver_entity_id")
    open lateinit var driverEntity: DriverEntity

    @OneToMany(mappedBy = "tripEntity", cascade = [CascadeType.ALL], orphanRemoval = true)
    open var ratingEntities: MutableSet<RatingEntity> = mutableSetOf()

    @ManyToOne(cascade = [CascadeType.REFRESH])
    @JoinColumn(name = "passenger_entity_id")
    open lateinit var passengerEntity: PassengerEntity

    @OneToOne(mappedBy = "tripEntity", cascade = [CascadeType.ALL], orphanRemoval = true)
    open var paymentEntity: PaymentEntity? = null

    final override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null) return false
        val oEffectiveClass =
            if (other is HibernateProxy) other.hibernateLazyInitializer.persistentClass else other.javaClass
        val thisEffectiveClass =
            if (this is HibernateProxy) this.hibernateLazyInitializer.persistentClass else this.javaClass
        if (thisEffectiveClass != oEffectiveClass) return false
        other as TripEntity

        return id != null && id == other.id
    }

    final override fun hashCode(): Int =
        if (this is HibernateProxy) this.hibernateLazyInitializer.persistentClass.hashCode() else javaClass.hashCode()
}

fun TripEntity.toDto(ratings: MutableSet<RatingDto>? = null, payment: PaymentDto? = null): TripDto {
    val tripDto = TripDto(
        this.id, this.startTime, this.finishTime,
        this.tripStatus, this.price, this.distance
    )

    tripDto.startPoint = this.startPoint.toDto()
    tripDto.endPoint = this.endPoint.toDto()
    tripDto.driverDto = this.driverEntity.toDto()
    val ratingDtos = this.ratingEntities.map { it.toDto() }
        .takeIf { this.ratingEntities.isNotEmpty() } ?: ratings ?: emptySet()
    tripDto.ratings.addAll(ratingDtos)
    tripDto.passengerDto = this.passengerEntity.toDto()
    tripDto.paymentDto = this.paymentEntity?.toDto() ?: payment

    return tripDto
}