import ch.unil.doplab.Payment;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentTest {

    @Test
    void testPaymentCreation() {
        Payment payment = new Payment(100.0);
        assertNotNull(payment.getId());
        assertEquals(100.0, payment.getAmount());
        assertNull(payment.getPaymentDate()); // Payment date should be null initially
        assertEquals("Pending", payment.getStatus());
        assertNull(payment.getCardNumber());
        assertNull(payment.getExpiryDate());
    }

    @Test
    void testSetAmount() {
        Payment payment = new Payment(50.0);
        payment.setAmount(200.0);
        assertEquals(200.0, payment.getAmount());
    }

    @Test
    void testSetStatus() {
        Payment payment = new Payment(150.0);
        payment.setStatus("Amount has been paid");
        assertEquals("Amount has been paid", payment.getStatus());
    }

    @Test
    void testSetCardNumber() {
        Payment payment = new Payment(150.0);
        payment.setCardNumber("1234-5678-9012-3456");
        assertEquals("1234-5678-9012-3456", payment.getCardNumber());
    }

    @Test
    void testSetExpiryDate() {
        Payment payment = new Payment(150.0);
        LocalDate expiryDate = LocalDate.of(2025, 12, 31);
        payment.setExpiryDate(expiryDate);
        assertEquals(expiryDate, payment.getExpiryDate());
    }

    @Test
    void testConfirmPayment() {
        Payment payment = new Payment(75.0);
        String cardNumber = "9876-5432-1098-7654";
        LocalDate expiryDate = LocalDate.of(2026, 10, 15);
        payment.confirmPayment(cardNumber, expiryDate);
        assertEquals("Confirmed", payment.getStatus());
        assertEquals(cardNumber, payment.getCardNumber());
        assertEquals(expiryDate, payment.getExpiryDate());
        assertNotNull(payment.getPaymentDate());
    }
}