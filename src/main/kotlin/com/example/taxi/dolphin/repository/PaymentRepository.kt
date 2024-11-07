package com.example.taxi.dolphin.repository

import com.example.taxi.dolphin.model.entity.PaymentEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PaymentRepository: CrudRepository<PaymentEntity, Long>