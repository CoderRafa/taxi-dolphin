package com.example.taxi.dolphin.service

import com.example.taxi.dolphin.model.dto.MoneyAccountDto

interface MoneyAccountService {

    fun save(moneyAccountDto: MoneyAccountDto): MoneyAccountDto

    fun findBy(id: Long): MoneyAccountDto

}