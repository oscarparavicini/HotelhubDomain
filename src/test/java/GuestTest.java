import ch.unil.doplab.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class GuestTest {

    @Test
    void testGuestCreation() {
        Guest guest = new Guest("Oscar", "Vicini", "oscarvv", "JAYDVGG", "oscar@what.com");
        assertNotNull(guest.getId());
        assertNotEquals("John", guest.getFirstName());
        assertEquals("Vicini", guest.getLastName());
        assertEquals("oscarvv", guest.getUsername());
        assertNotEquals("password123", guest.getPassword());
        assertEquals("oscar@what.com", guest.getContactInfo());
        assertTrue(guest.getBookings().isEmpty());
    }

    @Test
    void testAddAndDeleteGuest() {
        Guest guest = new Guest("Oscar", "Vicini", "oscarvv", "JAYDVGG", "oscar@what.com");
        Guest.addguest(guest);
        assertTrue(Guest.getAllguests().contains(guest));
        Guest.deleteGuest(guest);
        assertFalse(Guest.getAllguests().contains(guest));
    }

    @Test
    void testAddAndCancelBooking() {
        Guest guest = new Guest("Oscar", "Vicini", "oscarvv", "JAYDVGG", "oscar@what.com");
        Room room = new Room(101, "Single", 100.0, "TV and smoking", 1);
        Booking booking = new Booking(room, LocalDate.now(), LocalDate.now().plusDays(2), guest);
        guest.addBooking(booking);
        assertTrue(guest.getBookings().contains(booking));
        guest.cancelBooking(booking);
        assertFalse(guest.getBookings().contains(booking));
    }

    @Test
    void testGetBooking() {
        Guest guest = new Guest("Oscar", "Vicini", "oscarvv", "JAYDVGG", "oscar@what.com");
        Room room = new Room(102, "Double", 150.0, "Balcony", 2);
        Booking booking1 = new Booking(room, LocalDate.now(), LocalDate.now().plusDays(3), guest);
        Booking booking2 = new Booking(room, LocalDate.now().plusDays(5), LocalDate.now().plusDays(7), guest);
        guest.addBooking(booking1);
        guest.addBooking(booking2);
        assertEquals(booking1, guest.getBooking(booking1.getId()));
        assertEquals(booking2, guest.getBooking(booking2.getId()));
        assertNull(guest.getBooking(UUID.randomUUID())); // Non-existent booking
    }

    @Test
    void testViewBookings() {
        Guest guest = new Guest("Oscar", "Vicini", "oscarvv", "JAYDVGG", "oscar@what.com");
        Room room = new Room(103, "Presidential Suite", 2000.0, "2 bathrooms", 3);
        Booking booking = new Booking(room, LocalDate.now(), LocalDate.now().plusDays(4), guest);
        guest.addBooking(booking);
        guest.viewBookings();
    }

    @Test
    void testSetters() {
        Guest guest = new Guest("Oscar", "Vicini", "oscarvv", "JAYDVGG", "oscar@what.com");
        guest.setFirstName("Todd");
        guest.setLastName("Breaking");
        guest.setUsername("ToddBreakingBad");
        guest.setPassword("newpass");
        guest.setContactInfo("Todd@newemail.com");

        assertEquals("Todd", guest.getFirstName());
        assertEquals("Breaking", guest.getLastName());
        assertEquals("ToddBreakingBad", guest.getUsername());
        assertNotEquals("new_password", guest.getPassword());
        assertEquals("Todd@newemail.com", guest.getContactInfo());
    }
}