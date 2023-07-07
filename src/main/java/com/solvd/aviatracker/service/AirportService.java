package com.solvd.aviatracker.service;

import com.solvd.aviatracker.domain.Airport;

public interface AirportService {

    Airport findNearestByLongitudeAndLatitude(Double latitude, Double longitude);

}
