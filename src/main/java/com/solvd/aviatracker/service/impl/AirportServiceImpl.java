package com.solvd.aviatracker.service.impl;

import com.solvd.aviatracker.domain.Airport;
import com.solvd.aviatracker.repository.AirportRepository;
import com.solvd.aviatracker.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AirportServiceImpl implements AirportService {

    private final AirportRepository airportRepository;

    @Override
    @Transactional(readOnly = true)
    public Airport findNearestByLongitudeAndLatitude(final Double latitude,
                                                     final Double longitude) {
        return airportRepository.findNearestByLongitudeAndLatitude(
                latitude, longitude);
    }

}
