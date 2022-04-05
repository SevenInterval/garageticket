package com.ticketgarage.garage.service.output;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ticketgarage.garage.utility.enums.ResponseStatusType;

public class BaseResponse {
    private ResponseStatusType responseStatus;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorMessage;

    public BaseResponse(ResponseStatusType responseStatus, String errorMessage) {
        this.responseStatus = responseStatus;
        this.errorMessage = errorMessage;
    }

    public BaseResponse(ResponseStatusType responseStatus) {
        this.responseStatus = responseStatus;
    }

    public ResponseStatusType getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatusType responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
