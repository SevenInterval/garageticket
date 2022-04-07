package com.ticketgarage.garage.service;

import com.ticketgarage.garage.model.Car;
import com.ticketgarage.garage.utility.exception.CarException;

import java.util.List;

public interface CarService {

    String parkCar(Car car) throws CarException;
    String leaveCar(String ticket) throws CarException;
    List<String> statusCars() throws CarException;
}
