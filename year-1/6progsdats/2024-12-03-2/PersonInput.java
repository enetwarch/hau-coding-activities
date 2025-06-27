// Hugo P. Molina
// CS-102

// Imports the Scanner class which will be used in this program.
import java.util.Scanner;

// This class has its own main method or entry point for the program to run.
// The program basically just asks the user's age and name and then prints it.
// This program has basic input validation to ensure correct data types and error handling.
// The user can only input 0 to 123 as their age because 123 years old is the current world record.
// After the program runs, the scanner will be closed and the program will be exited.
public class PersonInput {
  @SuppressWarnings("ConvertToTryWithResources")
  public static void main(String[] args) {
    final Scanner scanner = new Scanner(System.in);

    final String name = Input.getStringInput(scanner, "Enter your name: ");
    final int age = Input.getIntInput(scanner, "Enter your age: ", 0, 123);
  
    System.out.printf("You are %s and %d years old.\n", name, age);

    scanner.close();
    System.exit(0);
  }
}

// This class is here to provide utility and it contains input methods with validation.
// The Scanner object will be passed in every function here to apply the dependency injection pattern.
class Input {
  // A utility function that gets the user String input.
  // This method only prints the input prompt and returns the user input.
  // There are no input validations involved here because every user input is basically a string anyway.
  // The trim method removes excess whitespace the user might've accidentally inputted.
  public static String getStringInput(Scanner scanner, String inputPrompt) {
    System.out.printf("%s", inputPrompt);
    return scanner.nextLine().trim();
  }

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
}
