package com.example.taxi.dolphin.service

import com.example.taxi.dolphin.model.dto.RatingDto

interface RatingService {

    fun save(ratingDto: RatingDto): RatingDto

    fun findBy(id: Long): RatingDto

}