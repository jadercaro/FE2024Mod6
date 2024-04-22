package com.codefactory.seat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer",
        "handler"})
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(name = "SEQ", sequenceName = "FLIGHT_SEQ", allocationSize = 1)
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "flight", cascade = CascadeType.PERSIST)
    private List<Seat> seatList = new ArrayList<>();

    @OneToMany(mappedBy = "flight", cascade = CascadeType.PERSIST)
    private List<Booking> bookingList;
}
