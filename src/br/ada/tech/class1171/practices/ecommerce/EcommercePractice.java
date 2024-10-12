package br.ada.tech.class1171.practices.ecommerce;

import br.ada.tech.class1171.practices.ecommerce.customer.Customer;
import br.ada.tech.class1171.practices.ecommerce.order.Order;
import br.ada.tech.class1171.practices.ecommerce.product.Product;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EcommercePractice {

    public Optional<Customer> oldestCustomer() {
        // Descubra qual o cliente mais velho cadastrado no sistema
        return DataHelper.customers().stream()
                .min(Comparator.comparing(
                        customer -> customer.getDateBirth()
                ));
    }

    public List<Customer> customersThatBirthdayThisMonth() {
        // Filtre os clientes que fazem aniversário neste mês
        var now = LocalDate.now();
        return DataHelper.customers().stream()
                .filter(customer -> customer.getDateBirth().getMonth() == now.getMonth())
                .toList();
    }

    public List<Customer> customerWithRepeatedFirstName() {
        // Filtre os clientes que possuem o primeiro nome repetido
        // Nesse stream é feito o agrupamento pelo primeiro nome
        var customersMap = DataHelper.customers().stream()
                .collect(Collectors.groupingBy(
                        customer -> customer.getName().split(" ")[0],
                        Collectors.toList()
                ));
        // Nesse stream é vericado onde o agrupamento possui mais de um item
        // Ainda nesse stream é feito uma planificação(flatMap) da lista de itens e retornado
        return customersMap.values().stream()
                .filter(list -> list.size() > 1)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public List<Order> ordersOlderThan2024() {
        // Filtros os pedidos que foram realizados antes de 2024-01-01
        return DataHelper.orders().stream()
                .filter(order -> order.getOrderedAt().getYear() < 2024)
                .toList();
    }

    public List<Order> ordersThatAskedOn2023() {
        // Filtre os pedidos que foram realizados no ano de 2023
        return DataHelper.orders().stream()
                .filter(order -> order.getOrderedAt().getYear() == 2023)
                .toList();
    }

    public List<Order> ordersThatAskedOn2024() {
        // Filtre os pedidos que foram realizados no ano de 2024
        return DataHelper.orders().stream()
                .filter(order -> order.getOrderedAt().getYear() == 2024)
                .toList();
    }

    public List<Customer> customerThatAskedAnyOrder() {
        // Filtre todos os clientes que fizeram ao menos um pedido, lembre-se de remover os valores duplicados
        return DataHelper.orders().stream()
                .map(Order::getCustomer)
                .distinct()
                .collect(Collectors.toList());
    }

    public Optional<Order> mostExpansiveOrder() {
        // Encontre o pedido que possui o maior valor
        return DataHelper.orders().stream()
                .max(Comparator.comparing(this::total));
    }

    private BigDecimal total(Order order) {
        return order.getProducts().stream()
                .map(Product::getPrice)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    public Optional<Order> mostCheaperOrder() {
        // Encontre o pedido que possui o menor valor
        return DataHelper.orders().stream()
                .min(Comparator.comparing(this::total));
    }

    public Map<Customer, BigDecimal> amountEachCustomerBought() {
        // Aplique filtros e conversões necessárias para descobrir o quanto cad cliente comprou, lembre-se de remover possíveis duplicações
        /**
         * [
         * {pedido =1, customer = a, total = 10},
         * {pedido =2, customer = b, total = 4},
         * {pedido =3, customer = c, total = 7},
         * {pedido =4, customer = b, total = 3},
         * {pedido =5, customer = d, total = 9},
         * {pedido =6, customer = a, total = 1},
         * ]
         * {
         *     customer a, [{pedido =1, customer = a, total = 10}, {pedido =6, customer = a, total = 1}]
         *     customer b, [{pedido =2, customer = b, total = 4}, {pedido =4, customer = b, total = 3}]
         *     customer c, [{pedido =3, customer = c, total = 7}]
         *     customer d, [{pedido =5, customer = d, total = 9}]
         * }
         * [{pedido =1, customer = a, total = 10}, {pedido =6, customer = a, total = 1}]
         * [{total = 10}, {total = 1}]
         * {total = 11}
         */
        return DataHelper.orders().stream()
                .collect(
                        Collectors.groupingBy(
                                Order::getCustomer,
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        orders -> orders.stream()//O orders representa a lista de pedidos que cada cliente fez.
                                                .map(order -> total(order))
                                                .reduce(BigDecimal::add)
                                                .orElse(BigDecimal.ZERO)
                                )
                        )
                );
    }

    public Optional<Customer> customerWhoBoughtTheMostTimes() {
        // Cliente que realizou a maior quantidade de pedidos, nesse caso é quantidade e não valor
        Comparator<Map.Entry<Customer, Long>> compare = Comparator.comparing(entry -> entry.getValue());
        compare = compare.thenComparing(entry -> entry.getKey().getName()).reversed();
        return DataHelper.orders().stream()
                .collect(
                        Collectors.groupingBy(
                                Order::getCustomer,
                                Collectors.counting()
                        )
                ).entrySet().stream()
                .max(compare)
                .map(Map.Entry::getKey);
    }

    public Optional<Customer> customerWhoPlacedExpensiveOrder() {
        // Cliente que realizou o pedido mais caro
        return DataHelper.orders().stream()
                .max(Comparator.comparing(this::total))
                .map(Order::getCustomer);
    }

    public Map<Product, Long> howManyTimesEachProductWasSales() {
        // Retorne a quantidade de vezes que cada produto foi vendido
        return DataHelper.orders().stream()
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.groupingBy(
                        it -> it,
                        Collectors.counting()
                ));
    }

    public Map<Product, BigDecimal> totalValueObtainedFromTheSalesOfEachProduct() {
        // Qual o valor total obtido com a venda de cada produto
        return DataHelper.orders().stream()
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.groupingBy(
                        it -> it,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                products -> products.stream()
                                        .map(Product::getPrice)
                                        .reduce(BigDecimal::add)
                                        .orElse(BigDecimal.ZERO)
                        )
                ));
    }

    public Optional<Product> productThatMostSold() {
        // Qual o produto que mais foi vendido
        Comparator<Map.Entry<Product, Long>> compare = Comparator.comparing(entry -> entry.getValue());
        compare = compare.thenComparing(entry -> entry.getKey().getName()).reversed();
        return DataHelper.orders().stream()
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.groupingBy(
                        it -> it,
                        Collectors.counting()
                )).entrySet().stream()
                .max(compare)
                .map(Map.Entry::getKey);
    }

    public Optional<Product> productThatSoldTheLeast() {
        // Qual o produto que menos vendeu
        Comparator<Map.Entry<Product, Long>> compare = Comparator.comparing(entry -> entry.getValue());
        compare = compare.thenComparing(entry -> entry.getKey().getName());
        return DataHelper.orders().stream()
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.groupingBy(
                        it -> it,
                        Collectors.counting()
                )).entrySet().stream()
                .min(compare)
                .map(Map.Entry::getKey);
    }

    public Map<Customer, List<Product>> productsThatWerePurchasedByCustomer() {
        // Quais os produtos que foram comprados por cada cliente
        return DataHelper.orders().stream()
                .collect(
                        Collectors.groupingBy(
                                Order::getCustomer,
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        orders -> orders.stream()
                                                .flatMap(order -> order.getProducts().stream())
                                                .collect(Collectors.toList())
                                )
                        )
                );
    }
}
