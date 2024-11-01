package com.example.taxi.dolphin.model.repository

import com.example.taxi.dolphin.model.entity.UserEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository: CrudRepository<AccountRepository, Long>