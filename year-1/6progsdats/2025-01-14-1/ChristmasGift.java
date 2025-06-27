// Hugo P. Molina
// CS-102

// Imports that will be used throughout the program.
import java.util.Scanner;

// This class has its own main method or entry point for its own program.
// This is a simple program that asks various details about the user and prints them out plus some extra.
// The program first asks for the user's first name, lastname, birth year, and wanted gift in Christmas.
// The birth year can only be between 1902 to 2025 (current year) because 123 is the oldest person world record.
// Age is then calculated by subtracting the current year(2025) to the birth year.
// Parity is checked by isEven() method and uses a ternary operator to get "even" or "odd" based on the boolean value.
// The output mirroring the sample output will then be printed.
// After that, the scanner will be closed and the program will be exited.
public class ChristmasGift {
  @SuppressWarnings("ConvertToTryWithResources")
  public static void main(String[] args) {
    final Scanner scanner = new Scanner(System.in);

    final String firstName = Input.getStringInput(scanner, "Enter your first name: ");
    final String lastName = Input.getStringInput(scanner, "Enter your last name: ");
    final int birthYear = Input.getIntInput(scanner, "Enter your year of birth: ", 1902, 2025);
    final String wantedGift = Input.getStringInput(scanner, "What gift do you want for Christmas?: ");

    final int age = 2025 - birthYear;
    final String parity = isEven(age) ? "even" : "odd";

    System.out.printf("\n");
    System.out.printf("Hi %s %s.\n", firstName, lastName);
    System.out.printf("You are %d years old.\n", age);
    System.out.printf("Your age is an %s number.\n", parity);
    System.out.printf("%s is/are your gift this Christmas!\n", wantedGift);

    scanner.close();
    System.exit(0);
  }

  // A simple method that checks if something is even or not.
  // It uses the modulus operator to check for remainders in the integer if it is divided by 2.
  private static boolean isEven(int number) {
    return number % 2 == 0;
  }
}

// This class is here to provide utility and it contains input methods with validation.
// The Scanner object will be passed in every function here to apply the dependency injection pattern.
class Input {
  // A utility function that gets the user integer input.
  // This function features input validation for when the user does not input an integer or when its out of range.
  // The function runs on an infinite loop that can only be broken when the user inputs a valid integer.
  // A predetermined error message will always be printed if the user insists on inputting an invalid integer.
  // Integer.parseInt() is used to remove the need to absorb the enter key on a non-nextLine() scanner method.
  // The thrown exception has a message for readability, but the catch block will print its own message.
  public static int getIntInput(Scanner scanner, String inputPrompt, int min, int max) { 
    while (true) { 
      try {
        System.out.printf("%s", inputPrompt);
        final int input = Integer.parseInt(scanner.nextLine());
        
        if (input >= min && input <= max) return input;
        throw new IllegalArgumentException("Invalid input.");
      } catch (IllegalArgumentException exception) {
        System.out.printf("INPUT ERROR. Only accepts values %d to %d.\n", min, max);
      }
    }
  }

  // A utility function that gets the user String input.
  // This method only prints the input prompt and returns the user input.
  // There are no input validations involved here because every user input is basically a string anyway.
  // The trim method removes excess whitespace the user might've accidentally inputted.
  public static String getStringInput(Scanner scanner, String inputPrompt) {
    System.out.printf("%s", inputPrompt);
    return scanner.nextLine().trim();
  }
}
