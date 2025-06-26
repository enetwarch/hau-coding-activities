// Hugo P. Molina
// CS-102

// Imports that will be used throughout the file
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// This class is the main entry point of the program.
// The main point of this activity is to be able to know how to use the I/O package.
// Learning about file manipulation classes like FileWriter, FileReader, and even Scanner is required.
// In this activity, FileReader was not used because it needs more low level control compared to Scanner.
// No Lists or any dynamic array data types will be used to make sure everything will be done using the I/O library.
// The program flow is basically just: add an employee -> read the file -> exit.
// It only fulfills the C and R in CRUD (Create, Read, Update, and Delete).
// After that, the scanner will be close and the program will be exited.
public class Management {
  @SuppressWarnings("ConvertToTryWithResources")
  public static void main(String[] args) {
    final Scanner scanner = new Scanner(System.in);
    final String fileName = "employees.csv";

    final Employee employee = new Employee()
      .setId(Input.getIntInput(scanner,  "Enter employee ID: ", 0, Integer.MAX_VALUE))
      .setName(Input.getStringInput(scanner, "Enter employee name: "))
      .setSalary(Input.getDoubleInput(scanner, "Enter employee salary: ", 0, Double.MAX_VALUE));

    addEmployee(employee, fileName);
    System.out.printf("\n");
    readFile(fileName);
    System.out.printf("\n");

    System.out.printf("Program execution completed.\n");
    scanner.close();
    System.exit(0);
  }

  // This method takes in an Employee object, and adds its data to the last line of the file in CSV format.
  // Edge cases like errors are catched in the try-catch blocks for error handling.
  private static void addEmployee(Employee employee, String fileName) {
    try (final FileWriter fileWriter = new FileWriter(fileName, true)) {
      fileWriter.write(String.format("%s,%s,%s\n", employee.getId(), employee.getName(), employee.getSalary()));

      System.out.printf("Employee data saved successfully.\n");
    } catch (IOException exception) {
      System.out.printf("Error writing to file: %s\n", exception.getMessage());
    }
  }

  // This method reads the file based from the passed in fileName argument.
  // It assumes that the file is correct and has 3 values each line, following the data types of the Employee object.
  // It reads through every line of the file and prints out all the data in a neat format based from the sample output.
  // Edge cases are handled gracefully by the try-catch block.
  private static void readFile(String fileName) {
    try (final Scanner scanner = new Scanner(new File(fileName))) {
      System.out.printf("Employee data from file \"%s\":\n", fileName);
      while (scanner.hasNextLine()) {
        final String[] values = scanner.nextLine().split(",");
        System.out.printf("ID: %s, Name: %s, Salary: %s\n", values[0], values[1], values[2]);
      }
    } catch (FileNotFoundException exception) {
      System.out.printf("File not found: %s\n", exception.getMessage());
    }
  }
}

// This class is just a data container that will only be used as an object.
// It has the necessary fields required from the instructions and sample output.
class Employee {
  private int id;
  private String name;
  private double salary;

  // The following code will be standard Java boilerplate for constructors, getters and setters.
  // There are two constructors to allow empty or direct initialization for extra flexibility.

  protected Employee() {
    this.id = 0;
    this.name = "Unknown";
    this.salary = 0;
  }

  protected Employee(int id, String name, double salary) {
    this.id = id;
    this.name = name;
    this.salary = salary;
  }

  // The setter methods will return this to allow fluent method chaining and mutation of the Employee object.
  // It practically still acts like void, receiving (this) is very much optional and is only there for chaining.
  // This follows a semi-builder pattern, but it is not recommended for actual codebases because of mutability.
  // I only wrote it like this because making an actual builder is too much boilerplate for a simple school activity.

  public Employee setId(int id) {
    this.id = id;
    return this;
  }

  public Employee setName(String name) {
    this.name = name;
    return this;
  }

  public Employee setSalary(double salary) {
    this.salary = salary;
    return this;
  }

  public int getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public double getSalary() {
    return this.salary;
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

  // A utility function that gets the user String input.
  // This method only prints the input prompt and returns the user input.
  // There are no input validations involved here because every user input is basically a string anyway.
  // The trim method removes excess whitespace the user might've accidentally inputted.
  public static String getStringInput(Scanner scanner, String inputPrompt) {
    System.out.printf("%s", inputPrompt);
    return scanner.nextLine().trim();
  }

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
        final double input = Double.parseDouble(scanner.nextLine());
        
        if (input >= min && input <= max) return input;
        throw new IllegalArgumentException("Invalid input.");
      } catch (NumberFormatException exception) {
        System.out.printf("INPUT ERROR. Only accepts values %,.2f to %,.2f.\n", min, max);
      }
    }
  }

  // A utility function that gets the user input in boolean form.
  // The input validation step for this method is that it only accepts fixed values which are:
  // "y" or "yes" (true) and "n" or "no" (false) all of which are case-insensitive and whitespace safe due to trim.
  // It will print an error message otherwise and loop back in this infinite loop.
  public static boolean getBooleanInput(Scanner scanner, String inputPrompt) {
    while (true) {
      System.out.printf("%s", inputPrompt);
      final String input = scanner.nextLine().trim().toLowerCase();

      if (input.equals("y") || input.equals("yes")) return true;
      if (input.equals("n") || input.equals("no")) return false;

      System.out.printf("INPUT ERROR. Only accepts values 'y' and 'n'.\n");
    }
  }
}
