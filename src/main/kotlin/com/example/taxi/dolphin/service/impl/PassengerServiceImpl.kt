package com.example.taxi.dolphin.service.impl

import com.example.taxi.dolphin.model.dto.PassengerDto
import com.example.taxi.dolphin.model.dto.RatingDto
import com.example.taxi.dolphin.model.dto.TripDto
import com.example.taxi.dolphin.model.dto.toEntity
import com.example.taxi.dolphin.model.entity.toDto
import com.example.taxi.dolphin.repository.PassengerRepository
import com.example.taxi.dolphin.service.PassengerService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class PassengerServiceImpl(private val passengerRepository: PassengerRepository): PassengerService {

    private val log = LoggerFactory.getLogger(PassengerServiceImpl::class.java)

    override fun save(passengerDto: PassengerDto): PassengerDto {
        log.debug("Create a new passenger with name {}",passengerDto.firstName)
        return passengerRepository.save(passengerDto.toEntity()).toDto()
    }

    override fun seeTripHistory(passengerId: Long): List<TripDto> {
        TODO("Not yet implemented")
    }

    override fun seeRatingsGiven(passengerId: Long): List<RatingDto> {
        TODO("Not yet implemented")
    }

    override fun checkBalance(passengerId: Long): Double {
        TODO("Not yet implemented")
    }

    override fun checkSpendingInPeriod(passengerId: Long, startDate: LocalDate, endDate: LocalDate): Double {
        TODO("Not yet implemented")
    }
}