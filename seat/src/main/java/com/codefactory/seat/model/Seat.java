package com.codefactory.seat.model;

import jakarta.persistence.*;

@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(name = "SEQ", sequenceName = "SEAT_SEQ", allocationSize = 1)
    private Long id;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="seatClass")
    private SeatClass seatClass;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="seatStatus")
    private SeatStatus seatStatus;
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="seatLocation")
    private SeatLocation seatLocation;
    private String seatLabel;
    private String seatFee; // Recargo del asiento

    public Seat() {
    }

    public Seat(Long id,
                SeatClass seatClass,
                SeatStatus seatStatus,
                SeatLocation seatLocation,
                String seatLabel,
                String seatFee) {
        this.id = id;
        this.seatClass = seatClass;
        this.seatStatus = seatStatus;
        this.seatLocation = seatLocation;
        this.seatLabel = seatLabel;
        this.seatFee = seatFee;
    }

    public Seat(SeatClass seatClass,
                SeatStatus seatStatus,
                SeatLocation seatLocation,
                String seatLabel,
                String seatFee) {
        this.seatClass = seatClass;
        this.seatStatus = seatStatus;
        this.seatLocation = seatLocation;
        this.seatLabel = seatLabel;
        this.seatFee = seatFee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SeatClass getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(SeatClass seatClass) {
        this.seatClass = seatClass;
    }

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }

    public String getSeatFee() {
        return seatFee;
    }

    public void setSeatStatus(SeatStatus seatStatus) {
        this.seatStatus = seatStatus;
    }

    public SeatLocation getSeatLocation() {
        return seatLocation;
    }

    public void setSeatLocation(SeatLocation seatLocation) {
        this.seatLocation = seatLocation;
    }

    public String getSeatLabel() {
        return seatLabel;
    }

    public void setSeatLabel(String seatLabel) {
        this.seatLabel = seatLabel;
    }

    public void setSeatFee(String seatFee) {
        this.seatFee = seatFee;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", seatClass=" + seatClass +
                ", seatStatus=" + seatStatus +
                ", seatLocation='" + seatLocation + '\'' +
                ", seatLabel='" + seatLabel + '\'' +
                ", seatFee='" + seatFee + '\'' +
                '}';
    }
}
