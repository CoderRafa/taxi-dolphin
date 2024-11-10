package com.example.taxi.dolphin.model.entity

import com.example.taxi.dolphin.model.dto.MoneyAccountDto
import com.example.taxi.dolphin.model.enumerated.Currency
import jakarta.persistence.*
import org.hibernate.proxy.HibernateProxy

@Entity
@Table(name = "money_account")
open class MoneyAccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "money_account_seq")
    @SequenceGenerator(name = "money_account_seq")
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "account_number")
    open lateinit var accountNumber: String

    @Enumerated(EnumType.STRING)
    @Column(name = "currency")
    open lateinit var currency: Currency

    @Column(name = "balance")
    open var balance: Double = 0.0

    @OneToMany(mappedBy = "moneyAccountEntity", cascade = [CascadeType.ALL], orphanRemoval = true)
    open var paymentEntities: MutableSet<PaymentEntity> = mutableSetOf()

    @ManyToOne(cascade = [CascadeType.REFRESH])
    @JoinColumn(name = "account_entity_id")
    open lateinit var accountEntity: AccountEntity

    final override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null) return false
        val oEffectiveClass =
            if (other is HibernateProxy) other.hibernateLazyInitializer.persistentClass else other.javaClass
        val thisEffectiveClass =
            if (this is HibernateProxy) this.hibernateLazyInitializer.persistentClass else this.javaClass
        if (thisEffectiveClass != oEffectiveClass) return false
        other as MoneyAccountEntity

        return id != null && id == other.id
    }

    final override fun hashCode(): Int =
        if (this is HibernateProxy) this.hibernateLazyInitializer.persistentClass.hashCode() else javaClass.hashCode()
}

fun MoneyAccountEntity.toDto(): MoneyAccountDto = MoneyAccountDto(
    id, accountNumber, currency,
    balance, paymentEntities.map { it.toDto() }.toMutableSet(),
    accountEntity.toDto()
)