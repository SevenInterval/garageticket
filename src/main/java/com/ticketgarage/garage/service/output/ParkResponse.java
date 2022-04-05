package com.ticketgarage.garage.service.output;

import com.ticketgarage.garage.utility.enums.ResponseStatusType;

public class ParkResponse extends BaseResponse {

    private String parkMessage;

    public ParkResponse(ResponseStatusType responseStatus, String parkMessage) {
        super(responseStatus);
        this.parkMessage = parkMessage;
    }

    public ParkResponse(String errorMessage, ResponseStatusType responseStatus) {
        super(responseStatus, errorMessage);
    }

    public String getParkMessage() {
        return parkMessage;
    }

    public void setParkMessage(String parkMessage) {
        this.parkMessage = parkMessage;
    }
}
