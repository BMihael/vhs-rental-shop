package com.example.vhsshop.repository;

import com.example.vhsshop.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {

    @Query(value = "SELECT * FROM rental WHERE CURRENT_DATE() BETWEEN orderDate AND endDate AND vhsid = ?1", nativeQuery = true)
    Optional<Rental> findRentalUnavailableOnDay(Long id);

    @Query(value = "SELECT * FROM rental WHERE userid = ?1", nativeQuery = true)
    List<Rental> findRentalByUserId(Long id);

    @Query(value = "SELECT DATEDIFF(day, CURRENT_DATE(), rental.enddate) FROM rental where vhsid = ?1", nativeQuery = true)
    Integer getFeeDays(Long id);
}