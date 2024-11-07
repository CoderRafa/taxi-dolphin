package com.example.taxi.dolphin.repository

import com.example.taxi.dolphin.model.entity.RatingEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RatingRepository: CrudRepository<RatingEntity, Long>