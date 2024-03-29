package com.codefactory.seat.model;

public class Seat {

    private int id;
    private String seatClass;
    private String seatStatus;
    private String seatLocation;
    private String seatLabel;
    private String seatFee; // Recargo del asiento

    public Seat() {
    }

    public Seat(int id, String seatClass, String seatStatus, String seatLocation, String seatLabel, String seatFee) {
        this.id = id;
        this.seatClass = seatClass;
        this.seatStatus = seatStatus;
        this.seatLocation = seatLocation;
        this.seatLabel = seatLabel;
        this.seatFee = seatFee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
    }

    public String getSeatStatus() {
        return seatStatus;
    }

    public String getSeatFee() {
        return seatFee;
    }

    public void setSeatStatus(String seatStatus) {
        this.seatStatus = seatStatus;
    }

    public String getSeatLocation() {
        return seatLocation;
    }

    public void setSeatLocation(String seatLocation) {
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
                ", seatClass='" + seatClass + '\'' +
                ", seatStatus='" + seatStatus + '\'' +
                ", seatLocation='" + seatLocation + '\'' +
                ", seatLabel='" + seatLabel + '\'' +
                '}';
    }
}
