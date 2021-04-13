package optionals;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Object value = Optional.ofNullable(null)
                .orElseGet(() -> "default value");

        System.out.println(value);


//        Supplier<IllegalStateException> exception = () -> new IllegalStateException("exception");
//        Object value1 = Optional.ofNullable(null)
//                .orElseThrow(exception);

        Consumer<String> stringConsumer = vl -> {
            System.out.println(vl);
        };
        Optional.ofNullable("Hello")
                .ifPresent(stringConsumer);

        Optional.ofNullable("john@gmail.com")
                .ifPresentOrElse(email -> System.out.println("Sending email to " + email),
                            () -> {
                                System.out.println("Cannot send email");
                            });

        Optional.ofNullable(null)
                .ifPresentOrElse(email -> System.out.println("Sending email to " + email),
                        () ->  System.out.println("Cannot send email"));
    }
}
