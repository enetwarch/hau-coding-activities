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
    final char character = getCharInput("Enter a character: ");
    System.out.printf("You entered: '%c'\n", character);

    scanner.close();
    System.exit(0);
  }

  // Initializes the scanner which will be used to get user input.
  private static final Scanner scanner = new Scanner(System.in);

  // A utility function that gets the user char input.
  // This method only prints the input prompt and returns the first character from the user input.
  private static char getCharInput(String inputPrompt) {
    System.out.printf("%s", inputPrompt);
    return scanner.nextLine().charAt(0);
  }
}
