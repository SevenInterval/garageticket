package com.ticketgarage.garage.utility.validation;

import com.ticketgarage.garage.model.Garage;
import com.ticketgarage.garage.utility.enums.CarTypes;
import com.ticketgarage.garage.utility.exception.CarException;
import com.ticketgarage.garage.utility.helpers.SlotHelper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarValidator implements Validator {

    private final SlotHelper slotHelper;

    public CarValidator(SlotHelper slotHelper) {
        this.slotHelper = slotHelper;
    }

    public void checkSlots(List<Garage> garageList, CarTypes carType) throws CarException {
        if(slotHelper.availableSlots(garageList, carType).size() == 0) {
            throw new CarException("Garage is full!");
        }
    }
}
