package com.codefactory.seat.model;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Passenger")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(name = "SEQ", sequenceName = "PASSENGER_SEQ", allocationSize = 1)
    Long id;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "id_booking")
    private Booking booking;

    @OneToOne(mappedBy = "passenger", cascade = CascadeType.PERSIST)
    private SeatxPassenger seatxPassenger;

    private String name;
}
