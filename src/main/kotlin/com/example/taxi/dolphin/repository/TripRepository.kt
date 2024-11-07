package com.example.taxi.dolphin.repository

import com.example.taxi.dolphin.model.entity.TripEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TripRepository: CrudRepository<TripEntity, Long>