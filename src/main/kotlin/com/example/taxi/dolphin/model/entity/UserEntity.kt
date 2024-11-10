package com.example.taxi.dolphin.model.entity

import com.example.taxi.dolphin.model.dto.UserDto
import com.example.taxi.dolphin.model.enumerated.SexType
import com.example.taxi.dolphin.model.enumerated.Title
import jakarta.persistence.*

@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "who", discriminatorType = DiscriminatorType.STRING, length = 50)

open class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq")
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "first_name")
    open lateinit var firstName: String

    @Column(name = "last_name")
    open lateinit var lastName: String

    @Column(name = "age")
    open lateinit var age: String

    @Enumerated(EnumType.STRING)
    @Column(name = "sex")
    open lateinit var sex: SexType

    @Enumerated(EnumType.STRING)
    @Column(name = "title")
    open lateinit var title: Title

    @Column(name = "phone_number")
    open lateinit var phoneNumber: String

    @Column(name = "email")
    open lateinit var email: String

    @Column(name = "address")
    open lateinit var address: String

    @Column(name = "avatar_link")
    open lateinit var avatarLink: String

    @OneToOne(cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "account_entity_id")
    open lateinit var account: AccountEntity
}

fun UserEntity.toDto(): UserDto = UserDto(
    id, firstName, lastName, age,
    sex, title, phoneNumber, email,
    address, avatarLink, account.toDto()
)
