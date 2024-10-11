package br.ada.tech.class1171.practices.ecommerce;

import br.ada.tech.class1171.practices.Reviewer;
import br.ada.tech.class1171.practices.ecommerce.customer.Customer;
import br.ada.tech.class1171.practices.ecommerce.order.Order;
import br.ada.tech.class1171.practices.ecommerce.product.Product;

import java.math.BigDecimal;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class EcommerceRevision {

    public static void main(String[] args) {
        Reviewer reviewer = new Reviewer();
        EcommercePractice practices = new EcommercePractice();

        System.out.println("-----------------------------");
        reviewer.valid("oldestCustomer", practices::oldestCustomer, result ->
                result.map(Customer::getName).orElse("N/A").equalsIgnoreCase("Frank Wilson")
        );

        System.out.println("-----------------------------");
        reviewer.valid("customersThatBirthdayThisMonth", practices::customersThatBirthdayThisMonth, result ->
                result.isEmpty()
        );

        System.out.println("-----------------------------");
        reviewer.valid("customerWithRepeatedFirstName", practices::customerWithRepeatedFirstName, result -> {
            result.sort(Comparator.comparing(
                    Customer::getId, Long::compareTo
            ));
            return result.size() == 2
                    && result.get(0).getName().equalsIgnoreCase("Bob Smith")
                    && result.get(1).getName().equalsIgnoreCase("Bob Brown");
        });

        System.out.println("-----------------------------");
        reviewer.valid("ordersOlderThan2024", practices::ordersOlderThan2024, result ->
                result.size() == 20
        );

        System.out.println("-----------------------------");
        reviewer.valid("ordersThatAskedOn2023", practices::ordersThatAskedOn2023, result ->
                result.size() == 12
        );

        System.out.println("-----------------------------");
        reviewer.valid("ordersThatAskedOn2024", practices::ordersThatAskedOn2024, result ->
                result.size() == 10
        );

        System.out.println("-----------------------------");
        reviewer.valid("customerThatAskedAnyOrder", practices::customerThatAskedAnyOrder, result -> {
            result.sort(Comparator.comparing(
                    Customer::getId, Long::compareTo
            ));
            return result.size() == 10
                    && result.get(0).getName().equalsIgnoreCase("Alice Johnson")
                    && result.get(1).getName().equalsIgnoreCase("Bob Smith")
                    && result.get(2).getName().equalsIgnoreCase("Bob Brown")
                    && result.get(3).getName().equalsIgnoreCase("David Lee")
                    && result.get(4).getName().equalsIgnoreCase("Emily Davis")
                    && result.get(5).getName().equalsIgnoreCase("Frank Wilson")
                    && result.get(6).getName().equalsIgnoreCase("Grace Miller")
                    && result.get(7).getName().equalsIgnoreCase("Henry Baker")
                    && result.get(8).getName().equalsIgnoreCase("Isabella Green")
                    && result.get(9).getName().equalsIgnoreCase("Jack Taylor");
        });

        System.out.println("-----------------------------");
        reviewer.valid("mostExpansiveOrder", practices::mostExpansiveOrder, result ->
                result.map(Order::getId).orElse(0l) == 3l
        );

        System.out.println("-----------------------------");
        reviewer.valid("mostCheaperOrder", practices::mostCheaperOrder, result ->
                result.map(Order::getId).orElse(0l) == 7l
        );

        System.out.println("-----------------------------");
        reviewer.valid("amountEachCustomerBought", practices::amountEachCustomerBought, result -> {
            var simpleResult = result.entrySet().stream()
                    .collect(
                            Collectors.toMap(
                                    entry -> entry.getKey().getName(),
                                    entry -> entry.getValue()
                            )
                    );
            return simpleResult.get("David Lee").compareTo(new BigDecimal("163.90")) == 0
                    && simpleResult.get("Frank Wilson").compareTo(new BigDecimal("59.46")) == 0
                    && simpleResult.get("Henry Baker").compareTo(new BigDecimal("207.94")) == 0
                    && simpleResult.get("Bob Smith").compareTo(new BigDecimal("1012.86")) == 0
                    && simpleResult.get("Alice Johnson").compareTo(new BigDecimal("1478.90")) == 0
                    && simpleResult.get("Jack Taylor").compareTo(new BigDecimal("737.94")) == 0
                    && simpleResult.get("Emily Davis").compareTo(new BigDecimal("96.90")) == 0
                    && simpleResult.get("Bob Brown").compareTo(new BigDecimal("1752.94")) == 0
                    && simpleResult.get("Isabella Green").compareTo(new BigDecimal("634.94")) == 0
                    && simpleResult.get("Grace Miller").compareTo(new BigDecimal("157.46")) == 0;
        });

        System.out.println("-----------------------------");
        reviewer.valid("customerWhoBoughtTheMostTimes", practices::customerWhoBoughtTheMostTimes, result ->
                result.map(Customer::getName)
                        .orElse("")
                        .equalsIgnoreCase("Alice Johnson")
        );

        System.out.println("-----------------------------");
        reviewer.valid("customerWhoPlacedExpensiveOrder", practices::customerWhoPlacedExpensiveOrder, result ->
                result.map(Customer::getName)
                        .orElse("")
                        .equalsIgnoreCase("Bob Brown")
        );

        System.out.println("-----------------------------");
        reviewer.valid("howManyTimesEachProductWasSales", practices::howManyTimesEachProductWasSales, result -> {
            var simpleResult = result.entrySet().stream()
                    .collect(Collectors.toMap(
                            entry -> entry.getKey().getName(),
                            Map.Entry::getValue
                    ));
            return simpleResult.get("Hat") == 2l
                    && simpleResult.get("Desk Lamp") == 4l
                    && simpleResult.get("Keyboard") == 4l
                    && simpleResult.get("Watch") == 3l
                    && simpleResult.get("Headphones") == 4l
                    && simpleResult.get("Notebook") == 4l
                    && simpleResult.get("T-Shirt") == 3l
                    && simpleResult.get("Sunglasses") == 2l
                    && simpleResult.get("Water Bottle") == 4l
                    && simpleResult.get("Mouse") == 4l
                    && simpleResult.get("Backpack") == 2l
                    && simpleResult.get("Coffee Mug") == 3l
                    && simpleResult.get("Belt") == 2l
                    && simpleResult.get("Laptop") == 4l
                    && simpleResult.get("Blanket") == 2l
                    && simpleResult.get("Wallet") == 2l
                    && simpleResult.get("Speakers") == 2l
                    && simpleResult.get("Pen") == 4l
                    && simpleResult.get("Smartphone") == 3l
                    && simpleResult.get("Book") == 2l;
        });

        System.out.println("-----------------------------");
        reviewer.valid("totalValueObtainedFromTheSalesOfEachProduct", practices::totalValueObtainedFromTheSalesOfEachProduct, result -> {
            var expected = new HashMap<String, BigDecimal>();
            expected.put("Hat", new BigDecimal("29.98"));
            expected.put("Desk Lamp", new BigDecimal("119.96"));
            expected.put("Keyboard", new BigDecimal("139.96"));
            expected.put("Watch", new BigDecimal("389.97"));
            expected.put("Headphones", new BigDecimal("199.96"));
            expected.put("Notebook", new BigDecimal("23.96"));
            expected.put("T-Shirt", new BigDecimal("59.97"));
            expected.put("Sunglasses", new BigDecimal("59.98"));
            expected.put("Water Bottle", new BigDecimal("51.96"));
            expected.put("Mouse", new BigDecimal("59.96"));
            expected.put("Backpack", new BigDecimal("79.98"));
            expected.put("Coffee Mug", new BigDecimal("26.85"));
            expected.put("Belt", new BigDecimal("39.90"));
            expected.put("Laptop", new BigDecimal("3199.96"));
            expected.put("Blanket", new BigDecimal("69.98"));
            expected.put("Wallet", new BigDecimal("49.98"));
            expected.put("Speakers", new BigDecimal("159.98"));
            expected.put("Pen", new BigDecimal("5.00"));
            expected.put("Smartphone", new BigDecimal("1499.97"));
            expected.put("Book", new BigDecimal("35.98"));
            return result.entrySet().stream()
                    .map(entry -> new AbstractMap.SimpleEntry<>(entry.getKey().getName(), entry.getValue()))
                    .allMatch(it -> expected.get(it.getKey()).compareTo(it.getValue()) == 0);
        });

        System.out.println("-----------------------------");
        reviewer.valid("productThatMostSold", practices::productThatMostSold, result ->
                result.map(Product::getName)
                        .orElse("")
                        .equalsIgnoreCase("Backpack")
        );

        System.out.println("-----------------------------");
        reviewer.valid("productThatSoldTheLeast", practices::productThatSoldTheLeast, result ->
                result.map(Product::getName)
                        .orElse("")
                        .equalsIgnoreCase("Backpack")
        );

        System.out.println("-----------------------------");
        reviewer.valid("productsThatWerePurchasedByCustomer", practices::productsThatWerePurchasedByCustomer, result -> {
            var simpleResult = result.entrySet().stream()
                    .collect(
                            Collectors.groupingBy(
                                    entry -> entry.getKey().getName(),
                                    Collectors.mapping(
                                            entry -> entry.getValue().stream()
                                                    .map(Product::getName)
                                                    .distinct().sorted()
                                                    .collect(Collectors.joining(", ")),
                                            Collectors.joining()
                                    )
                            )
                    );
            return simpleResult.get("Bob Smith").equalsIgnoreCase("Backpack, Coffee Mug, Laptop, Wallet, Watch")
                    && simpleResult.get("Emily Davis").equalsIgnoreCase("Belt, Hat, Notebook, Sunglasses, Water Bottle")
                    && simpleResult.get("Alice Johnson").equalsIgnoreCase("Coffee Mug, Laptop, Smartphone, T-Shirt, Watch")
                    && simpleResult.get("Grace Miller").equalsIgnoreCase("Desk Lamp, Mouse, Pen, Speakers, Sunglasses")
                    && simpleResult.get("Jack Taylor").equalsIgnoreCase("Book, Keyboard, Smartphone, T-Shirt, Watch")
                    && simpleResult.get("Henry Baker").equalsIgnoreCase("Blanket, Book, Desk Lamp, Mouse, Speakers")
                    && simpleResult.get("Bob Brown").equalsIgnoreCase("Backpack, Headphones, Laptop, Water Bottle")
                    && simpleResult.get("Isabella Green").equalsIgnoreCase("Blanket, Keyboard, Mouse, Smartphone")
                    && simpleResult.get("David Lee").equalsIgnoreCase("Belt, Headphones, Notebook, Wallet, Water Bottle")
                    && simpleResult.get("Frank Wilson").equalsIgnoreCase("Desk Lamp, Hat, Notebook, Pen");
        });
    }

}
