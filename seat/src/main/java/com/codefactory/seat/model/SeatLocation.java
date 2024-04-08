package com.codefactory.seat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer",
        "handler"})
@Entity
public class SeatLocation {
    @Id
    private Long id;
    @Enumerated(EnumType.STRING)
    private Location location;

    @JsonIgnore
    @OneToMany(cascade=CascadeType.PERSIST, mappedBy="seatLocation")
    private List<Seat> seats;

    public SeatLocation() {
    }

    public SeatLocation(Long id, Location location) {
        this.id = id;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public enum Location {
        WINDOW, CENTER, AISLE
    }


}
