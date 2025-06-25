// Hugo P. Molina
// CS-102

// NOTE: This program will run with the bare minimum requirements from the instructions.

// Imports the Scanner class.
import java.util.Scanner;

// Creates the Job class which follows the Job.java file name.
public class Job {
  // Main method of the class which is entry point for the program. 
  public static void main(String[] args) {
    // Initializes the imported scanner class into an object.
    @SuppressWarnings("ConvertToTryWithResources")
    final Scanner scanner = new Scanner(System.in);

    // Main header of the program which prompts the user to input pay rate and hours worked.
    System.out.printf("INPUT VALUES\n");
    System.out.printf("Enter pay rate for every hour: $");
    final double payRate = scanner.nextDouble();
    System.out.printf("Enter hours worked each week: ");
    final double hoursWorked = scanner.nextDouble();

    // Calculates the necessary values based on the formula on the instructions.
    final double incomeBeforeTax = payRate * hoursWorked * 5;
    final double incomeAfterTax = incomeBeforeTax * .86;
    final double moneySpentOnClothes = incomeAfterTax * .1;
    final double moneySpentOnSchool = incomeAfterTax * .01;
    final double moneySpentOnGroceries = (incomeAfterTax - moneySpentOnClothes - moneySpentOnSchool) * .25;
    final double totalMoneySpent = moneySpentOnClothes + moneySpentOnSchool + moneySpentOnGroceries;
    final double remainingMoney = incomeAfterTax - totalMoneySpent;

    // Prints out the final output of the program based on the instructions.
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

    // Closes the scanner and exits the program.
    scanner.close();
    System.exit(0);
  }
}
