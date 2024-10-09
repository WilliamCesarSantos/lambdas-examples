package br.ada.tech.class1171.practices.ecommerce;

import br.ada.tech.class1171.practices.ecommerce.customer.Customer;
import br.ada.tech.class1171.practices.ecommerce.order.Order;
import br.ada.tech.class1171.practices.ecommerce.product.Product;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataHelper {

    public static List<Product> products() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1L, "T-Shirt", new BigDecimal("19.99")));
        products.add(new Product(2L, "Coffee Mug", new BigDecimal("8.95")));
        products.add(new Product(3L, "Laptop", new BigDecimal("799.99")));
        products.add(new Product(4L, "Headphones", new BigDecimal("49.99")));
        products.add(new Product(5L, "Water Bottle", new BigDecimal("12.99")));
        products.add(new Product(6L, "Notebook", new BigDecimal("5.99")));
        products.add(new Product(7L, "Pen", new BigDecimal("1.25")));
        products.add(new Product(8L, "Desk Lamp", new BigDecimal("29.99")));
        products.add(new Product(9L, "Mouse", new BigDecimal("14.99")));
        products.add(new Product(10L, "Keyboard", new BigDecimal("34.99")));
        products.add(new Product(11L, "Smartphone", new BigDecimal("499.99")));
        products.add(new Product(12L, "Watch", new BigDecimal("129.99")));
        products.add(new Product(13L, "Backpack", new BigDecimal("39.99")));
        products.add(new Product(14L, "Wallet", new BigDecimal("24.99")));
        products.add(new Product(15L, "Belt", new BigDecimal("19.95")));
        products.add(new Product(16L, "Hat", new BigDecimal("14.99")));
        products.add(new Product(17L, "Sunglasses", new BigDecimal("29.99")));
        products.add(new Product(18L, "Speakers", new BigDecimal("79.99")));
        products.add(new Product(19L, "Blanket", new BigDecimal("34.99")));
        products.add(new Product(20L, "Book", new BigDecimal("17.99")));
        return products;
    }

    public static List<Customer> customers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1L, "Alice Johnson", "1234567890", LocalDate.of(1985, 11, 15)));
        customers.add(new Customer(2L, "Bob Smith", "9876543210", LocalDate.of(1990, 5, 20)));
        customers.add(new Customer(3L, "Bob Brown", "5555555555", LocalDate.of(1975, 9, 30)));
        customers.add(new Customer(4L, "David Lee", "4444444444", LocalDate.of(1995, 2, 10)));
        customers.add(new Customer(5L, "Emily Davis", "3333333333", LocalDate.of(1988, 7, 25)));
        customers.add(new Customer(6L, "Frank Wilson", "2222222222", LocalDate.of(1970, 12, 5)));
        customers.add(new Customer(7L, "Grace Miller", "1111111111", LocalDate.of(1992, 3, 18)));
        customers.add(new Customer(8L, "Henry Baker", "0000000000", LocalDate.of(1982, 8, 7)));
        customers.add(new Customer(9L, "Isabella Green", "9999999999", LocalDate.of(1997, 4, 12)));
        customers.add(new Customer(10L, "Jack Taylor", "8888888888", LocalDate.of(1978, 6, 23)));
        return customers;
    }

    public static List<Order> orders() {
        List<Customer> customers = customers();
        List<Product> products = products();

        List<Order> orders = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            long orderId = i + 1;
            LocalDate orderDate = LocalDate.now().minusMonths(i);

            int customerIndex = i % customers.size();
            Customer customer = customers.get(customerIndex);

            List<Product> orderProducts = new ArrayList<>();
            int numProducts = (i % 3) + 1;
            for (int j = 0; j < numProducts; j++) {
                int productIndex = (i + j) % products.size();
                orderProducts.add(products.get(productIndex));
            }

            orders.add(new Order(orderId, orderDate, customer, orderProducts));
        }
        return orders;
    }

}
