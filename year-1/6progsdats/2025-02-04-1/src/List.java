// Hugo P. Molina
// CS-102

// Imports that will be used through the file.
import java.util.ArrayList;

// This class has its own main method or entry point for its own program.
// A pretty simple file to demonstrate how ArrayList, a List interface implementation works.
// A List in Java is a dynamic array that can increase in size dynamically during runtime.
// Here is my explanation on Lists based on the requirements from the instructions and program flow:
// * We create an ArrayList<String> to store student names.
// * We add students in the ArrayList, in this case: "Alice", "Bob", "Charlie", "Jacob", "Akio", and "Kyle".
// * We remove "Bob", "Charlie", and "Akio" to demonstrate list modification.
// * We can access elements in the list individually with the get() method from List objects.
// * We loop through the list to display all students.
// After those steps, the program will be exited.
public class List {
  public static void main(String[] args) {
    final ArrayList<String> studentList = new ArrayList<>();
    System.out.printf("Student list after initialization: %s\n", studentList);

    studentList.add("Alice");
    studentList.add("Bob");
    studentList.add("Charlie");
    studentList.add("Jacob");
    studentList.add("Akio");
    studentList.add("Kyle");
    System.out.printf("Student list after adding some students: %s\n", studentList);

    studentList.remove("Bob");
    studentList.remove("Charlie");
    studentList.remove("Akio");
    System.out.printf("Student list after removing some students: %s\n", studentList);

    System.out.printf("First student in the list: %s\n", studentList.get(0));
    System.out.printf("Second student in the list: %s\n", studentList.get(1));
    System.out.printf("Third student in the list: %s\n", studentList.get(2));

    System.out.printf("All students:");
    for (final String student: studentList) {
      System.out.printf(" %s", student);
    }
    System.out.printf("\n");

    System.exit(0);
  }
}
