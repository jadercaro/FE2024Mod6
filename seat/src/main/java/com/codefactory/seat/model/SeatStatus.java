package com.codefactory.seat.model;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class SeatStatus {
    @Id
    private Long id;
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToMany(cascade=CascadeType.PERSIST, mappedBy="seatStatus")
    private List<Seat> seats;

    public SeatStatus() {
    }

    public SeatStatus(Long id, Status status) {
        this.id = id;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "SeatStatus{" +
                "id=" + id +
                ", status=" + status +
                ", seats=" + seats +
                '}';
    }

    public enum Status {
        AVAILABLE, OCCUPIED
    }
}
