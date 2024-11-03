package ch.unil.doplab;

import java.time.LocalDate;
import java.util.UUID;

public class Payment {
    private UUID id;
    private double amount;
    private LocalDate paymentDate;
    private String status;
    private String cardNumber;
    private LocalDate expiryDate;

    public Payment(double amount) {
        this.id = UUID.randomUUID();
        this.amount = amount;
        this.paymentDate = null;
        this.status = "Pending";
        this.cardNumber = null;
        this.expiryDate = null;
    }

    public UUID getId() {return id;}
    public double getAmount() {return amount;}
    public void setAmount(double amount) {this.amount = amount;}
    public LocalDate getPaymentDate() {return paymentDate;}
    public String getStatus() {return status;}
    public void setStatus(String status) {this.status = status;}
    public String getCardNumber() {return cardNumber;}
    public void setCardNumber(String cardNumber) {this.cardNumber = cardNumber;}
    public LocalDate getExpiryDate() {return expiryDate;}
    public void setExpiryDate(LocalDate expiryDate) {this.expiryDate = expiryDate;}

    public void confirmPayment(String cardNumber, LocalDate expiryDate) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.status = "Confirmed";
        this.paymentDate = LocalDate.now();}
}