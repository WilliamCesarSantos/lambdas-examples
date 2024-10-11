package br.ada.tech.class1171.practices.ecommerce;

import br.ada.tech.class1171.practices.Reviewer;
import br.ada.tech.class1171.practices.ecommerce.customer.Customer;
import br.ada.tech.class1171.practices.ecommerce.order.Order;

import java.util.Comparator;

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
        reviewer.valid("amountEachCustomerBought", practices::amountEachCustomerBought, result ->
                false
        );

        System.out.println("-----------------------------");
        reviewer.valid("customerWhoBoughtTheMostTimes", practices::customerWhoBoughtTheMostTimes, result ->
                false
        );

        System.out.println("-----------------------------");
        reviewer.valid("customerWhoPlacedExpensiveOrder", practices::customerWhoPlacedExpensiveOrder, result ->
                false
        );

        System.out.println("-----------------------------");
        reviewer.valid("howManyTimesEachProductWasSales", practices::howManyTimesEachProductWasSales, result ->
                false
        );

        System.out.println("-----------------------------");
        reviewer.valid("totalValueObtainedFromTheSalesOfEachProduct", practices::totalValueObtainedFromTheSalesOfEachProduct, result ->
                false
        );

        System.out.println("-----------------------------");
        reviewer.valid("productThatMostSold", practices::productThatMostSold, result ->
                false
        );

        System.out.println("-----------------------------");
        reviewer.valid("productThatSoldTheLeast", practices::productThatSoldTheLeast, result ->
                false
        );

        System.out.println("-----------------------------");
        reviewer.valid("productsThatWerePurchasedByCustomer", practices::productsThatWerePurchasedByCustomer, result ->
                false
        );
    }

}
