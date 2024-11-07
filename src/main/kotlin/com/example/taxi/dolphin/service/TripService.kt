package com.example.taxi.dolphin.service

import com.example.taxi.dolphin.model.dto.TripDto

interface TripService {

    fun save(tripDto: TripDto): TripDto

    fun findBy(id: Long): TripDto
}