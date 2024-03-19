package com.codefactory.seat.model;

public class Seat {

    private int id;
    private String seatClass;
    private String seatStatus;
    private String seatLocation;
    private String seatLabel;

    public Seat() {
    }

    public Seat(int id, String seatClass, String seatStatus, String seatLocation, String seatLabel) {
        this.id = id;
        this.seatClass = seatClass;
        this.seatStatus = seatStatus;
        this.seatLocation = seatLocation;
        this.seatLabel = seatLabel;
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
