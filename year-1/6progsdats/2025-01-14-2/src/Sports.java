// Hugo P. Molina
// CS-102

// Imports that will be used throughout the program.
import java.util.Scanner;

// This class has its own main method or entry point for its own program.
// Most of the explanation for this program are abstracted to the different void methods below.
// Basically, the program asks which sport you like and based on what you choose, it will give a rough description.
// When the user presses 5 to exit, the program will close the scanner first and then get exited.
public class Sports {
  @SuppressWarnings("ConvertToTryWithResources")
  public static void main(String[] args) {
    while (true) {
      displayMenu();
      if (selectSport() == 5) break;

      inputBuffer();
      System.out.printf("\n");
    }

    scanner.close();
    System.exit(0);
  }

  // Initializes the scanner in private static keywords to make it accessible only throughout this class.
  private static final Scanner scanner = new Scanner(System.in);

  // A simple void menu whose sole purpose is to print the options available to the user.
  // This is a slight overabstraction in my opinion, but it is a requirement in the instructions.
  private static void displayMenu() {
    System.out.printf("Select your favorite sport:\n");
    System.out.printf("1. Basketball\n");
    System.out.printf("2. Football\n");
    System.out.printf("3. Tennis\n");
    System.out.printf("4. Cricket\n");
    System.out.printf("5. Exit\n");
  }

  // A practically void method, but this time it collects and handles the user input before returning it.
  // The way it handles the user input is that it basically prints out a brief description of the sport the user chose.
  // It is a slightly quirky method, but it will be bad in practice because of the sheer amount of side effects.
  // Once again, another overabstraction that would be fine and readable if it stayed in main (imo).
  private static int selectSport() {
    final int input = getIntInput("Enter your choice: ", 1, 5);

    switch (input) {
      case 1 -> basketball();
      case 2 -> football();
      case 3 -> tennis();
      case 4 -> cricket();
    }

    return input;
  }

  // The following will be void methods that will just print out the description of said sport.
  // These will be called by the selectSport() method in it's switch case.
  // They are simple and self explanatory methods, just reading the string is enough to describe them.

  private static void basketball() {
    System.out.printf("You selected Basketball! It's an exciting sport full of energy and teamwork.\n");
  }
  
  private static void football() {
    System.out.printf("You selected Football! A globally loved sport known for strategy, stamina, and passionate fans.\n");
  }

  private static void tennis() {
    System.out.printf("You selected Tennis! A fast-paced game of skill and agility, played in singles or doubles.\n");
  }

  private static void cricket() {
    System.out.printf("You selected Cricket! A bat-and-ball game rich in tradition and played across the world.\n");
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

  // A small void utility function that is designed for increased UX.
  // Before a large portion of print statements play, this function should be called.
  // It will give the user ample time to read the previous prints before moving on to another large set of prints.
  private static void inputBuffer() {
    System.out.printf("Press enter to continue. ");
    scanner.nextLine();
  }
}
