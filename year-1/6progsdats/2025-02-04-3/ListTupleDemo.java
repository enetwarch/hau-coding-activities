// Hugo P. Molina
// CS-102

// Imports that will be used through the entire program.
import java.util.List;

// This class has a main method or entry point for its own program.
// The first line of main initializes a tuple-like structure using List.of() which makes an immutable data container.
// Object is the type passed in through the List generic because multiple different data types extend Object by default.
// This person list has 3 values with different data types, 2 Strings and 1 Integer.
// The following print code blocks just showcases how to access the data in the list through get(int index).
// After all of that, the program gets exited.
public class ListTupleDemo {
    public static void main(String[] args) {
        List<Object> person = List.of("John Doe", 25, "Software Engineer");

        System.out.printf("Name: %s\n", person.get(0));
        System.out.printf("Age: %s\n", person.get(1));
        System.out.printf("Job: %s\n", person.get(2));

        System.exit(0);
    }
}
