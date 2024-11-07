package com.example.taxi.dolphin.model.dto

import com.example.taxi.dolphin.model.enumerated.AccountType
import java.io.Serializable
import java.time.LocalDate

/**
 * DTO for {@link com.example.taxi.dolphin.model.entity.AccountEntity}
 */
data class AccountDto(
    val id: Long? = null,
    val registrationDate: LocalDate? = null,
    val type: AccountType? = null,
    val rating: Double? = null
) : Serializable

