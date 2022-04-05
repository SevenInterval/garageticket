package com.ticketgarage.garage.service.output;

import com.ticketgarage.garage.utility.enums.ResponseStatusType;

import java.util.List;

public class StatusResponse extends BaseResponse {
    private List<String> statusCarList;

    public StatusResponse(ResponseStatusType responseStatus, List<String> statusCarList) {
        super(responseStatus);
        this.statusCarList = statusCarList;
    }

    public List<String> getStatusCarList() {
        return statusCarList;
    }

    public void setStatusCarList(List<String> statusCarList) {
        this.statusCarList = statusCarList;
    }
}
