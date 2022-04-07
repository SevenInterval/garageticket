package com.ticketgarage.garage.utility.helpers;

import com.ticketgarage.garage.model.Car;
import org.springframework.stereotype.Component;

@Component
public class TicketCreator {
    public String createTicket(Car car) {
        String color = car.getColour();
        String plate = car.getPlate().substring(0,2) + car.getPlate().substring(3,5) + car.getPlate().substring(6,10);
        String time = car.getCreateTime().toString().substring(0,4) + car.getCreateTime().toString().substring(5,7) + car.getCreateTime().toString().substring(8,10)
                + car.getCreateTime().toString().substring(11,13) + car.getCreateTime().toString().substring(14,16);
        return time + color + plate;
    }
}
