// Hugo P. Molina
// CS-102

// Imports that will be used throughout the file.
import java.util.ArrayList;

// This class acts as the main entry point of the program and an object blueprint.
// I made some changes outside of the requirements in the instructions to shorten the amount of lines.
// I also renamed some variable names to make them more semantic and distinguishable.
// Most of the explanation for this program is in the Employee class.
// The main method here just showcases how to use the Employee object and how to store them in an ArrayList dynamically.
// First of all, the missing code here are all just missing ArrayList methods or arguments.
// The changes I made here is that I modified Employee to return this, making it chainable.
// The method chain on these employee objects make it easier to read and fluently modify.
// After making all the Employees, their details are all printed out but it does not completely follow the sample output.
// Lastly, the program exits.
public class SalaryManager {
  public static void main(String[] args) {
    final ArrayList<Employee> employees = new ArrayList<>();

    final Employee alice = new Employee("Alice")
      .addSalary(3000)
      .addSalary(3200, 3100, 3050);
    employees.add(alice);

    final Employee bob = new Employee("Bob")
      .addSalary(4000, 3900, 3950);
    employees.add(bob);

    for (final Employee employee : employees) {
      System.out.printf("%s", employee.getDetails());
    }

    System.exit(0);
  }
}

// These are the data fields that will be used to instantiate the objects.
// There are plenty of missing lines of code in here according to the instructions.
// The function headers will explain what the missing lines were.
class Employee {
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
