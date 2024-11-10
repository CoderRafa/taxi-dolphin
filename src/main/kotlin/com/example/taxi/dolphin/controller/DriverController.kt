package com.example.taxi.dolphin.controller

import com.example.taxi.dolphin.model.dto.DriverDto
import com.example.taxi.dolphin.service.DriverService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/td/v1/driver")
class DriverController(private val driverService: DriverService) {
    private val log = LoggerFactory.getLogger(DriverController::class.java)

    @PostMapping
    fun create(@RequestBody driverDto: DriverDto): DriverDto {
        log.debug("Create a driver")
        return driverService.save(driverDto)
    }
}