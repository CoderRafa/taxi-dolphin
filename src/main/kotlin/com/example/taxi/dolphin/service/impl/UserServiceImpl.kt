package com.example.taxi.dolphin.service.impl

import com.example.taxi.dolphin.model.dto.UserDto
import com.example.taxi.dolphin.model.dto.toEntity
import com.example.taxi.dolphin.model.entity.toDto
import com.example.taxi.dolphin.repository.UserRepository
import com.example.taxi.dolphin.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(private val userRepository: UserRepository): UserService {

    private val log = LoggerFactory.getLogger(UserServiceImpl::class.java)
    override fun save(userDto: UserDto): UserDto {
        log.debug("Create a new user with name ", userDto.firstName)
        return userRepository.save(userDto.toEntity()).toDto()
    }
}