import ch.unil.doplab.Payment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {
    private Payment payment;

    @BeforeEach
    void setUp() {
        payment = new Payment(300.0);
    }

    @Test
    void testConfirmPayment() {
        payment.confirmPayment("1234567890123456", LocalDate.of(2025, 12, 31));
        assertEquals("1234567890123456", payment.getCardNumber());
        assertEquals("Confirmed", payment.getStatus());
        assertNotNull(payment.getPaymentDate());
        assertEquals(LocalDate.of(2025, 12, 31), payment.getExpiryDate());
    }

    @Test
    void testSettersAndGetters() {
        assertEquals(300.0, payment.getAmount());
        payment.setAmount(400.0);
        assertEquals(400.0, payment.getAmount());

        assertEquals("Pending", payment.getStatus());
        payment.setStatus("Failed");
        assertEquals("Failed", payment.getStatus());
    }
}
