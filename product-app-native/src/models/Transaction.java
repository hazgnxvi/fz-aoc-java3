package models;

import java.time.LocalDateTime;

public class Transaction {
    private LocalDateTime date = LocalDateTime.now();
    private Double totalAmount;
    private String status;
    private Customer customer;

    public Transaction() {
    }

    public Transaction(Double totalAmount, Customer customer) {

    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
