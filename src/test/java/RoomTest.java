import ch.unil.doplab.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class RoomTest {

    @Test
    void testRoomCreation() {
        Room room = new Room(101, "Single", 100.0, "WiFi, TV", 1);
        assertNotNull(room.getId());
        assertEquals(101, room.getRoomNumber());
        assertEquals("Single", room.getType());
        assertEquals(100.0, room.getPrice());
        assertEquals("WiFi, TV", room.getAmenities());
        assertEquals(1, room.getMaxOccupancy());
        assertTrue(room.getBookings().isEmpty());
    }

    @Test
    void testAddAndRemoveBooking() {
        Room room = new Room(102, "Double", 150.00, "No smoking", 2);
        Guest guest = new Guest("The", "lastofUs", "Jerry12", "vfivihhni", "thelastofUS@email.com");
        Booking booking = new Booking(room, LocalDate.now(), LocalDate.now().plusDays(2), guest);
        room.addBooking(booking);
        assertTrue(room.getBookings().contains(booking));
        room.removeBooking(booking);
        assertFalse(room.getBookings().contains(booking));
    }

    @Test
    void testUpdateRoom() {
        Room room = new Room(103, "Single", 100.0, "WiFi but no TV", 1);
        room.updateRoom("Double", 150.0, 2, "WiFi and TV");
        assertEquals("Double", room.getType());
        assertEquals(150.0, room.getPrice());
        assertEquals(2, room.getMaxOccupancy());
        assertEquals("WiFi and TV", room.getAmenities());
    }
}