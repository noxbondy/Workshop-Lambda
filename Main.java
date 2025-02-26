package parking;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("John", "Doe", LocalDate.of(1990, 5, 15), Gender.MALE),
                new Person("Jane", "Doe", LocalDate.of(1985, 8, 25), Gender.FEMALE),
                new Person("Alex", "Smith", LocalDate.of(2000, 12, 5), Gender.MALE)
        );

        // 1. Consumer<T> - Iterate and perform an action (print all persons)
        Consumer<Person> printPerson = person -> System.out.println(person);
        people.forEach(printPerson);

        // 2. Function<T, R> - Convert Person to a String (firstName and lastName)
        Function<Person, String> fullName = person -> person.getFirstName() + " " + person.getLastName();
        people.forEach(person -> System.out.println("Full Name: " + fullName.apply(person)));

        // 3. Predicate<T> - Filter persons by gender (female)
        Predicate<Person> isFemale = person -> person.getGender() == Gender.FEMALE;
        people.stream().filter(isFemale).forEach(person -> System.out.println("Female: " + person));

        // 4. Supplier<T> - Generate a random person
        Supplier<Person> randomPersonSupplier = () -> new Person("Random", "Person", LocalDate.now(), Gender.MALE);
        System.out.println("Random Person: " + randomPersonSupplier.get());

        // 5. BiConsumer<T, U> - Accept two arguments (firstName and lastName) and print them
        BiConsumer<String, String> printFullName = (firstName, lastName) -> System.out.println(firstName + " " + lastName);
        printFullName.accept("John", "Doe");

        // 6. BiFunction<T, U, R> - Combine firstName and lastName to form a full name
        BiFunction<String, String, String> combineNames = (firstName, lastName) -> firstName + " " + lastName;
        System.out.println("Combined Name: " + combineNames.apply("John", "Doe"));

        // 7. UnaryOperator<T> - Uppercase the first name
        UnaryOperator<String> uppercaseName = name -> name.toUpperCase();
        System.out.println("Uppercase Name: " + uppercaseName.apply("john"));

        // 8. BinaryOperator<T> - Combine two persons' first names
        BinaryOperator<String> combineFirstNames = (firstName1, firstName2) -> firstName1 + " & " + firstName2;
        System.out.println("Combined First Names: " + combineFirstNames.apply("John", "Jane"));
    }
}

