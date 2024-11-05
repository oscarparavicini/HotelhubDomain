import ch.unil.doplab.Guest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class GuestTest {
    private Guest guest;

    @BeforeEach
    void setUp() {
        guest = new Guest("Oscar", "Vici", "oscarvi", "password123", "oscar@example.com");
    }

    @Test
    void testGettersAndSetters() {
        assertEquals("Oscar", guest.getFirstName());
        guest.setFirstName("Jane");
        assertEquals("Jane", guest.getFirstName());

        assertEquals("Vici", guest.getLastName());
        guest.setLastName("Lebron");
        assertEquals("Lebron", guest.getLastName());

        assertNotEquals("contact@example.com", guest.getContactInfo());
        guest.setContactInfo("newcontact@example.com");
        assertEquals("newcontact@example.com", guest.getContactInfo());
    }

    @Test
    void testUniqueId() {
        UUID id = guest.getId();
        guest.setID(UUID.randomUUID());
        assertNotEquals(id, guest.getId());
    }

    @Test
    void testAddAndDeleteGuest() {
        Guest.addGuest(guest);
        assertTrue(Guest.getAllGuests().contains(guest));

        Guest.deleteGuest(guest);
        assertFalse(Guest.getAllGuests().contains(guest));
    }
}
