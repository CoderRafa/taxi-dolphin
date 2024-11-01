package com.example.taxi.dolphin.model.enumerated

enum class TripStatus {
    WAITING_FOR_DRIVER, GOING_TO_PICK_UP,
    ARRIVED_AT_PIC_UP_LOCATION,
    STARTED, WAITING_FOR_PASSENGER,
    PICKED_UP_PASSENGER, IN_PROGRESS,
    ARRIVED, COMPLETED
}