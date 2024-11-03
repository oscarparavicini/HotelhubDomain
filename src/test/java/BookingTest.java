import ch.unil.doplab.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class BookingTest {

    @Test
    void testBookingCreation() {
        Room room = new Room(101, "Single", 1000.0, "No kids", 1);
        Guest guest = new Guest("Oscar", "Vicini", "oscarvv", "JAYDVGG", "oscar@what.com");
        LocalDate checkInDate = LocalDate.of(2024, 11, 10);
        LocalDate checkOutDate = LocalDate.of(2024, 11, 15);
        Booking booking = new Booking(room, checkInDate, checkOutDate, guest);
        assertNotNull(booking.getId());
        assertEquals(room, booking.getRoom());
        assertEquals(checkInDate, booking.getCheckInDate());
        assertEquals(checkOutDate, booking.getCheckOutDate());
        assertEquals(guest, booking.getGuest());
        assertNotNull(booking.getPayment());
    }

    @Test
    void testCalculateTotalAmount() {
        Room room = new Room(102, "Double", 150.00, "No smoking", 2);
        Guest guest = new Guest("The", "lastofUs", "Jerry12", "vfivihhni", "thelastofUS@email.com");
        LocalDate checkInDate = LocalDate.of(2024, 12, 20);
        LocalDate checkOutDate = LocalDate.of(2024, 12, 25);
        Booking booking = new Booking(room, checkInDate, checkOutDate, guest);
        double totalAmount = booking.calculateTotalAmount();
        assertEquals(750.0, totalAmount); // 5 days * 150.0 per night
        assertEquals(750.0, booking.getPayment().getAmount()); // Payment amount should be updated
    }

    @Test
    void testCalculateTotalAmountWithZeroNights() {
        Room room = new Room(102, "Double", 150.00, "No smoking", 2);
        Guest guest = new Guest("The", "lastofUs", "Jerry12", "vfivihhni", "thelastofUS@email.com");
        LocalDate checkInDate = LocalDate.of(2024, 11, 5);
        LocalDate checkOutDate = LocalDate.of(2024, 11, 5); // Same day check-in and check-out
        Booking booking = new Booking(room, checkInDate, checkOutDate, guest);
        double totalAmount = booking.calculateTotalAmount();
        assertEquals(0.0, totalAmount);
    }
}