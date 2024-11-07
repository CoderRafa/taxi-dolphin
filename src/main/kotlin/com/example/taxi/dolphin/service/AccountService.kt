package com.example.taxi.dolphin.service

import com.example.taxi.dolphin.model.dto.AccountDto

interface AccountService {

    fun save(accountDto: AccountDto): AccountDto

}