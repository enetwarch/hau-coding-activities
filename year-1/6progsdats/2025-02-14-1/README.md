# LAB Exam -- Midterm Period

## Lab Machine Problem:

**Employee Salary Management System**

## Objective:

Create a simple Java program that manages employee salaries. The program should:

1. **Store employee names and their monthly salaries** using an **`Array`**.
2. **Use `StringBuilder`** to efficiently build and display employee details.
3. **Use an `ArrayList`** to store multiple employee records dynamically.
4. **Implement method overloading** to allow adding salaries in different ways.

## Problem Statement:

Write a Java program that:

* Allows adding new employees with their salaries.
* Supports adding an employee’s salary either as a single value or multiple monthly salaries.
* Displays all employees along with their average salary.

```java
import java.util.ArrayList;

class Employee {
    private String name;
    private ArrayList<Double> salaries;

    // Constructor
    public Employee(String name) {
       // MISSING LINE OF CODE HERE
        this.salaries = new ArrayList<>();
    }

    // Method Overloading: Add a single salary
    public void addSalary(double salary) {
        salaries.add(         ); // MISSING PART HERE / INC. CODE
    }

    // Method Overloading: Add multiple salaries at once
    public void addSalary(double... salaryArray) {
        for (double salary : salaryArray) {
             .add(salary); // MISSING PART HERE
        }
    }

    // Calculate the average salary
    public double calculateAverageSalary() {
        if (salaries.isEmpty()) return 0;
        double sum = 0;
        for (double salary : salaries) {
            sum +=        ; // MISSING PART HERE / INC. CODE
        }
        return sum / salaries.size();
    }

    // Display employee details using StringBuilder
    public String getDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Employee: ").append(name).append("\nSalaries: ");
        
        for (double salary : salaries) {
            details.append(String.format("%.2f", salary)).append(" ");
        }
        
        details.append("\nAverage Salary: ").append(String.format("%.2f", calculateAverageSalary()));
        return details.toString();
    }
}

public class EmployeeSalaryManager {
    public static void main(String[] args) {
        // List to store employees
        ArrayList<Employee> employees = new ArrayList<>();

        // Adding employee records
        Employee emp1 = new Employee("Alice");
        emp1.addSalary(3000);
        emp1.addSalary(3200, 3100, 3050); // Method overloading
        employees.add(     ); // MISSING PART HERE / INC. CODE

        Employee emp2 = new Employee("Bob");
        emp2.addSalary(4000, 3900, 3950);
        employees.  (     ); // MISSING PART HERE / INC. CODE

        // Display all employee records
        for (Employee emp : employees) {
            System.out.println(emp.getDetails());
            // MISSING LINE OF CODE HERE
        }
    }
}
```

### Sample Output:

```
Employee: Alice
Salaries: 3000.00 3200.00 3100.00 3050.00 
Average Salary: 3087.50
----------------------
Employee: Bob
Salaries: 4000.00 3900.00 3950.00 
Average Salary: 3950.00
```
