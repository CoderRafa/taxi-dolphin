package com.example.taxi.dolphin.model.entity

import com.example.taxi.dolphin.model.dto.PaymentDto
import com.example.taxi.dolphin.model.enumerated.PaymentStatus
import jakarta.persistence.*
import org.hibernate.proxy.HibernateProxy
import java.time.LocalDateTime

@Entity
@Table(name = "payment")
open class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_seq")
    @SequenceGenerator(name = "payment_seq")
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "amount")
    open var amount: Double = 0.0

    @Column(name = "created_date")
    open lateinit var createdDate: LocalDateTime

    @Column(name = "confirmed_date")
    open lateinit var confirmedDate: LocalDateTime

    @Column(name = "purpose")
    open lateinit var purpose: String

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status")
    open lateinit var paymentStatus: PaymentStatus

    @ManyToOne(cascade = [CascadeType.REFRESH])
    @JoinColumn(name = "money_account_entity_id")
    open lateinit var moneyAccountEntity: MoneyAccountEntity

    final override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null) return false
        val oEffectiveClass =
            if (other is HibernateProxy) other.hibernateLazyInitializer.persistentClass else other.javaClass
        val thisEffectiveClass =
            if (this is HibernateProxy) this.hibernateLazyInitializer.persistentClass else this.javaClass
        if (thisEffectiveClass != oEffectiveClass) return false
        other as PaymentEntity

        return id != null && id == other.id
    }

    final override fun hashCode(): Int =
        if (this is HibernateProxy) this.hibernateLazyInitializer.persistentClass.hashCode() else javaClass.hashCode()
}

fun PaymentEntity.toDto():PaymentDto = PaymentDto(
    id, amount, createdDate, confirmedDate,
    purpose, paymentStatus, moneyAccountEntity.toDto()
)