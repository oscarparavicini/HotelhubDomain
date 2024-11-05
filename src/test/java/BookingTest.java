import ch.unil.doplab.Booking;
import ch.unil.doplab.Guest;
import ch.unil.doplab.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class BookingTest {
    private Booking booking;
    private Guest guest;
    private Room room;

    @BeforeEach
    void setUp() {
        guest = new Guest("Oscar", "Vicini", "ovicini", "pass1234", "oscar@example.com");
        room = new Room(101, "Suite", 200.0, "WiFi, AC", 2);
        booking = new Booking(room, LocalDate.now(), LocalDate.now().plusDays(3), guest);
    }

    @Test
    void testCalculateTotalAmount() {
        double totalAmount = booking.calculateTotalAmount();
        assertEquals(600.0, totalAmount);
    }

    @Test
    void testGettersAndSetters() {
        assertEquals(guest, booking.getGuest());
        booking.setGuest(new Guest("Tobby", "Todd", "tobbytod", "pass18266227", "todd@sample.com"));
        assertNotEquals(guest, booking.getGuest());

        assertEquals(room, booking.getRoom());
        Room newRoom = new Room(102, "Deluxe", 250.0, "WiFi, AC, Mini-bar", 2);
        booking.setRoom(newRoom);
        assertEquals(newRoom, booking.getRoom());
    }
}
