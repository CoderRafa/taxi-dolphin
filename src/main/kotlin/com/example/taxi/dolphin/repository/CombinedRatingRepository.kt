package com.example.taxi.dolphin.repository

import com.example.taxi.dolphin.model.entity.CombinedRatingEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CombinedRatingRepository: CrudRepository<CombinedRatingEntity, Long>