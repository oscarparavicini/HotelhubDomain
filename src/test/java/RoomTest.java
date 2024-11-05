import ch.unil.doplab.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
    private Room room;

    @BeforeEach
    void setUp() {
        room = new Room(101, "Suite", 150.0, "WiFi, TV", 3);
    }

    @Test
    void testGettersAndSetters() {
        assertEquals(101, room.getRoomNumber());
        room.setRoomNumber(202);
        assertEquals(202, room.getRoomNumber());

        assertEquals("Suite", room.getType());
        room.setType("Deluxe");
        assertEquals("Deluxe", room.getType());

        assertEquals(150.0, room.getPrice());
        room.setPrice(180.0);
        assertEquals(180.0, room.getPrice());

        assertEquals("WiFi, TV", room.getAmenities());
        room.setAmenities("WiFi, TV, AC");
        assertEquals("WiFi, TV, AC", room.getAmenities());
    }
}
