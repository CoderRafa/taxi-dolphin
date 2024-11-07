package com.example.taxi.dolphin.repository

import com.example.taxi.dolphin.model.entity.PassengerEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PassengerRepository: CrudRepository<PassengerEntity, Long>