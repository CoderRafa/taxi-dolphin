package com.example.taxi.dolphin.model.entity

import com.example.taxi.dolphin.model.enumerated.Review
import jakarta.persistence.*
import org.hibernate.proxy.HibernateProxy

@Entity
@Table(name = "rating")
open  class RatingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rating_seq")
    @SequenceGenerator(name = "rating_seq")
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "by_whom")
    open var byWhom: Long? = null

    @Column(name = "for_whom")
    open var forWhom: Long? = null

    @Enumerated(EnumType.STRING)
    @Column(name = "given_rating")
    open var givenRating: Review? = null

    @Column(name = "comment")
    open var comment: String? = null

    @ManyToOne(cascade = [CascadeType.REFRESH])
    @JoinColumn(name = "trip_entity_id")
    open lateinit var tripEntity: TripEntity

    final override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null) return false
        val oEffectiveClass =
            if (other is HibernateProxy) other.hibernateLazyInitializer.persistentClass else other.javaClass
        val thisEffectiveClass =
            if (this is HibernateProxy) this.hibernateLazyInitializer.persistentClass else this.javaClass
        if (thisEffectiveClass != oEffectiveClass) return false
        other as RatingEntity

        return id != null && id == other.id
    }

    final override fun hashCode(): Int =
        if (this is HibernateProxy) this.hibernateLazyInitializer.persistentClass.hashCode() else javaClass.hashCode()
}