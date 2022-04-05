package com.ticketgarage.garage.model;

import com.ticketgarage.garage.utility.enums.CarTypes;
import com.ticketgarage.garage.utility.enums.Status;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @SequenceGenerator(name = "seq_car", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "plate", length = 20, unique = true)
    @NotNull(message = "Plate can not be empty!")
    private String plate;

    @Column(name = "colour", length = 100)
    @NotNull(message = "Colour can not be empty!")
    private String colour;

    @Enumerated
    private CarTypes type;

    @Enumerated
    private Status status;

    @Column(name = "ticket")
    private String ticket;

    @Column(name = "create_time", nullable = false)
    private LocalDateTime createTime;

    @OneToMany // a car can have many slots
    @JoinColumn(name = "car_garage_id")
    private List<Garage> garageList;
}
