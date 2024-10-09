package br.ada.tech.class1171.practices.ecommerce.order;

import br.ada.tech.class1171.practices.ecommerce.customer.Customer;
import br.ada.tech.class1171.practices.ecommerce.product.Product;

import java.time.LocalDate;
import java.util.List;

public class Order {

    private Long id;
    private LocalDate orderedAt;
    private Customer customer;
    private List<Product> products;

    public Order(Long id, LocalDate orderedAt, Customer customer, List<Product> products) {
        this.id = id;
        this.orderedAt = orderedAt;
        this.customer = customer;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getOrderedAt() {
        return orderedAt;
    }

    public void setOrderedAt(LocalDate orderedAt) {
        this.orderedAt = orderedAt;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderedAt=" + orderedAt +
                ", customer=" + customer +
                ", products=" + products +
                '}';
    }
}
