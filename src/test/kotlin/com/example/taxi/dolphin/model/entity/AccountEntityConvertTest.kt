package com.example.taxi.dolphin.model.entity

import com.example.taxi.dolphin.model.enumerated.SexType
import com.example.taxi.dolphin.model.enumerated.Title
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDate

class AccountEntityConvertTest {
    @Test
    fun `Happy pass - convert entity to dto`() {
        val accountEntity = AccountEntity().apply {
            this.id = 1L
            this.registrationDate = LocalDate.now()
            this.rating = 4.5
            this.user = UserEntity().apply {
                this.id = 1L
                this.firstName = "Andrei"
                this.lastName = "Sokolov"
                this.age = 28
                this.sex = SexType.MALE
                this.title = Title.MR
                this.phoneNumber = "+359888765432"
                this.email = "andrei@gmail.com"
                this.address = "First st. 1"
                this.avatarLink = "https://www.link.com"
            }
        }

        val accountDto = accountEntity.toDto()
        assertThat(accountDto).isNotNull
        assertThat(accountDto).hasNoNullFieldsOrProperties()
    }
}