package com.ticketgarage.garage.repository;

import com.ticketgarage.garage.model.Car;
import com.ticketgarage.garage.utility.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findCarsByStatus(Status status);
}
