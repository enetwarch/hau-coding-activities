// Hugo P. Molina
// CS-102

// NOTE: The program will run with the bare minimum requirements from the instructions.

// Imports the Scanner class which will be used in this program.
import java.util.Scanner;

// Initializes the Character class which follows the Character.java file name.
public class Character {
  // Main entry point or method for the program to run.
  public static void main(String[] args) {
    // Initializes the scanner which will be used to get user input.
    @SuppressWarnings("ConvertToTryWithResources")
    final Scanner scanner = new Scanner(System.in);

    // Gets the character input from the user.
    System.out.print("Enter a character: ");
    final char character = scanner.nextLine().charAt(0);

    // Prints out the character the user inputted.
    System.out.printf("You entered: '%c'\n", character);

    // Closes the scanner and exits the program.
    scanner.close();
    System.exit(0);
  }
}
