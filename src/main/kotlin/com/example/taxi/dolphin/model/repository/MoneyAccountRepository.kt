package com.example.taxi.dolphin.model.repository

import com.example.taxi.dolphin.model.entity.MoneyAccountEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MoneyAccountRepository: CrudRepository<MoneyAccountEntity, Long>