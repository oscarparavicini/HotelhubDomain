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

    public Guest() {
        this.id = UUID.randomUUID();
        this.firstName = "";
        this.lastName = "";
        this.username = "";
        this.password = "";
        this.contactInfo = "";
    }

    public Guest(String firstName, String lastName, String username, String password, String contactInfo) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.contactInfo = contactInfo;
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

    public static void addGuest(Guest guest) { allguests.add(guest); }
    public static void deleteGuest(Guest guest) { allguests.remove(guest); }
    public static Set<Guest> getAllGuests() { return allguests; }
}
