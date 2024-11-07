package com.example.taxi.dolphin.model.entity

import com.example.taxi.dolphin.model.enumerated.AccountType
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "account")
open class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
    @SequenceGenerator(name = "account_seq")
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "registration_date")
    open lateinit var registrationDate: LocalDate

    @Enumerated
    @Column(name = "type")
    open lateinit var type: AccountType

    @Column(name = "rating")
    open var rating: Double? = null

    @OneToOne(mappedBy = "account", cascade = [CascadeType.ALL], orphanRemoval = true)
    open lateinit var user: UserEntity

    @OneToMany(mappedBy = "accountEntity", cascade = [CascadeType.ALL], orphanRemoval = true)
    open var moneyAccountEntities: MutableSet<MoneyAccountEntity> = mutableSetOf()
}