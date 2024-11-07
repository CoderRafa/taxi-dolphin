package com.example.taxi.dolphin.service

import com.example.taxi.dolphin.model.dto.CombinedRatingDto

interface CombinedRatingService {

    fun save(combinedRatingDto: CombinedRatingDto): CombinedRatingDto

    fun editBy(id: Long, combinedRatingDto: CombinedRatingDto): CombinedRatingDto
}