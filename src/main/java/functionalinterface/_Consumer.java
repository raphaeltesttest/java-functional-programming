package functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        // Normal java Function
        greetCustomer(new Customer("Maria", "99999"));
        greetCustomerV2(new Customer("Maria", "99999"), true);
        // Consumer Functional interface
        greetCustomerConsumer.accept(new Customer("Maria", "99999"));

        greetCustomerConsumerV2.accept(new Customer("Maria", "99999"), false);

    }
    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) ->
            System.out.println("hello " + customer.customerName +
                    ", thanks for registering number "
                    + (showPhoneNumber ? customer.customerPhoneNumber : "*****"));

    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("hello " + customer.customerName +
                    ", thanks for registering number "
                    + customer.customerPhoneNumber);

    static void greetCustomer(Customer customer) {
        System.out.println("hello " + customer.customerName +
                ", thanks for registering number "
                + customer.customerPhoneNumber);
    }

    static void greetCustomerV2(Customer customer, Boolean showPhoneNumber) {
        System.out.println("hello " + customer.customerName +
                ", thanks for registering number "
                + (showPhoneNumber ? customer.customerPhoneNumber : "*****"));
    }

    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
