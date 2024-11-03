package ch.unil.doplab;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Hotel {
    private static Set<Hotel> allHotels = new HashSet<>();
    private UUID id;
    private String name;
    private String username;
    private String password;
    private String address;
    private String contactInfo;
    private Set<Room> rooms;

    public Hotel(String username, String password, String name, String address, String contactInfo) {
        this.username = username;
        this.password = password;
        this.id = UUID.randomUUID();
        this.name = name;
        this.address = address;
        this.contactInfo = contactInfo;
        this.rooms = new HashSet<>();
    }

    public static void addHotel(Hotel hotel) { allHotels.add(hotel); }
    public static void deleteHotel(Hotel hotel) { allHotels.remove(hotel); }
    public static Set<Hotel> getAllHotels() { return allHotels; }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getContactInfo() { return contactInfo; }
    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }
    public Set<Room> getRooms() { return rooms; }

    public void addRoom(Room room) { this.rooms.add(room); }
    public void removeRoom(Room room) { this.rooms.remove(room); }

    public Set<Room> findAvailableRooms(LocalDate checkInDate, LocalDate checkOutDate) {
        Set<Room> availableRooms = new HashSet<>();
        for (Room room : rooms) {
            boolean isAvailable = true;
            for (Booking booking : room.getBookings()) {
                if (!(checkInDate.isAfter(booking.getCheckOutDate()) || checkOutDate.isBefore(booking.getCheckInDate()))) {isAvailable = false;break;}}
            if (isAvailable) {
                availableRooms.add(room);}}
        return availableRooms;}
}