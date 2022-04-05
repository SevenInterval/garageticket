package com.ticketgarage.garage.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "garage")
public class Garage {
    @Id
    @SequenceGenerator(name = "seq_garage", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 2, name = "slot")
    private String slot;

    @ManyToOne
    @JoinColumn(name = "car_garage_id")
    private Car car;
}
