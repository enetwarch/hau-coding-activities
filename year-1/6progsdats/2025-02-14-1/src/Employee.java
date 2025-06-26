// Hugo P. Molina
// CS-102

// Imports that will be used throughout this file.
import java.util.ArrayList;

// This class is a data container and will only be used to instantiate objects.
// There are plenty of missing lines of code in here according to the instructions.
// The function headers will explain what the missing lines were.
public class Employee {
  private final String name;
  private final ArrayList<Double> salaries;

  // This constructor has a missing line for the name field.
  public Employee(String name) {
    this.name = name;
    this.salaries = new ArrayList<>();
  }

  // This method has another overload counterpart but this one only adds one salary.
  // This method's missing code here is the insertion of the salary argument to the ArrayList.
  // NOTE: I also added return this; to make the method chainable.
  public Employee addSalary(double salary) {
    this.salaries.add(salary);
    return this;
  }

  // This is the other overload method from the previous method, and it takes in multiple doubles as parameter.
  // The double... type is a varargs parameter, it takes in the excess double types and compresses it to an array.
  // The missing code in this method is the missing this.salaries before the .add() ArrayList method.
  // NOTE: I also added return this; to make the method chainable.
  public Employee addSalary(double... salaryArray) {
    for (double salary : salaryArray) {
      this.salaries.add(salary);
    }

    return this;
  }

  // This method calculates the average salary based on the the elements inside this.salaries double ArrayList.
  // The method returns a 0 early if the ArrayList is empty, otherwise it sums up the salaries and divides it by the amount.
  // The missing code in this method is the salary in the addition assignment operator in the for loop.
  // Stream API can be used to make this code a one-liner, but this method needs to fill in missing code.
  public double calculateAverageSalary() {
    if (this.salaries.isEmpty()) return 0;

    double sum = 0;
    for (double salary : this.salaries) {
      sum += salary;
    }

    return sum / this.salaries.size();
  }

  // This method uses StringBuilder to fluently stringify the Employee details.
  // There are no missing lines of code here but I decided to refactor it to make it completely method chained.
  // Builder objects are normally supposed to be used as method chain fodder with a .build() at the end.
  // In the case of StringBuilder, the build() is changed to toString() to return a string value.
  // Or at least, that is how the builder method in programming works, which StringBuilder seems to follow.
  public String getDetails() {
    return new StringBuilder()
      .append(String.format("Employee: %s\n", this.name))
      .append(String.format("Salaries: %s\n", this.salaries))
      .append(String.format("Average Salary: %,.2f\n", this.calculateAverageSalary()))
      .toString();
  }
}
