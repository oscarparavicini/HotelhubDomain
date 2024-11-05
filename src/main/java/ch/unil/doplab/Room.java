package ch.unil.doplab;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Room {
    private UUID id;
    private int roomNumber;
    private String type;
    private double price;
    private String amenities;
    private int maxOccupancy;
    private Set<Booking> bookings;

    public Room() {
        this.id = UUID.randomUUID();
        this.roomNumber = 0;
        this.type = "";
        this.price = 0;
        this.amenities = "";
        this.maxOccupancy = 1;
        this.bookings = new HashSet<>();
    }

    public Room(int roomNumber, String type, double price, String amenities, int maxOccupancy) {
        this.id = UUID.randomUUID();
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.amenities = amenities;
        this.maxOccupancy = maxOccupancy;
        this.bookings = new HashSet<>();
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public int getRoomNumber() { return roomNumber; }
    public void setRoomNumber(int roomNumber) { this.roomNumber = roomNumber; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getAmenities() { return amenities; }
    public void setAmenities(String amenities) { this.amenities = amenities; }
    public int getMaxOccupancy() { return maxOccupancy; }
    public void setMaxOccupancy(int maxOccupancy) { this.maxOccupancy = maxOccupancy; }

    public void addBooking(Booking booking) { this.bookings.add(booking); }
    public void removeBooking(Booking booking) { this.bookings.remove(booking); }
    public Set<Booking> getBookings() { return bookings; }

    public void updateRoom(String type, double price, int maxOccupancy, String amenities) {
        this.type = type;
        this.price = price;
        this.maxOccupancy = maxOccupancy;
        this.amenities = amenities;
    }
}