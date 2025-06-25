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
public class Job {
  @SuppressWarnings("ConvertToTryWithResources")
  public static void main(String[] args) {
    System.out.printf("INPUT VALUES\n");
    final double hourlyPayRate = getDoubleInput("Enter pay rate for every hour: $", 0, 522511.54);
    final double hoursWorked = getDoubleInput("Enter hours worked each week: ", 0, 168);

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

  // Initializes the scanner here to make it accessible throughout the entire class.
  private static final Scanner scanner = new Scanner(System.in);

  // A utility function that gets the user double input.
  // This function also includes input validation which is another requirement from the instructions.
  // Basically, the way this function works is it runs on an infinite loop until it returns a valid user input.
  // If the user input is valid, it will print out an error message and go back to the top of the loop agian.
  // Double.parseDouble() is used here to directly avoid the bugs from non-nextLine() scanner methods.
  private static double getDoubleInput(String inputPrompt, double min, double max) { 
    while (true) { 
      try {
        System.out.printf("%s", inputPrompt);
        final double input = Double.parseDouble(scanner.nextLine());
        
        if (input >= min && input <= max) return input;
        throw new NumberFormatException();
      } catch (NumberFormatException exception) {
        System.out.printf("INPUT ERROR. Only accepts values %,.2f to %,.2f.\n", min, max);
      }
    }
  }
}
