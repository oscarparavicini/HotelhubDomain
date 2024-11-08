import ch.unil.doplab.Hotel;
import ch.unil.doplab.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HotelTest {
    private Hotel hotel;
    private Room room;

    @BeforeEach
    void setUp() {
        hotel = new Hotel("hotelUser", "hotelPass", "Lausanne Hotel", "123 Eccublens", "+41752632755");
        room = new Room(101, "Suite", 200.0, "WiFi, AC", 2);
    }

    @Test
    void testGettersAndSetters() {
        assertEquals("Lausanne Hotel", hotel.getName());
        hotel.setName("Sunset Hotel");
        assertEquals("Sunset Hotel", hotel.getName());

        assertEquals("hotelUser", hotel.getUsername());
        hotel.setUsername("newUser");
        assertEquals("newUser", hotel.getUsername());

        assertEquals("123 Eccublens", hotel.getAddress());
        hotel.setAddress("456 Ocean Ave");
        assertEquals("456 Ocean Ave", hotel.getAddress());
    }

    @Test
    void testAddAndDeleteHotel() {
        Hotel.addHotel(hotel);
        assertTrue(Hotel.getAllHotels().contains(hotel));

        Hotel.deleteHotel(hotel);
        assertFalse(Hotel.getAllHotels().contains(hotel));
    }

    @Test
    void testAddAndRemoveRoom() {
        hotel.addRoom(room);
        assertTrue(hotel.getRooms().contains(room));

        hotel.removeRoom(room);
        assertFalse(hotel.getRooms().contains(room));
    }
}
