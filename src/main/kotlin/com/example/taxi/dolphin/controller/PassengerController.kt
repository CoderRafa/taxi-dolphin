package com.example.taxi.dolphin.controller

import com.example.taxi.dolphin.model.dto.PassengerDto
import com.example.taxi.dolphin.service.PassengerService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/td/v1/passenger")
class PassengerController(private val passengerService: PassengerService) {
    private val log = LoggerFactory.getLogger(PassengerController::class.java)

    @PostMapping
    fun create(@RequestBody passengerDto: PassengerDto): PassengerDto {
        log.debug("Create a passenger")
        return passengerService.save(passengerDto)
    }
}