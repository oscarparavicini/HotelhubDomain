import ch.unil.doplab.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class HotelTest {

    @Test
    void testHotelCreation() {
        Hotel hotel = new Hotel("admin_hotel", "password123", "Intercontinental Lausanne", "Route de Geneve 34", "hotelinter@gmail.com");
        assertNotNull(hotel.getId());
        assertNotEquals("Grand Hotel", hotel.getName());
        assertNotEquals("123 Main St, Anytown", hotel.getAddress());
        assertNotEquals("555-1234", hotel.getContactInfo());
        assertTrue(hotel.getRooms().isEmpty());
    }

    @Test
    void testAddAndDeleteHotel() {
        Hotel hotel = new Hotel("admin_hotel", "password123", "Intercontinental Lausanne", "Route de Geneve 34", "hotelinter@gmail.com");
        Hotel.addHotel(hotel);
        assertTrue(Hotel.getAllHotels().contains(hotel));
        Hotel.deleteHotel(hotel);
        assertFalse(Hotel.getAllHotels().contains(hotel));
    }

    @Test
    void testAddAndRemoveRoom() {
        Hotel hotel = new Hotel("admin_hotel", "password123", "Intercontinental Lausanne", "Route de Geneve 34", "hotelinter@gmail.com");
        Room room = new Room(101, "Triple", 100.0, "No pet", 1);
        hotel.addRoom(room);
        assertTrue(hotel.getRooms().contains(room));
        hotel.removeRoom(room);
        assertFalse(hotel.getRooms().contains(room));
    }

    @Test
    void testFindAvailableRooms() {
        Hotel hotel = new Hotel("admin_hotel", "password123", "Intercontinental Lausanne", "Route de Geneve 34", "hotelinter@gmail.com");
        Room room1 = new Room(201, "Double", 150.0, "WiFi", 2);
        Room room2 = new Room(202, "Suite", 200.0, "Jacuzzi", 3);
        hotel.addRoom(room1);
        hotel.addRoom(room2);
        Guest guest1 = new Guest("The", "lastofUs", "Jerry12", "vfivihhni", "thelastofUS@email.com");
        LocalDate checkInDate = LocalDate.of(2024, 11, 10);
        LocalDate checkOutDate = LocalDate.of(2024, 11, 15);
        Booking booking1 = new Booking(room1, checkInDate, checkOutDate, guest1);
        room1.addBooking(booking1);
        Set<Room> availableRooms = hotel.findAvailableRooms(LocalDate.of(2024, 11, 8), LocalDate.of(2024, 11, 9));
        assertEquals(2, availableRooms.size());
        availableRooms = hotel.findAvailableRooms(checkInDate, checkOutDate);
        assertEquals(1, availableRooms.size());
        assertTrue(availableRooms.contains(room2));
        assertFalse(availableRooms.contains(room1));
        availableRooms = hotel.findAvailableRooms(LocalDate.of(2024, 11, 16), LocalDate.of(2024, 11, 20)); // After booking
        assertEquals(2, availableRooms.size()); // Both rooms should be available
    }
}