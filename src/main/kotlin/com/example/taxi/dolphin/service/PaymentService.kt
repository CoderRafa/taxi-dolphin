package com.example.taxi.dolphin.service

import com.example.taxi.dolphin.model.dto.PaymentDto

interface PaymentService {

    fun save(paymentDto: PaymentDto): PaymentDto

}