package com.example.taxi.dolphin.model.repository

import com.example.taxi.dolphin.model.entity.DriverEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface DriverRepository: CrudRepository<DriverEntity, Long>