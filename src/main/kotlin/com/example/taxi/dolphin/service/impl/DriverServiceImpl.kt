package com.example.taxi.dolphin.service.impl

import com.example.taxi.dolphin.model.dto.DriverDto
import com.example.taxi.dolphin.model.dto.RatingDto
import com.example.taxi.dolphin.model.dto.toEntity
import com.example.taxi.dolphin.model.entity.AccountEntity
import com.example.taxi.dolphin.model.entity.toDto
import com.example.taxi.dolphin.repository.DriverRepository
import com.example.taxi.dolphin.service.DriverService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class DriverServiceImpl(private val driverRepository: DriverRepository): DriverService {

    private val log = LoggerFactory.getLogger(DriverServiceImpl::class.java)
    override fun save(driverDto: DriverDto): DriverDto {
        log.debug("Create a new driver with name {}", driverDto.firstName)
        val driverEntity = driverDto.toEntity()
        val accountEntity = AccountEntity().apply { this.user = driverEntity }
        driverEntity.account = accountEntity
        return driverRepository.save(driverEntity).toDto()
    }

    override fun setAvailability(id: Long): DriverDto {
        TODO("Not yet implemented")
    }

    override fun seeNumberOfTripsH(driverId: Long): Int {
        TODO("Not yet implemented")
    }

    override fun seeRatingsGiven(driverId: Long): List<RatingDto> {
        TODO("Not yet implemented")
    }

    override fun checkEarnings(driverId: Long): Double {
        TODO("Not yet implemented")
    }

    override fun checkOwnRating(driverId: Long): Double {
        TODO("Not yet implemented")
    }
}