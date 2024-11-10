package com.example.taxi.dolphin.service

import com.example.taxi.dolphin.model.dto.LocationDto

interface LocationService {

    fun save(locationDto: LocationDto): LocationDto

}