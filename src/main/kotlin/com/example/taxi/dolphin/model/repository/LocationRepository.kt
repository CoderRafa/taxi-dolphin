package com.example.taxi.dolphin.model.repository

import com.example.taxi.dolphin.model.entity.LocationEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface LocationRepository: CrudRepository<LocationEntity, Long>