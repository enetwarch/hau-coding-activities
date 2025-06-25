// Hugo P. Molina
// CS-102

// Imports the Scanner class which will be used in this program.
import java.util.Scanner;

// Initializes the Input class which follows the Input.java file name.
// This class has its own main method or entry point for the program to run.
// The program basically just asks the user's age and name and then prints it.
// This program has basic input validation to ensure correct data types and error handling.
// The user can only input 0 to 123 as their age because 123 years old is the current world record.
// After the program runs, the scanner will be closed and the program will be exited.
public class Input {
  @SuppressWarnings("ConvertToTryWithResources")
  public static void main(String[] args) {
    final String name = getStringInput("Enter your name: ");
    final int age = getIntInput("Enter your age: ", 0, 123);
  
    System.out.printf("You are %s and %d years old.\n", name, age);

    scanner.close();
    System.exit(0);
  }

  // Initializes the Scanner object here so the entire class can make use of it
  private static final Scanner scanner = new Scanner(System.in);

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
