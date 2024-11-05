package ch.unil.doplab;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Guest {
    private static Set<Guest> allguests = new HashSet<>();
    private UUID id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String contactInfo;
    private Set<Booking> bookings;

    public Guest() {
        this.id = UUID.randomUUID();
        this.firstName = ""; // Or null, depending on your needs
        this.lastName = "";  // Or null
        this.username = "";  // Or null
        this.password = "";  // Or null
        this.contactInfo = ""; // Or null
        this.bookings = new HashSet<>();
    }

    public Guest(String firstName, String lastName, String username, String password,  String contactInfo) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.contactInfo = contactInfo;
        this.bookings = new HashSet<>();
    }

    public UUID getId() { return id; }
    public void setID(UUID uuid) { this.id = uuid; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getContactInfo() { return contactInfo; }
    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public Set<Booking> getBookings() { return bookings; }

    public static void addguest(Guest guest) { allguests.add(guest); }
    public static void deleteGuest(Guest guest) { allguests.remove(guest); }
    public static Set<Guest> getAllguests() { return allguests; }

    public void addBooking(Booking booking) { this.bookings.add(booking); }
    public void cancelBooking(Booking booking) { this.bookings.remove(booking); }
    public Booking getBooking(UUID bookingId) {
        for (Booking booking : bookings) {
            if (booking.getId().equals(bookingId)) {
                return booking;}}
        return null;}

    public void viewBookings() {
        for (Booking booking : bookings) {
            System.out.println("Booking ID: " + booking.getId() +
                    ", Check-In: " + booking.getCheckInDate() +
                    ", Check-Out: " + booking.getCheckOutDate() +
                    ", Room: " + booking.getRoom().getRoomNumber() +
                    ", Payment Status: " + booking.getPayment().getStatus());}}
}