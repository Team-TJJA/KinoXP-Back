package com.example.kinoxpback.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="reservations")
public class Reservation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reservation_id")
    private int reservationID;

    @Column(name="customer_name")
    private String customerName;

    @Column(name="customer_email")
    private String customerEmail;

    @Column(name="total_price")
    private double price;

    @CreationTimestamp
    private LocalDateTime timestamp;

    @ManyToMany
    @JoinTable(name = "reservation_taken_seats", joinColumns = @JoinColumn(name = "reservation_id"), inverseJoinColumns = @JoinColumn(name = "seat_id"))
    private Set<Seat> takenSeats;

    @ManyToOne
    @JoinColumn(name="showing_id_fk", referencedColumnName = "showing_id")
    private Showing showing;


    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Set<Seat> getTakenSeats() {
        return takenSeats;
    }

    public void setTakenSeats(Set<Seat> takenSeats) {
        this.takenSeats = takenSeats;
    }

    public Showing getShowing() {
        return showing;
    }

    public void setShowing(Showing showing) {
        this.showing = showing;
    }
}
