# LAB Activity for January 21 2025 -- ARRAYS

## Activity: Java Arrays Practice

### Example 1: Initializing and Printing an Array

```java
public class ArrayExample1 {
    public static void main(String[] args) {
        // Declare and initialize an array
        int[] numbers = {10, 20, 30, 40, 50};
        
        // Print all elements of the array
        System.out.println("Array elements:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}
```

#### SAMPLE OUTPUT

```
Array elements: 10 20 30 40 50
```

### Example 2: Finding the Largest Element in an Array

```java
public class ArrayExample2 {
    public static void main(String[] args) {
        int[] numbers = {15, 22, 8, 19, 31};
        
        int largest = numbers[0];
        for (int num : numbers) {
            if (num > largest) {
                largest = num;
            }
        }
        
        System.out.println("The largest element in the array is: " + largest);
    }
}
```

#### SAMPLE OUTPUT

```
The largest element in the array is: 31
```

## Activity Instructions

**Array Operations (15 points)**

Write a Java program to do the following:

1. Create an array of 10 integers with values of your choice. (2 points)
2. Print all the elements of the array using a for loop. (3 points)
3. Find and print the smallest number in the array. (5 points)
4. Calculate and print the sum of all the elements in the array. (5 points)

***CLUES***

```java
public class Task1 {
    public static void main(String[] args) {
      

        // 1. Print all elements
       

        // 2. Find the smallest number
      

        // 3. Calculate the sum
      
        for (int num : numbers) {
         
        }
        System.out.println("Sum of elements: " + sum);
    }
}
```

LATE SUBMISSION

**20 points deductions**
