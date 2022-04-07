package com.ticketgarage.garage.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ticketgarage.garage.model.Car;
import com.ticketgarage.garage.repository.GarageRepository;
import com.ticketgarage.garage.service.CarService;
import com.ticketgarage.garage.service.input.LeaveCar;
import com.ticketgarage.garage.utility.enums.CarTypes;
import com.ticketgarage.garage.utility.enums.Status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CarController.class)
class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GarageRepository garageRepository;

    @MockBean
    private CarService carService;

    @Test
    public void parkCarControllerTest() throws Exception {
        Car car = new Car();
        car.setPlate("34-SO-1932");
        car.setColour("Red");
        car.setType(CarTypes.TRUCK);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String carString = objectMapper.writeValueAsString(car);
        mockMvc.perform(post("/api/cars/park").content(carString).contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isCreated());
    }

    @Test
    public void leaveCarControllerTest() throws Exception {
        LeaveCar leaveCar = new LeaveCar();
        leaveCar.setTicket("1234");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String leaveCarString = objectMapper.writeValueAsString(leaveCar);
        mockMvc.perform(post("/api/cars/leave").content(leaveCarString).contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void statusCarControllerTest() throws Exception {
        mockMvc.perform(get("/api/cars/status").contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
    }

}