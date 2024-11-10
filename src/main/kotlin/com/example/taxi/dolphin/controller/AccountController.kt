package com.example.taxi.dolphin.controller

import com.example.taxi.dolphin.model.dto.AccountDto
import com.example.taxi.dolphin.service.AccountService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/td/v1/account")
class AccountController(private val accountService: AccountService) {
    private val log = LoggerFactory.getLogger(AccountController::class.java)

    @PostMapping
    fun create(@RequestBody accountDto: AccountDto): AccountDto {
        log.debug("Create an account")
        return accountService.save(accountDto)
    }
}