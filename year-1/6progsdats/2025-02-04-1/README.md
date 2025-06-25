# LAB Activity -- February 4 2025 -- ArrayList and Tuples

## What is an ArrayList in Java?

An **ArrayList** is a resizable array implementation of the List interface in Java. Unlike arrays, which have a fixed size, an ArrayList can grow and shrink dynamically as elements are added or removed.

### Key Features of ArrayList

* Dynamic resizing – It expands when more elements are added and shrinks when elements are removed.
* Ordered collection – Elements maintain their insertion order.
* Allows duplicates – Multiple occurrences of the same element are permitted.
* Indexed access – Elements can be accessed using an index (list.get(index)).
* Allows null values – Can store null elements.

### Declaring an ArrayList

To use ArrayList, you must import java.util.ArrayList:

```java
import java.util.ArrayList;
```

Example:

```java
ArrayList<String> names = new ArrayList<>();
```

Then, create an ArrayList object:

```java
ArrayList<Type> listName = new ArrayList<>();
```

*The <> (diamond operator) ensures type safety, preventing insertion of different data types.*

## Example: Using an ArrayList

*Here’s a simple program demonstrating ArrayList operations.*

```java
import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        // Creating an ArrayList of Strings
        ArrayList<String> fruits = new ArrayList<>();

        // Adding elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");

        // Accessing elements
        System.out.println("First fruit: " + fruits.get(0));

        // Removing an element
        fruits.remove("Banana");

        // Checking size
        System.out.println("Size after removal: " + fruits.size());

        // Iterating over elements
        System.out.println("Fruits list:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}
```

### Output:

```
First fruit: Apple
Size after removal: 2
Fruits list:
Apple
Cherry
```

## Common Methods in ArrayList

* `add(E element)`: Adds an element to the list
* `add(int index, E element)`:	Inserts an element at a specific index
* `remove(int index)`:	Removes the element at the given index
* `remove(Object o)`:	Removes the first occurrence of the specified element
* `get(int index)`:	Retrieves the element at the specified index
* `set(int index, E element)`:	Replaces the element at the specified index
* `size()`:	Returns the number of elements in the list
* `contains(Object o)`:	Checks if the list contains a specified element
* `isEmpty()`:	Checks if the list is empty
* `clear()`:	Removes all elements from the list

## Example 1:

**Using an ArrayList to Store and Manipulate Student Names**

In Java, ArrayList is commonly used for dynamic lists.

```java
import java.util.ArrayList;

public class ListExample {
    public static void main(String[] args) {
        // Creating an ArrayList of student names
        ArrayList<String> students = new ArrayList<>();

        // Adding elements to the list
        students.add("Alice");
        // missing line here
        students.add("Charlie");

        // Removing an element
        students.remove("Bob");

        // Printing the list
        System.out.println("Student List: " + students);

        // Accessing an element
        System.out.println("First student: " + students.get(0));

        // Looping through the list
        System.out.print("All students: ");
        // for (String student : what is missing? ) {
            System.out.print(student + " ");
        }
    }
}
```

### Sample Output:

```
Student List: [Alice, Charlie]
First student: Alice
All students: Alice Charlie 
```

*Explanation:*

* We create an `ArrayList<String>` to store student names.
* We add three students (Alice, Bob, Charlie).
* We remove `"Bob"`, demonstrating list modification.
* We print the entire list and access an individual element.
* A loop iterates through the list to display all students.

## Example 2:

**Using a Tuple-like Structure with List.of() (Immutable List)**

Java does not have built-in tuples, but we can use an immutable list to mimic a tuple.

```java
import java.util.List;

public class TupleExample {
    public static void main(String[] args) {
        // Using List.of() to create an immutable tuple-like structure
        List<String> personInfo = List.of("John Doe", "25", "Software Engineer");

        // Accessing tuple values
        System.out.println("Name: " + personInfo.get(0));
        System.out.println("Age: " + personInfo.get(1));
        // missing line here

        // Attempting to modify (uncommenting the below line will cause an error)
        // personInfo.add("New Data"); // This will throw an UnsupportedOperationException
    }
}
```

### Sample Output:

```
Name: John Doe
Age: 25
Profession: Software Engineer
```

*Explanation:*

* `List.of()` creates .........
* The list stores three values: ............
* We retrieve values using..............
* The list is immutable, meaning modification attempts ........

## Example 3:

**Using a Custom Tuple Class for Storing Pair Values**

To create a true tuple-like structure, we define a simple Pair class.

```java
class Pair<T, U> {
    private final T first;
    private final U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}

public class TupleDemo {
    public static void main(String[] args) {
        // Creating a tuple-like object
        Pair<String, Integer> person = new Pair<>("Alice", 30);

        // Accessing elements
        System.out.println("Name: " + person.getFirst());
        System.out.println("Age: " + person.getSecond());

        // Printing the tuple
        System.out.println("Tuple representation: " + person);
    }
}
```

### Sample Output:

```
Name: Alice
Age: 30
Tuple representation: (Alice, 30)
```

*Explanation:*
