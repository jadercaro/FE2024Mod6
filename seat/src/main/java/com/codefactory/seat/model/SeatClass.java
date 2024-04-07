package com.codefactory.seat.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class SeatClass {
    @Id
    private Long id;
    private Type type;

    @OneToMany(cascade=CascadeType.PERSIST, mappedBy="seatClass")
    private List<Seat> seats;

    public SeatClass() {
    }

    public SeatClass(Long id, Type type) {
        this.id = id;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "SeatClass{" +
                "id=" + id +
                ", type=" + type +
                ", seats=" + seats +
                '}';
    }

    public enum Type {
        TOURIST, FIRST_CLASS, EXECUTIVE
    }
}
