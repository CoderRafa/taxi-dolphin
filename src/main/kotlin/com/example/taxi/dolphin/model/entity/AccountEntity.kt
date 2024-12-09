package com.example.taxi.dolphin.model.entity

import com.example.taxi.dolphin.model.dto.AccountDto
import com.example.taxi.dolphin.model.dto.MoneyAccountDto
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

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    open var type: AccountType = AccountType.BASIC

    @Column(name = "rating")
    open var rating: Double? = null

    @OneToOne(mappedBy = "account", cascade = [CascadeType.ALL], orphanRemoval = true)
    open lateinit var user: UserEntity

    @OneToMany(mappedBy = "accountEntity", cascade = [CascadeType.ALL], orphanRemoval = true)
    open var moneyAccountEntities: MutableSet<MoneyAccountEntity> = mutableSetOf()
}

fun AccountEntity.toDto(moneyAccounts: MutableSet<MoneyAccountDto>? = null): AccountDto {
    val accountDto = AccountDto(this.id, this.registrationDate, this.type, this.rating)
    val moneyAccountDtos = this.moneyAccountEntities.map { it.toDto() } // TODO: Check MoneyAccountEntity.toDto()
        .takeIf { this.moneyAccountEntities.isNotEmpty() } ?: moneyAccounts ?: emptySet()
    accountDto.moneyAccounts.addAll(moneyAccountDtos) // Q. Shouldn't we make it to MutableSet()\
    accountDto.user = this.user.toDto() // TODO: Check UserEntity.toDto()
    return accountDto
}

