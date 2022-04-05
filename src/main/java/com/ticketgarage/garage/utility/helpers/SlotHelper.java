package com.ticketgarage.garage.utility.helpers;

import com.ticketgarage.garage.model.Garage;
import com.ticketgarage.garage.utility.enums.CarTypes;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SlotHelper {
    public List<Garage> availableSlots(List<Garage> garageList, CarTypes carType) {
        List<Garage> availableGarageList = new ArrayList<>();
        // Car need just 1 slot
        if (carType == CarTypes.CAR) {
            if(garageList.size() > 0) {
                availableGarageList.add(garageList.get(0));
            }
        }
        // Jeep need 2 slots
        else if(carType == CarTypes.JEEP) {
            if(garageList.size() > 1) {
                for(int i=0; i<garageList.size(); i++) {
                    int slotName1 = Integer.parseInt(garageList.get(i).getSlot());
                    int slotName2 = Integer.parseInt(garageList.get(i+1).getSlot());
                    if(slotName1 + 1 == slotName2) {
                        availableGarageList.add(garageList.get(i));
                        availableGarageList.add(garageList.get(i+1));
                        break;
                    }
                }
            }
        }
        // Truck need 4 slots
        else if(carType == CarTypes.TRUCK) {
            if(garageList.size() > 3) {
                for(int i=0; i<garageList.size(); i++) {
                    int slotName1 = Integer.parseInt(garageList.get(i).getSlot());
                    int slotName2 = Integer.parseInt(garageList.get(i+1).getSlot());
                    int slotName3 = Integer.parseInt(garageList.get(i+2).getSlot());
                    int slotName4 = Integer.parseInt(garageList.get(i+3).getSlot());
                    if((slotName1 + 1 == slotName2) && (slotName2 + 1 == slotName3) && (slotName3 + 1 == slotName4)) {
                        availableGarageList.add(garageList.get(i));
                        availableGarageList.add(garageList.get(i+1));
                        availableGarageList.add(garageList.get(i+2));
                        availableGarageList.add(garageList.get(i+3));
                        break;
                    }
                }
            }
        }
        return availableGarageList;
    }

    public int slotCount(CarTypes carType) {
        if(carType == CarTypes.CAR) {
            return 1;
        } else if(carType == CarTypes.JEEP) {
            return 2;
        } else if(carType == CarTypes.TRUCK) {
            return 4;
        }
        return 0;
    }
}
