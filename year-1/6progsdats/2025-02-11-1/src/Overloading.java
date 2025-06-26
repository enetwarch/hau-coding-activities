// Hugo P. Molina
// CS-102

// Imports that wil be used throughout the file.
import java.util.Scanner;

// This class has a main method or entry point for its own program.
// The instructions basically just tells us to apply at least one type of overloading.
// In this example, I just reused the input get input methods I normally use in my other activities.
// The difference this time is they are all named the same but have different paramters and return types.
// By doing that, method overloading is applied in the getInput() method.
// The method that will be used will depend on the inserted arguments.
// The main method here has a simple flow which is just a copy pasted version of a previous activity.
// After this simple program finishes running, the scanner will be closed and the program will be exited.
public class Overloading {
  @SuppressWarnings("ConvertToTryWithResources")
  public static void main(String[] args) {
    final String name = getInput("Enter your name: ");
    final int age = getInput("Enter your age: ", 0, 123);

    System.out.printf("Hi %s! You are %d years old.\n", name, age);

    scanner.close();
    System.exit(0);
  }

  // The Scanner object is initialized here to make it accessible in all of the methods in this class.
  private static final Scanner scanner = new Scanner(System.in);

  // The following methods are the ones I always use in the previous activities.
  // They are input methods that have input validation in them, but method overloading is applied this time.
  // Read the class header for more details about method overloading.

  // A utility function that gets the user String input.
  // This method only prints the input prompt and returns the user input.
  // There are no input validations involved here because every user input is basically a string anyway.
  private static String getInput(String inputPrompt) {
    System.out.printf("%s", inputPrompt);
    return scanner.nextLine();
  }

  // A utility function that gets the user double input.
  // This function features input validation for when the user does not input an integer or when its out of range.
  // The function runs on an infinite loop that can only be broken when the user inputs a valid integer.
  // An error message will always be printed if the user insists on inputting an invalid integer.
  // Integer.parseInt() is used to remove the need to absorb the enter key on a non-nextLine() scanner method.
  private static int getInput(String inputPrompt, int min, int max) { 
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
