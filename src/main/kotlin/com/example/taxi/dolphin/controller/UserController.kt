package com.example.taxi.dolphin.controller

import com.example.taxi.dolphin.model.dto.UserDto
import com.example.taxi.dolphin.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/td/v1/user")
class UserController(private val userService: UserService) {
    private val log = LoggerFactory.getLogger(UserController::class.java)

    @PostMapping
    fun create(@RequestBody userDto: UserDto): UserDto {
        log.debug("Create a user")
        return userService.save(userDto)
    }
}