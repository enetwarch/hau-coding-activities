# LAB Activities for Jan.14 2025

## Machine Lab Activity: Understanding and Using Methods in Java

### Objective:

* To understand how to define and call methods in Java.
* To use methods for modular programming by breaking problems into smaller, reusable components.

### Instructions:

1. Complete the examples provided below by implementing and executing the code.
2. After completing the examples, work on the activity tasks.
3. Submit the source code and screenshots of the output for all tasks.

## Example 1: Calculate the Area of a Circle

**Description:** Create a method called `calculateCircleArea` that takes the radius as a parameter and returns the area of the circle.

```java
public class CircleArea {
    public static void main(String[] args) {
        double radius = 5.5;
        double area = calculateCircleArea(radius);
        System.out.println("The area of the circle with radius " + radius + " is: " + area);
    }

    // Method to calculate the area of a circle
    public static double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }
}
```

## Example 2: Find the Maximum of Two Numbers

**Description:** Create a method called `findMax` that takes two integers as parameters and returns the larger number.

```java
public class MaxNumber {
    public static void main(String[] args) {
        int num1 = 45, num2 = 78;
        int max = findMax(num1, num2);
        System.out.println("The maximum of " + num1 + " and " + num2 + " is: " + max);
    }

    // Method to find the maximum of two numbers
    public static int findMax(int a, int b) {
        return (a > b) ? a : b;
    }
}
```

## Machine Lab Activity: Select Your Favorite Sport

### Problem Description:

Write a Java program that asks the user to select their favorite sport from a menu. Use methods to organize the program into reusable components. Each sport should have its own method that prints a message about the selected sport.

### Requirements:

1. Create a method `displayMenu` to show the user a list of sports to choose from.
2. Create a method for each sport that prints a message describing why it's an exciting sport.
3. Create a method selectSport to handle the user’s input and call the corresponding sport method.
4. The program should exit gracefully if the user inputs an invalid choice.

Solution Code: (**clues only**)

```java
import java.util.Scanner;

public class FavoriteSport {
    public static void main(String[] args) {
        selectSport();
    }

    // Method to display the menu
    public static void displayMenu() {
        System.out.println("Select your favorite sport:");
        System.out.println("1. Basketball");
        System.out.println("2. Football");
        System.out.println("3. Tennis");
        System.out.println("4. Cricket");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    // Method to handle user input and call the respective sport method
    public static void selectSport() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            choice = scanner.nextInt();

          
                System.out.println("Thank you for using the program. Goodbye!");
              

                System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    // Method for basketball
    public static void basketball() {
        System.out.println("You selected Basketball! It's an exciting sport full of energy and teamwork.");
    }

    // Method for football
 

    // Method for tennis
 

    // Method for cricket
```

### Sample Output:

#### Case 1: Selecting a sport

```
Select your favorite sport:
1. Basketball
2. Football
3. Tennis
4. Cricket
5. Exit
Enter your choice: 2
You selected Football! The thrill of goals and the passion of fans make it amazing.
```

#### Case 2: Invalid input

```
Select your favorite sport:
1. Basketball
2. Football
3. Tennis
4. Cricket
5. Exit
Enter your choice: 6
Invalid choice. Please try again.
```

#### Case 3: Exit the program

```
Select your favorite sport:
1. Basketball
2. Football
3. Tennis
4. Cricket
5. Exit
Enter your choice: 5
Thank you for using the program. Goodbye!
```

### Explanation of the Program:

The `displayMenu` method organizes the code for showing the options to the user. Each sport has its own method (basketball, football, tennis, and cricket) with a specific message. The `selectSport` method handles user input using a `do-while` loop to ensure the menu reappears until the user chooses to exit.
