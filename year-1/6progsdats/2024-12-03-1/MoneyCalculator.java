// Hugo P. Molina
// CS-102

// Imports the Scanner class which will be used in the program to get user input.
import java.util.Scanner;

// Creates the Job class which follows the Job.java file name.
// This class has its own main method that will act as the entry point for the program.
// The program will first ask the user some details regarding their pay rate and hours work each week.
// User input will have some basic validation to make sure no errors will be thrown during runtime.
// The user can only input 0 to 522,511.54 in hourly pay rate because that much USD/hour is the world record.
// The user can only input 0 to 168 in the hours worked each week because there are only that many hours in a week.
// Calculations will then be made on income, money spent and remaining money all based on the instruction's formula.
// These calculated values will then be printed in a neat output.
// The program will then finish executing, the scanner will be closed and the program will be exited.
public class MoneyCalculator {
  @SuppressWarnings("ConvertToTryWithResources")
  public static void main(String[] args) {
    final Scanner scanner = new Scanner(System.in);

    System.out.printf("INPUT VALUES\n");
    final double hourlyPayRate = Input.getDoubleInput(scanner, "Enter pay rate for every hour: $", 0, 522511.54);
    final double hoursWorked = Input.getDoubleInput(scanner, "Enter hours worked each week: ", 0, 168);

    final double incomeBeforeTax = hourlyPayRate * hoursWorked * 5;
    final double incomeAfterTax = incomeBeforeTax * .86;
    final double moneySpentOnClothes = incomeAfterTax * .1;
    final double moneySpentOnSchool = incomeAfterTax * .01;
    final double moneySpentOnGroceries = (incomeAfterTax - moneySpentOnClothes - moneySpentOnSchool) * .25;
    final double totalMoneySpent = moneySpentOnClothes + moneySpentOnSchool + moneySpentOnGroceries;
    final double remainingMoney = incomeAfterTax - totalMoneySpent;

    System.out.printf("\n");
    System.out.printf("INCOME\n");
    System.out.printf("\tBefore tax: $%,.2f\n", incomeBeforeTax);
    System.out.printf("\tAfter tax: $%,.2f\n", incomeAfterTax);
    System.out.printf("MONEY SPENT\n");
    System.out.printf("\tClothes: $%,.2f\n", moneySpentOnClothes);
    System.out.printf("\tSchool: $%,.2f\n", moneySpentOnSchool);
    System.out.printf("\tGroceries: $%,.2f\n", moneySpentOnGroceries);
    System.out.printf("\tTotal spent: $%,.2f\n", totalMoneySpent);
    System.out.printf("\tRemaining money: $%,.2f\n", remainingMoney);

    scanner.close();
    System.exit(0);
  }
}

// This class is here to provide utility and it contains input methods with validation.
// The Scanner object will be passed in every function here to apply the dependency injection pattern.
class Input {
  // A utility function that gets the user double input.
  // This function also includes input validation for when the user does not input a double or is out of bounds.
  // Basically, the way this function works is it runs on an infinite loop until it returns a valid user input.
  // If the user input is valid, it will print out an error message and go back to the top of the loop again.
  // Double.parseDouble() is used here to directly avoid the bugs from non-nextLine() scanner methods.
  // The thrown exception has a message for readability, but the catch block will print its own message.
  public static double getDoubleInput(Scanner scanner, String inputPrompt, double min, double max) { 
    while (true) { 
      try {
        System.out.printf("%s", inputPrompt);
        final double input = Double.parseDouble(scanner.nextLine().trim());
        if (input >= min && input <= max) return input;

        System.out.printf("INPUT ERROR. Please input a value between %,.2f to %,.2f.\n", min, max);
      } catch (NumberFormatException exception) {
        System.out.printf("INPUT ERROR. Please input a double value.");
      }
    }
  }
}
