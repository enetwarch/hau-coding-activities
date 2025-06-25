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
public class Gift {
  @SuppressWarnings("ConvertToTryWithResources")
  public static void main(String[] args) {
    final String firstName = getStringInput("Enter your first name: ");
    final String lastName = getStringInput("Enter your last name: ");
    final int birthYear = getIntInput("Enter your year of birth: ", 1902, 2025);
    final String wantedGift = getStringInput("What gift do you want for Christmas?: ");

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

  // Initializes the scanner in private static keywords to make it accessible only throughout this class.
  private static final Scanner scanner = new Scanner(System.in);

  // A simple method that checks if something is even or not.
  // It uses the modulus operator to check for remainders in the integer if it is divided by 2.
  private static boolean isEven(int number) {
    return number % 2 == 0;
  }

  // A utility function that gets the user String input.
  // This method only prints the input prompt and returns the user input.
  // There are no input validations involved here because every user input is basically a string anyway.
  private static String getStringInput(String inputPrompt) {
    System.out.printf("%s", inputPrompt);
    return scanner.nextLine();
  }

  // A utility function that gets the user double input.
  // This function features input validation for when the user does not input an integer or when its out of range.
  // The function runs on an infinite loop that can only be broken when the user inputs a valid integer.
  // An error message will always be printed if the user insists on inputting an invalid integer.
  // Integer.parseInt() is used to remove the need to absorb the enter key on a non-nextLine() scanner method.
  private static int getIntInput(String inputPrompt, int min, int max) { 
    while (true) { 
      try {
        System.out.printf("%s", inputPrompt);
        final int input = Integer.parseInt(scanner.nextLine());
        
        if (input >= min && input <= max) return input;
        throw new NumberFormatException();
      } catch (NumberFormatException exception) {
        System.out.printf("INPUT ERROR. Only accepts values %d to %d.\n", min, max);
      }
    }
  }
}
