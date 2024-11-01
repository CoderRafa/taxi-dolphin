package com.example.taxi.dolphin.model.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "location")
open class LocationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location_seq")
    @SequenceGenerator(name = "location_seq")
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "latitude")
    open var latitude: Double = 0.0

    @Column(name = "longitude")
    open var longitude: Double = 0.0

    @Column(name = "time")
    open lateinit var time: LocalDateTime
}