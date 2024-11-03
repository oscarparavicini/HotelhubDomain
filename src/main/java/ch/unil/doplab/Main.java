package ch.unil.doplab;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("admin", "password", "Grand Hotel", "123 Main St", "555-1234");
        hotel.addRoom(new Room(101, "Single", 100.0, "WiFi, TV", 1));
        hotel.addRoom(new Room(102, "Double", 150.0, "WiFi, TV, Balcony", 2));
        Hotel.addHotel(hotel);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter check-in date (YYYY-MM-DD):");
        LocalDate checkInDate = LocalDate.parse(scanner.nextLine());
        System.out.println("Enter check-out date (YYYY-MM-DD):");
        LocalDate checkOutDate = LocalDate.parse(scanner.nextLine());

        Set<Room> availableRooms = hotel.findAvailableRooms(checkInDate, checkOutDate);
        System.out.println("Available rooms:");
        for (Room room : availableRooms) {
            System.out.println(room.getRoomNumber() + " - " + room.getType() + " - $" + room.getPrice() + " per night");
        }

        System.out.println("Enter the room number you want to book:");
        int roomNumber = scanner.nextInt();
        scanner.nextLine();

        Room selectedRoom = null;
        for (Room room : availableRooms) {
            if (room.getRoomNumber() == roomNumber) {
                selectedRoom = room;
                break;
            }
        }

        if (selectedRoom == null) {
            System.out.println("Invalid room selection.");
            return;
        }

        System.out.println("Enter your first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter your last name:");
        String lastName = scanner.nextLine();
        Guest guest = new Guest(firstName, lastName, "guestuser", "guestpass", "guest@email.com");
        Guest.addguest(guest);

        Booking booking = new Booking(selectedRoom, checkInDate, checkOutDate, guest);
        guest.addBooking(booking);
        selectedRoom.addBooking(booking);

        double totalAmount = booking.calculateTotalAmount();
        System.out.println("Total amount for your booking: $" + totalAmount);

        System.out.println("Confirm booking? (yes/no)");
        String confirmation = scanner.nextLine();
        if (confirmation.equalsIgnoreCase("yes")) {
            System.out.println("Enter credit card number:");
            String cardNumber = scanner.nextLine();
            System.out.println("Enter expiry date (YYYY-MM-DD):");
            LocalDate expiryDate = LocalDate.parse(scanner.nextLine());

            // In a real application, use a payment gateway here
            // For this example, we'll just simulate payment confirmation
            booking.getPayment().confirmPayment(cardNumber, expiryDate);
            System.out.println("Booking confirmed! Booking ID is " + booking.getId());
        } else {
            System.out.println("Booking cancelled.");
            guest.cancelBooking(booking);
            selectedRoom.removeBooking(booking);
        }
        System.out.println("View booking? (yes/no)");
        String confirmation2 = scanner.nextLine();
        if (confirmation2.equalsIgnoreCase("yes")) {
            guest.viewBookings();
        } else {
            System.out.println("Have a good day");
        }
        scanner.close();
    }
}