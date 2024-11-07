package com.example.taxi.dolphin.service

import com.example.taxi.dolphin.model.dto.UserDto

interface UserService {

    fun save(userDto: UserDto): UserDto

}