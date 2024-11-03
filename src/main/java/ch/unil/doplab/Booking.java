package ch.unil.doplab;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class Booking {
    private UUID id;
    private Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Guest guest;
    private Payment payment;

    public Booking(Room room, LocalDate checkInDate, LocalDate checkOutDate, Guest guest) {
        this.id = UUID.randomUUID();
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.guest = guest;
        this.payment = new Payment(0);
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public Room getRoom() { return room; }
    public void setRoom(Room room) { this.room = room; }
    public LocalDate getCheckInDate() { return checkInDate; }
    public void setCheckInDate(LocalDate checkInDate) { this.checkInDate = checkInDate; }
    public LocalDate getCheckOutDate() { return checkOutDate; }
    public void setCheckOutDate(LocalDate checkOutDate) { this.checkOutDate = checkOutDate; }
    public Guest getGuest() { return guest; }
    public void setGuest(Guest guest) { this.guest = guest; }
    public Payment getPayment() { return payment; }
    public void setPayment(Payment payment) { this.payment = payment; }
    public double calculateTotalAmount() {
        long duration = ChronoUnit.DAYS.between(checkInDate, checkOutDate);
        if (duration < 0) {
            System.out.println("Invalid date please try again");
            return 0;
        } else {
            double pricePerNight = room.getPrice();
            double totalAmount = duration * pricePerNight;
            this.payment.setAmount(totalAmount);
            return totalAmount;
        }
    }

}