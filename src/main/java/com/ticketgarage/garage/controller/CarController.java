package com.ticketgarage.garage.controller;

import com.ticketgarage.garage.model.Car;
import com.ticketgarage.garage.service.CarService;
import com.ticketgarage.garage.service.input.LeaveCar;
import com.ticketgarage.garage.service.output.BaseResponse;
import com.ticketgarage.garage.service.output.ParkResponse;
import com.ticketgarage.garage.service.output.StatusResponse;
import com.ticketgarage.garage.utility.enums.ResponseStatusType;
import com.ticketgarage.garage.utility.exception.CarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping(value = "/park", produces = "application/json")
    public ResponseEntity<BaseResponse> parkCar(@Valid @RequestBody Car car) {
        try {
            String parkMessage = carService.parkCar(car);
            return new ResponseEntity<>(new ParkResponse(ResponseStatusType.SUCCESS, parkMessage), HttpStatus.CREATED);
        } catch (CarException e) {
            return new ResponseEntity<>(new BaseResponse(ResponseStatusType.FAIL,e.getErrorMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/leave", produces = "application/json")
    public ResponseEntity<BaseResponse> leaveCar(@Valid @RequestBody LeaveCar leaveCar) {
        try {
            String leaveMessage = carService.leaveCar(leaveCar.getTicket());
            return new ResponseEntity<>(new ParkResponse(ResponseStatusType.SUCCESS, leaveMessage), HttpStatus.OK);
        } catch (CarException e) {
            return new ResponseEntity<>(new BaseResponse(ResponseStatusType.FAIL, e.getErrorMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/status", produces = "application/json")
    public ResponseEntity<BaseResponse> statusCars() throws CarException {
        return new ResponseEntity<>(new StatusResponse(ResponseStatusType.SUCCESS, carService.statusCars()), HttpStatus.OK);
    }
}
