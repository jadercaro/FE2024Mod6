package com.codefactory.seat.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class SeatClass {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(name = "SEQ", sequenceName = "SEAT_SEQ", allocationSize = 1)
    private Long seatClassId;
    private String seatClassType;

    @OneToMany(cascade=CascadeType.PERSIST, mappedBy="seatClass")
    private List<Seat> seats;

    public SeatClass() {
    }

    public SeatClass(String seatClassType) {
        this.seatClassType = seatClassType;
    }

    public SeatClass(Long id, String seatClassType) {
        this.seatClassId = id;
        this.seatClassType = seatClassType;
    }

    public Long getSeatClassId() {
        return seatClassId;
    }

    public void setSeatClassId(Long id) {
        this.seatClassId = id;
    }

    public String getSeatClassType() {
        return seatClassType;
    }

    public void setSeatClassType(String typeClass) {
        this.seatClassType = typeClass;
    }

    @Override
    public String toString() {
        return "SeatClass{" +
                "seatClassId=" + seatClassId +
                ", typeClass='" + seatClassType + '\'' +
                ", seats=" + seats +
                '}';
    }
}
