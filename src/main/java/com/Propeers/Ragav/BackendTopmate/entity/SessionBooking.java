package com.Propeers.Ragav.BackendTopmate.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SessionBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User mentee;

    @OneToOne
    private Slot slot;

    private LocalDateTime bookingTime;

    private String status; // e.g., CONFIRMED, CANCELLED

    private String paymentStatus; // e.g., PAID, PENDING

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getMentee() {
        return mentee;
    }

    public void setMentee(User mentee) {
        this.mentee = mentee;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    // Constructors

    public SessionBooking() {
    }

    public SessionBooking(User mentee, Slot slot, LocalDateTime bookingTime, String status, String paymentStatus) {
        this.mentee = mentee;
        this.slot = slot;
        this.bookingTime = bookingTime;
        this.status = status;
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "SessionBooking{" +
                "id=" + id +
                ", mentee=" + mentee +
                ", slot=" + slot +
                ", bookingTime=" + bookingTime +
                ", status='" + status + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                '}';
    }
}
