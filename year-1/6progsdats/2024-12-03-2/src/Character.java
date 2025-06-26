// Hugo P. Molina
// CS-102

// Imports the Scanner class which will be used in this program.
import java.util.Scanner;

// Initializes the Character class which follows the Character.java file name.
// This is a basic program that gets the first character of the user input and prints it.
// It then closes the scanner and exits afterwards.
public class Character {
  @SuppressWarnings("ConvertToTryWithResources")
  public static void main(String[] args) {
    final Scanner scanner = new Scanner(System.in);
    final char character = Input.getCharInput(scanner, "Enter a character: ");
    System.out.printf("You entered: '%c'\n", character);

    scanner.close();
    System.exit(0);
  }
}

// This class is here to provide utility and it contains input methods with validation.
// The Scanner object will be passed in every function here to apply the dependency injection pattern.
class Input {
  // A utility function that gets the user char input.
  // This method only prints the input prompt and returns the first character from the user input.
  // All trim does in this function is remove any whitespace the user might've accidentally inputted.
  public static char getCharInput(Scanner scanner, String inputPrompt) {
    System.out.printf("%s", inputPrompt);
    return scanner.nextLine().trim().charAt(0);
  }
}
