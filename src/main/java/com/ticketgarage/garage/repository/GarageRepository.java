package com.ticketgarage.garage.repository;

import com.ticketgarage.garage.model.Car;
import com.ticketgarage.garage.model.Garage;
import com.ticketgarage.garage.utility.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GarageRepository extends JpaRepository<Garage, Long> {
    @Query("SELECT g FROM Garage g WHERE g.car is null")
    List<Garage> findCarGarageIdIsNull();

    List<Garage> findByCar_TicketAndCar_Status(String ticket, Status status);
}
