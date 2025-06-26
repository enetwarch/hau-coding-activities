// Hugo P. Molina
// CS-102

// Imports the scanner class that will be used in this program.
import java.util.Scanner;

// This class has its own main method or entry point for its own progrma to run.
// This is a simple program that asks for the user's grades and prints the program's evaluation of it.
// The program first asks the user their grades which can only be within 50 to 100 due to input validation.
// An if else if chain will then run and the program will print an evaluation based on the user's grades.
// These evaluation messages are all based on the instructions and sample output.
// The program will then close the scanner and be exited.
public class Grade {
  @SuppressWarnings("ConvertToTryWithResources")
  public static void main(String[] args) {
    final Scanner scanner = new Scanner(System.in);
    final int grades = Input.getIntInput(scanner, "Enter your grades: ", 50, 100);

    if (grades >= 95 && grades <= 100) {
      System.out.printf("Your are Excellent!\n");
    } else if (grades >= 90 && grades <= 94) {
      System.out.printf("You are Remarkable!\n");
    } else if (grades >= 85 && grades <= 89) {
      System.out.printf("You are Average.\n");
    } else if (grades >= 50 && grades <= 84) {
      System.out.printf("Study well.\n");
    } else {
      System.out.printf("Your grades canbit be below 50 or above 100.\n");
    }

    scanner.close();
    System.exit(0);
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
      } catch (NumberFormatException exception) {
        System.out.printf("INPUT ERROR. Only accepts values %d to %d.\n", min, max);
      }
    }
  }
}
