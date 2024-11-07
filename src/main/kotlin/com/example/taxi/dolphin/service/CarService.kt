package com.example.taxi.dolphin.service

import com.example.taxi.dolphin.model.dto.CarDto

interface CarService {

    fun save(carDto: CarDto): CarDto

}