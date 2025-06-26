# LAB Activity -- February 18 2025 -- File I/O and Intro to OOP

## JAVA Exception Handling, File I/O and Objects and Classes (Introduction to Object Oriented Programming)

### 1. Exception Handling in Java

**Exception handling** allows a program to deal with runtime errors gracefully rather than crashing. Java provides a robust exception-handling mechanism using:

**try-catch block** – Handles exceptions gracefully

```java
try {
    int result = 10 / 0; // ArithmeticException
} catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero!");
}
```

**finally block** – Always executes, used for cleanup

```java
try {
    File file = new File("test.txt");
} catch (Exception e) {
    System.out.println("An error occurred.");
} finally {
    System.out.println("This block always executes.");
}
```

**throw and throws** – Used to explicitly throw exceptions

```java
void checkAge(int age) throws IllegalArgumentException {
    if (age < 18) {
        throw new IllegalArgumentException("Underage!");
    }
}
```

### 2. File I/O in Java

Java provides the java.io and java.nio packages for file handling.

#### Reading a file using Scanner

```java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {
        try {
            File file = new File("example.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}
```

#### Writing to a file using FileWriter

```java
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("example.txt");
            writer.write("Hello, world!");
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
}
```

### 3. Objects and Classes (Introduction to OOP in Java)

Java follows the Object-Oriented Programming (OOP) paradigm. Key concepts include:

#### Class & Object

```java
class Car {
    String model;
    int year;
    
    Car(String model, int year) {
        this.model = model;
        this.year = year;
    }

    void display() {
        System.out.println("Car: " + model + ", Year: " + year);
    }
}

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", 2022);
        car1.display();
    }
}
```

#### Encapsulation (Using private fields and getters/setters)

```java
class Person {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
```

#### Inheritance (Extending a class)

```java
class Animal {
    void makeSound() {
        System.out.println("Some sound...");
    }
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("Bark!");
    }
}
```

#### Polymorphism (Method Overriding)

```java
class Animal {
    void makeSound() {
        System.out.println("Animal sound");
    }
}

class Cat extends Animal {
    void makeSound() {
        System.out.println("Meow!");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myAnimal = new Cat();
        myAnimal.makeSound();
    }
}
```

===========================================================

## Activity: Employee Management System

This activity integrates **Exception Handling, File I/O, and OOP** in Java.

### Task:

1. Create an `Employee` class with attributes like `id`, `name`, and `salary`.
2. Implement methods to:
  * Write employee data to a file.
  * Read and display employee data from the file.
  * Handle exceptions properly.

### Java Code: Employee Management System


```java
import java.io.*;
import java.util.Scanner;

// Employee Class
class Employee {
    private int id;
    private String name;
    private double salary;

    // Constructor
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Method to save employee data to file
    public void saveToFile(String filename) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(id + "," + name + "," + salary + "\n");
            System.out.println("Employee data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Static method to read employee data from file
    public static void readFromFile(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            System.out.println("\nEmployee Data from File:");
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                System.out.println("ID: " + data[0] + ", Name: " + data[1] + ", Salary: " + data[2]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}

// Main class
public class EmployeeManagement {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String filename = "employees.txt";

        try {
            System.out.print("Enter Employee ID: ");
            int id = input.nextInt();
            input.nextLine(); // Consume newline

            System.out.print("Enter Employee Name: ");
            String name = input.nextLine();

            System.out.print("Enter Employee Salary: ");
            double salary = input.nextDouble();

            // Create Employee object and save data to file
            Employee emp = new Employee(id, name, salary);
            emp.saveToFile(filename);

            // Read and display data from file
            Employee.readFromFile(filename);

        } catch (Exception e) {
            System.out.println("Invalid input! " + e.getMessage());
        } finally {
            input.close();
            System.out.println("\nProgram execution completed.");
        }
    }
}
```

### Expected Output (Example Run)

#### User Input:

```
Enter Employee ID: 101
Enter Employee Name: John Doe
Enter Employee Salary: 50000
```

#### Output in Console:

```
Employee data saved successfully.

Employee Data from File:
ID: 101, Name: John Doe, Salary: 50000.0

Program execution completed.
```

#### File (employees.txt) Contents After Execution:

```
101,John Doe,50000.0
```
