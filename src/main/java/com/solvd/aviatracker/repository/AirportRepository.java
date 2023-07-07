package com.solvd.aviatracker.repository;

import com.solvd.aviatracker.domain.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AirportRepository extends JpaRepository<Airport, String> {

    @Query(value = "SELECT * from (" +
            "SELECT  *,( 3959 * acos( cos( radians( :lng ) ) * cos( radians( latitude ) )" +
            " * cos( radians( longitude ) - radians( :lat ) ) + sin( radians( :lng ) )" +
            " * sin( radians( latitude ) ) ) ) AS distance " +
            "FROM aviatracker_schema.airports" +
            ") al\n" +
            "ORDER BY distance\n" +
            "LIMIT 1;", countQuery = "SELECT 1", nativeQuery = true)
    Airport findNearestByLongitudeAndLatitude(@Param("lat") double latitude, @Param("lng") double longitude);

}
