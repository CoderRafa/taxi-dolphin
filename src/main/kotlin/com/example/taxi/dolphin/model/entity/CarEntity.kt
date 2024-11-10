package com.example.taxi.dolphin.model.entity

import com.example.taxi.dolphin.model.dto.CarDto
import com.example.taxi.dolphin.model.enumerated.CarCategory
import com.example.taxi.dolphin.model.enumerated.CarColor
import jakarta.persistence.*
import org.hibernate.proxy.HibernateProxy

@Entity
@Table(name = "car")
open class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_seq")
    @SequenceGenerator(name = "car_seq")
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "make")
    open lateinit var make: String

    @Column(name = "model")
    open lateinit var model: String

    @Enumerated(EnumType.STRING)
    @Column(name = "color")
    open lateinit var color: CarColor

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    open lateinit var category: CarCategory

    @Column(name = "licence_plate_number", length = 10)
    open lateinit var licencePlateNumber: String

    @OneToOne(cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "location_entity_id")
    open lateinit var locationEntity: LocationEntity

    @ManyToOne(cascade = [CascadeType.REFRESH])
    @JoinColumn(name = "driver_entity_id")
    open lateinit var driverEntity: DriverEntity

    final override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null) return false
        val oEffectiveClass =
            if (other is HibernateProxy) other.hibernateLazyInitializer.persistentClass else other.javaClass
        val thisEffectiveClass =
            if (this is HibernateProxy) this.hibernateLazyInitializer.persistentClass else this.javaClass
        if (thisEffectiveClass != oEffectiveClass) return false
        other as CarEntity

        return id != null && id == other.id
    }

    final override fun hashCode(): Int =
        if (this is HibernateProxy) this.hibernateLazyInitializer.persistentClass.hashCode() else javaClass.hashCode()
}

fun CarEntity.toDto(): CarDto = CarDto(
    id, make, model, color,
    category, licencePlateNumber,
    locationEntity.toDto(), driverEntity.toDto()
)