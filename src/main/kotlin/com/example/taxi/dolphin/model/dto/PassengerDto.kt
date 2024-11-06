package com.example.taxi.dolphin.model.dto

import com.example.taxi.dolphin.model.enumerated.SexType
import com.example.taxi.dolphin.model.enumerated.Title
import java.io.Serializable

/**
 * DTO for {@link com.example.taxi.dolphin.model.entity.PassengerEntity}
 */
data class PassengerDto(
    val id: Long? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val age: String? = null,
    val sex: SexType? = null,
    val title: Title? = null,
    val phoneNumber: String? = null,
    val email: String? = null,
    val address: String? = null,
    val avatarLink: String? = null,
    val miles: Double? = null,
    val averageTip: Double? = null,
    val generalComment: String? = null,
    val favoriteRadioStation: String? = null,
    val combinedRatingEntity: CombinedRatingDto? = null
) : Serializable