# LAB Activity -- February 11 2025 -- MethodOverloading

## Method Overloading

**Method overloading** in Java is a feature that allows a class to have more than one method with the same name, as long as their parameter lists (also known as method signatures) differ. This means that you can define multiple methods to perform similar tasks but with different types or numbers of inputs.

## Key Points of Method Overloading

1. **Different Parameter Lists:**

Overloaded methods must have different parameter lists. This can be achieved by:

**Different Number of Parameters:**

```java
public void display() { }
public void display(String message) { }
```

**Different Data Types:**

```java
public void print(int number) { }
public void print(double number) { }
```

**Different Order of Parameters (when types differ):**

```java
public void process(int id, String name) { }
public void process(String name, int id) { }
```

2. **Return Type is Not Sufficient:**

Overloading cannot be achieved by only changing the return type of methods. The compiler differentiates overloaded methods based on their name and parameter list, not the return type.

3. **Compile-Time Resolution:**

Method overloading is resolved at compile time. The Java compiler determines which method to invoke based on the method signature that best matches the arguments passed during the call.

4. **Usage with Constructors:**

Method overloading is also applied to constructors. A class can have multiple constructors with different parameter lists to allow objects to be created in different ways.

```java
public class Person {
    private String name;
    private int age;
    
    // No-argument constructor
    public Person() {
        this.name = "Unknown";
        this.age = 0;
    }
    
    // Constructor with one argument
    public Person(String name) {
        this.name = name;
        this.age = 0;
    }
    
    // Constructor with two arguments
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

## Example of Method Overloading

Consider the following class with overloaded methods for adding numbers:

```java
public class Calculator {

    // Method to add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Overloaded method to add two doubles
    public double add(double a, double b) {
        return a + b;
    }

    // Overloaded method to add three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        
        // Calls add(int, int)
        System.out.println("Sum of 5 and 3: " + calc.add(5, 3));
        
        // Calls add(double, double)
        System.out.println("Sum of 5.5 and 3.5: " + calc.add(5.5, 3.5));
        
        // Calls add(int, int, int)
        System.out.println("Sum of 5, 3 and 2: " + calc.add(5, 3, 2));
    }
}
```

## Benefits of Method Overloading

* **Improved Readability**: By using the same method name for similar operations, the code becomes easier to read and understand.

* **Flexibility**: It allows you to provide multiple ways to perform the same operation depending on the type or number of inputs.

* **Code Reusability**: Overloaded methods help reduce code duplication by centralizing similar operations under one method name.

In summary, method overloading is a powerful feature in Java that enhances the clarity and usability of your code by allowing multiple methods with the same name to operate on different types or quantities of data.

## Example 1:

**Overloading by Changing Parameter Types**

In this example, the display method is overloaded by providing one version that accepts an int and another that accepts a double.

```java
public class OverloadExample1 {

    // Overloaded method accepting an int
    public void display(int number) {
        System.out.println("Displaying int: " + number);
    }

    // Overloaded method accepting a double
    public void display(double number) {
        System.out.println("Displaying double: " + number);
    }

    public static void main(String[] args) {
        OverloadExample1 example = new OverloadExample1();
        
        // Calls display(int)
        example.display(5);
        
        // Calls display(double)
        example.display(5.5);
    }
}
```

### Expected Output:

```
Displaying int: 5
Displaying double: 5.5
```

### Explanation

* When `example.display(5)` is called, the method that accepts an integer parameter is chosen.
* When `example.display(5.5)` is called, the method that accepts a double parameter is invoked.
* The compiler determines which method to call based on the argument's data type.

## Example 2:

**Overloading by Changing the Number of Parameters**

This example shows two overloaded versions of the add method—one that adds two integers and another that adds three integers.

```java
public class OverloadExample2 {

    // Overloaded method to add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Overloaded method to add three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        OverloadExample2 calculator = new OverloadExample2();
        
        // Calls add(int, int)
        System.out.println("Sum of 3 and 4: " + calculator.add(3, 4));
        
        // Calls add(int, int, int)
        System.out.println("Sum of 3, 4, and 5: " + calculator.add(3, 4, 5));
    }
}
```

### Expected Output:

```
Sum of 3 and 4: 7
Sum of 3, 4, and 5: 12
```

### Explanation

* The add method is overloaded by having different numbers of parameters.
* The method `calculator.add(3, 4)` matches the version with two parameters.
* The method `calculator.add(3, 4, 5)` matches the version with three parameters.
* This example shows how you can provide multiple ways to perform similar operations depending on the number of inputs.

## Example 3:

**Overloading Constructors**

Here, a class uses overloaded constructors to allow objects to be created with different initial data.

```java
public class OverloadExample3 {
    private String name;
    private int age;

    // No-argument constructor
    public OverloadExample3() {
        this.name = "Unknown";
        this.age = 0;
    }

    // Constructor with one argument
    public OverloadExample3(String name) {
        this.name = name;
        this.age = 0;
    }

    // Constructor with two arguments
    public OverloadExample3(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public static void main(String[] args) {
        // Creating objects using different constructors
        OverloadExample3 person1 = new OverloadExample3();
        OverloadExample3 person2 = new OverloadExample3("Alice");
        OverloadExample3 person3 = new OverloadExample3("Bob", 30);
        
        person1.displayInfo();
        person2.displayInfo();
        person3.displayInfo();
    }
}
```

### Expected Output:

```
Name: Unknown, Age: 0
Name: Alice, Age: 0
Name: Bob, Age: 30
```

### Explanation

* The class `OverloadExample3` defines three constructors:
  * A no-argument constructor that sets default values.
  * A constructor that accepts a `String` to set the `name`.
  * A constructor that accepts both a `String` and an `int` to set the `name` and `age`.
* Depending on which constructor is called during object creation, the instance variables are initialized differently.
* This is an example of method overloading applied to constructors.
