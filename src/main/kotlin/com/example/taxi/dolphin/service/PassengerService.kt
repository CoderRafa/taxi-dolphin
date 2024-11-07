package com.example.taxi.dolphin.service

import com.example.taxi.dolphin.model.dto.PassengerDto

interface PassengerService {

    fun save(passengerDto: PassengerDto): PassengerDto

}