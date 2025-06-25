# LAB Activity -- January 28 2025 -- StringBuilder

## StringBuilder in JAVA

**StringBuilder** in Java is a class used to create and manipulate mutable (modifiable) sequences of characters. Unlike String, which is immutable, StringBuilder allows you to change its content without creating a new object, making it more efficient for operations that involve frequent modifications like appending, inserting, or deleting characters.

## Key Features of StringBuilder:

1. **Mutable**: The contents of a StringBuilder object can be modified.
2. **Efficient**: It performs better than String when performing repetitive string operations because it doesn't create new objects.
3. **Thread-unsafe**: Unlike StringBuffer, StringBuilder is not synchronized, making it faster but not safe for use in multi-threaded environments.

### Common Methods:

* `append(String s)`: Adds the specified string to the end of the existing sequence.
* `insert(int offset, String s)`: Inserts a string at the specified position.
* `replace(int start, int end, String s)`: Replaces characters from the start to the end index with the given string.
* `delete(int start, int end)`: Removes characters from the start to the end index.
* `reverse()`: Reverses the current sequence of characters.
* `toString()`: Converts the StringBuilder object to a String.

### Example Usage A:

```java
public class StringBuilderExample {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");

        // Append
        sb.append(" World");
        System.out.println(sb); // Output: Hello World

        // Insert
        sb.insert(5, ",");
        System.out.println(sb); // Output: Hello, World

        // Replace
        sb.replace(7, 12, "Java");
        System.out.println(sb); // Output: Hello, Java

        // Delete
        sb.delete(5, 6);
        System.out.println(sb); // Output: Hello Java

        // Reverse
        sb.reverse();
        System.out.println(sb); // Output: avaJ olleH
    }
}
```

### Example Usage B:

Using StringBuilder for Dynamic String Construction

```java
public class StringBuilderExample1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Java");

        // Append multiple strings
        sb.append(" Programming").append(" Language");

        // Insert a substring
        sb.insert(5, " is a");

        System.out.println(sb); // Output: Java is a Programming Language
    }
}
```

*Explanation:*

1. `append(" Programming")`: Adds `" Programming"` to the existing string `"Java"`, making it `"Java Programming"`.
2. `append(" Language")`: Adds `" Language"` to the end, resulting in `"Java Programming Language"`.
3. `insert(5, " is a")`: Inserts `" is a"` at index 5, right after `"Java"`, making the final output: `"Java is a Programming Language"`.

### Example Usage C:

Reversing and Modifying a String

```java
public class StringBuilderExample2 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("12345");

        // Reverse the string
        sb.reverse();

        // Append a string
        sb.append(" ABC");

        // Delete a portion of the string
        sb.delete(2, 4);

        System.out.println(sb); // Output: 51C ABC
    }
}
```

*Explanation*:

1. `reverse()`: Reverses `"12345"` to `"54321"`.
2. `append(" ABC")`: Appends `" ABC"` to `"54321"`, resulting in `"54321 ABC"`.
3. `delete(2, 4)`: Removes characters from index 2 to 3 (inclusive), leaving `"51C ABC"`.

## Activity Instructions:

1. Create a Java program that performs the following steps:
  * Create a `StringBuilder` object with an initial string `"Learning"`.
  * Append the word `" Java"` to it.
  * Insert `" with StringBuilder"` after `"Learning"`.
  * Replace `"StringBuilder"` with `"String Manipulation"`.
  * Reverse the entire string.
  * Print the original and manipulated strings at each step.

### Code Implementation:

```java
public class StringBuilderActivity {
    public static void main(String[] args) {
        // Step 1: Create a StringBuilder object
        StringBuilder sb = new StringBuilder("Learning");
        System.out.println("Step 1: " + sb); // Output: Learning

        // Step 2: Append " Java"
       

        // Step 3: Insert " with StringBuilder" after "Learning"
      

        // Step 4: Replace "StringBuilder" with "String Manipulation"
        int start = sb.indexOf("StringBuilder");
        int end = start + "StringBuilder".length();
       // one line missing here
        System.out.println("Step 4: " + sb); // Output: Learning with String Manipulation Java

        // Step 5: Reverse the string
         // Output: avaJ noitalupinaM gnirtS htiw gninraeL
    }
}
```

### Output:

```
Step 1: Learning
Step 2: Learning Java
Step 3: Learning with StringBuilder Java
Step 4: Learning with String Manipulation Java
Step 5: avaJ noitalupinaM gnirtS htiw gninraeL
```

**Explanation**: <ins>Answer each step</ins>

1. Step 1: 
2. Step 2: 
3. Step 3: 
4. Step 4: 
5. Step 5: 
