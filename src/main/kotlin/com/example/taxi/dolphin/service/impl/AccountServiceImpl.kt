package com.example.taxi.dolphin.service.impl

import com.example.taxi.dolphin.model.dto.AccountDto
import com.example.taxi.dolphin.model.dto.toEntity
import com.example.taxi.dolphin.model.entity.toDto
import com.example.taxi.dolphin.repository.AccountRepository
import com.example.taxi.dolphin.service.AccountService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class AccountServiceImpl(private val accountRepository: AccountRepository): AccountService {

    private val log = LoggerFactory.getLogger(AccountServiceImpl::class.java)
    override fun save(accountDto: AccountDto): AccountDto {
        log.debug("Create account with type {}", accountDto.type)
        return accountRepository.save(accountDto.toEntity()).toDto()
    }
}