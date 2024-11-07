package com.example.taxi.dolphin.repository

import com.example.taxi.dolphin.model.entity.CarEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CarRepository: CrudRepository<CarEntity, Long>