package com.example.taxi.dolphin.model.entity

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

fun TripEntity.toDto(): TripDto = TripDto(
    id, startTime, finishTime,
    startPoint.toDto(), endPoint.toDto(),
    tripStatus, price, distance,
    driverEntity.toDto(), ratingEntities.map { it.toDto() },
    passengerEntity.toDto()
)