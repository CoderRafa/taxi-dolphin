package com.example.taxi.dolphin.repository

import com.example.taxi.dolphin.model.entity.AccountEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository: CrudRepository<AccountEntity, Long>