package com.ticketgarage.garage.utility.helpers;

import com.ticketgarage.garage.model.Car;
import org.springframework.stereotype.Component;

@Component
public class TicketCreator {
    public String createTicket(Car car) {
        String newTicket = car.getColour() + car.getPlate() + car.getCreateTime();
        return newTicket;
    }
}
