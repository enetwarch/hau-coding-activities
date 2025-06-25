// Hugo P. Molina
// CS-102

// NOTE: The program will run with the bare minimum requirements from the instructions.

// Imports the Scanner class which will be used in this program.
import java.util.Scanner;

public class Input {
  // Main entry point for the program.
  public static void main(String[] args) {
    // Initializes the scanner object to get the user input.
    @SuppressWarnings("ConvertToTryWithResources")
    final Scanner scanner = new Scanner(System.in);

    // Gets the user's age in int format.
    System.out.print("Enter your age: ");
    final int age = scanner.nextInt();
    // This is here to absorb the enter from the user input after scanner.nextInt().
    scanner.nextLine();

    // Gets the user's name in String format.
    System.out.print("Enter your name: ");
    final String name = scanner.nextLine();

    // Prints out the name and age of the user.
    System.out.printf("You are %s and %d years old.\n", name, age);

    // Closes the scanner and exits the program.
    scanner.close();
    System.exit(0);
  }
}
