package models;

public class Order {
    private Transaction transaction;
    private Product product;
    private Integer quantity;
    private Double price;

    public Order() {
    }

    public Order(Transaction transaction, Product product, Integer quantity, Double price) {
        this.transaction = transaction;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order [transaction=" + transaction + ", product=" + product + ", quantity=" + quantity + ", price="
                + price + "]";
    }

}
