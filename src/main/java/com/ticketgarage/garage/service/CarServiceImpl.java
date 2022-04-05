package com.ticketgarage.garage.service;

import com.ticketgarage.garage.model.Car;
import com.ticketgarage.garage.model.Garage;
import com.ticketgarage.garage.repository.CarRepository;
import com.ticketgarage.garage.repository.GarageRepository;
import com.ticketgarage.garage.utility.enums.Status;
import com.ticketgarage.garage.utility.exception.CarException;
import com.ticketgarage.garage.utility.helpers.SlotHelper;
import com.ticketgarage.garage.utility.helpers.TicketCreator;
import com.ticketgarage.garage.utility.validation.CarValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final GarageRepository garageRepository;
    private final CarValidator carValidator;
    private final TicketCreator ticketCreator;
    private final SlotHelper slotHelper;

    public CarServiceImpl(CarRepository carRepository, GarageRepository garageRepository, CarValidator carValidator, TicketCreator ticketCreator, SlotHelper slotHelper) {
        this.carRepository = carRepository;
        this.garageRepository = garageRepository;
        this.carValidator = carValidator;
        this.ticketCreator = ticketCreator;
        this.slotHelper = slotHelper;
    }

    @Override
    @Transactional
    public String parkCar(Car car) throws CarException {
        List<Garage> emptyGarageList = garageRepository.findCarGarageIdIsNull();
        carValidator.checkSlots(emptyGarageList, car.getType());
        car.setStatus(Status.INSIDE);
        car.setCreateTime(LocalDateTime.now());
        car.setTicket(ticketCreator.createTicket(car));
        List<Garage> slotsForCar = slotHelper.availableSlots(emptyGarageList, car.getType());
        car.setGarageList(slotsForCar);
        final Car carDb = carRepository.save(car);
        for (Garage garageDb : slotsForCar) {
            garageDb.setCar(carDb);
            garageRepository.save(garageDb);
        }
        String parkMessage = "Allocated " + slotHelper.slotCount(car.getType()) + " slot.";
        return parkMessage;
    }

    @Override
    public void leaveCar(String ticket) {

    }

    @Override
    public List<String> statusCars() throws CarException {
        List<Car> carList = carRepository.findCarsByStatus(Status.INSIDE);
        List<String> carMessageList = new ArrayList<>();
        carList.forEach(item -> {
            String responseMessage = item.getPlate() + " " + item.getColour() + " " + item.getGarageList();
            carMessageList.add(responseMessage);
        });
        return carMessageList;
    }
}
