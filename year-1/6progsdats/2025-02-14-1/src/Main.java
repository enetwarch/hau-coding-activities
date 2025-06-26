// Hugo P. Molina
// CS-102

// Imports that will be used throughout the file.
import java.util.ArrayList;

// This class is the main entry point of the program.
// I made some changes outside of the requirements in the instructions to shorten the amount of lines.
// I also renamed some variable names to make them more semantic and distinguishable.
// Most of the explanation for this program is in the Employee class.
// The main method here just showcases how to use the Employee object and how to store them in an ArrayList dynamically.
// First of all, the missing code here are all just missing ArrayList methods or arguments.
// The changes I made here is that I modified Employee to return this, making it chainable.
// The method chain on these employee objects make it easier to read and fluently modify.
// After making all the Employees, their details are all printed out but it does not completely follow the sample output.
// Lastly, the program exits.
public class Main {
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
