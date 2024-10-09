package br.ada.tech.class1171.practices.ecommerce;

import br.ada.tech.class1171.practices.ecommerce.customer.Customer;
import br.ada.tech.class1171.practices.ecommerce.order.Order;
import br.ada.tech.class1171.practices.ecommerce.product.Product;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class EcommercePractice {

    public Optional<Customer> oldestCustomer() {
        // Descubra qual o cliente mais velho cadastrado no sistema
        return Optional.empty();
    }

    public List<Customer> customersThatBirthdayThisMonth() {
        // Filtre os clientes que fazem aniversário neste mês
        return Collections.emptyList();
    }

    public List<Customer> customerWithRepeatedFirstName() {
        // Filtre os clientes que possuem o primeiro nome repetido
        return Collections.emptyList();
    }

    public List<Order> ordersOlderThan2024() {
        // Filtros os pedidos que foram realizados antes de 2024-01-01
        return Collections.emptyList();
    }

    public List<Order> ordersThatAskedOn2023() {
        // Filtre os pedidos que foram realizados no ano de 2023
        return Collections.emptyList();
    }

    public List<Order> ordersThatAskedOn2024() {
        // Filtre os pedidos que foram realizados no ano de 2024
        return Collections.emptyList();
    }

    public List<Customer> customerThatAskedAnyOrder() {
        // Filtre todos os clientes que fizeram ao menos um pedido, lembre-se de remover os valores duplicados
        return Collections.emptyList();
    }

    public Optional<Order> mostExpansiveOrder() {
        // Encontre o pedido que possui o maior valor
        return Optional.empty();
    }

    private BigDecimal total(Order order) {
        return BigDecimal.ZERO;
    }

    public Optional<Order> mostCheaperOrder() {
        // Encontre o pedido que possui o menor valor
        return Optional.empty();
    }

    public Map<Customer, BigDecimal> amountEachCustomerBought() {
        // Aplique filtros e conversões necessárias para descobrir o quanto cada cliente comprou, lembre-se de remover possíveis duplicações
        return Map.of();
    }

    public Optional<Customer> customerWhoBoughtTheMostTimes() {
        // Cliente que realizou a maior quantidade de pedidos, nesse caso é quantidade e não valor
        return Optional.empty();
    }

    public Optional<Customer> customerWhoPlacedExpensiveOrder() {
        // Cliente que realizou o pedido mais caro
        return Optional.empty();
    }

    public Map<Product, Long> howManyTimesEachProductWasSales() {
        // Retorne a quantidade de vezes que cada produto foi vendido
        return Map.of();
    }

    public Map<Product, BigDecimal> totalValueObtainedFromTheSalesOfEachProduct() {
        // Qual o valor total obtido com a venda de cada produto
        return Map.of();
    }

    public Optional<Product> productThatMostSold() {
        // Qual o produto que mais foi vendido
        return Optional.empty();
    }

    public Optional<Product> productThatSoldTheLeast() {
        // Qual o produto que menos vendeu
        return Optional.empty();
    }

    public Map<Customer, List<Product>> productsThatWerePurchasedByCustomer() {
        // Quais os produtos que foram comprados por cada cliente
        return Map.of();
    }
}
