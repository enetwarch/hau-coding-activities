// Hugo P. Molina
// CS-102

// Imports that will be used throughout the program. 
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Main class that will be responsible for calculations.
// Also contains the main entry point or main method of the program.
// The main method will serve as the interface for the program and it is based on the sample output.
// Just by reading the flow of the main method, what it does will be self-explanatory as it aligns with the sample output.
// ArrayList is used to record all the students dynamically and print them all out and get the highest average later.
// The flow of the program will be as follows:
// Initialize a studentList ArrayList to allow the program to store Student objects dynamically on runtime.
// Start an infinite loop that asks the user input for the name, quiz, assignment, exam, and project score of the students.
// The final grade and letter grade will be calculated after the user input collection is finished.
// The program will then ask if the user wants to add more students, and if they do, they will reset the loop.
// The loop will only break when the user does not want to add any more students.
// A printf("\n") is at the last line of the while loop and after the while loop to add an empty space for visual separation.
// After the loop is broken, all students and their details will be printed out using a for loop.
// The average grade of all students and the highest average will then be calculated and printed as well.
// Lastly, the scanner will get closed and the program will be exited.
public class Main {
  @SuppressWarnings("ConvertToTryWithResources")
  public static void main(String[] args) {
    final List<Student> studentList = new ArrayList<>();

    while (true) { 
      final Student student = new Student()
        .setName(getStringInput("Enter Student Name: "))
        .setQuizScore(getDoubleInput("Enter Quiz Score (0-100): ", 0, 100))
        .setAssignmentScore(getDoubleInput("Enter Assignment Score (0-100): ", 0, 100))
        .setExamScore(getDoubleInput("Enter Exam Score (0-100): ", 0, 100))
        .setProjectScore(getDoubleInput("Enter Project Score (0-100): ", 0, 100));
      student
        .setFinalGrade(calculateFinalGrade(
          student.getQuizScore(), 
          student.getAssignmentScore(), 
          student.getExamScore(), 
          student.getProjectScore()
        ))
        .setLetterGrade(calculateLetterGrade(student.getFinalGrade()));
      studentList.add(student);

      if (!getBooleanInput("Would you like to add another student? (y/n): ")) break;
      System.out.printf("\n");
    }
    System.out.printf("\n");

    for (final Student student : studentList) {
      System.out.printf("Student: %s\n", student.getName());
      System.out.printf("Quiz Score: %,.0f\n", student.getQuizScore());
      System.out.printf("Assignment Score: %,.0f\n", student.getAssignmentScore());
      System.out.printf("Exam Score: %,.0f\n", student.getExamScore());
      System.out.printf("Project Score: %,.0f\n", student.getProjectScore());
      System.out.printf("Final Grade: %,.1f\n", student.getFinalGrade());
      System.out.printf("Letter Grade: %c\n", student.getLetterGrade());
      System.out.printf("\n");
    }

    System.out.printf("Average Grade of All Students: %,.2f\n", calculateAverageOfAllStudents(studentList));
    System.out.printf("Highest Final Grade: %,.2f\n", calculateHighestFinalGrade(studentList));

    scanner.close();
    System.exit(0);
  }

  // Initializes the scanner here to make it accessible throughout the entire class.
  private static final Scanner scanner = new Scanner(System.in);

  // This function returns the calculated final grade based on the weight distribution from the instructions.
  // Quizzes = 20%, Assignments = 30%, Exams = 30%, Projects = 20%.
  private static double calculateFinalGrade(double quiz, double assignment, double exam, double project) {
    return (double) ((quiz * 0.20) + (assignment * 0.30) + (exam * 0.30) + (project * 0.20));
  }

  // This function returns the grade letter of the student based on the final grade.
  // The scale is based on the one given in the instructions.
  // A = 90-100, B = 80-89, C = 70-79, D = 60-69, F = 60 below.
  private static char calculateLetterGrade(double finalGrade) {
    if (finalGrade >= 90 && finalGrade <= 100) return 'A';
    if (finalGrade >= 80 && finalGrade <= 89) return 'B';
    if (finalGrade >= 70 && finalGrade <= 79) return 'C';
    if (finalGrade >= 60 && finalGrade <= 69) return 'D';
    return 'F';
  }

  // This function uses stream API to allow the list to be consumed by FP-style array functions.
  // mapToDouble() takes the studentList and returns a list of the final grades of all students in the studentList.
  // average() is usable for DoubleStreams data types which calculates the average of every double in the list.
  // orElse(0) is just a fallback in case the studentList array is empty, it will then return 0.
  // The function then returns the final result from all the method chains on the stream.
  private static double calculateAverageOfAllStudents(List<Student> studentList) {
    return studentList.stream().mapToDouble((student) -> student.getFinalGrade()).average().orElse(0);
  }

  // This function also uses the stream API just like the last one and has the same exact mapToDouble() usage.
  // max() here gets the highest double in the DoubleStream and returns it.
  // orElse(0) here is another fallback just in case studentList is empty, it will return 0.
  private static double calculateHighestFinalGrade(List<Student> studentList) {
    return studentList.stream().mapToDouble((student) -> student.getFinalGrade()).max().orElse(0);
  }

  // A utility function that gets the user String input.
  // This method only prints the input prompt and returns the user input.
  // There are no input validations involved here because every user input is basically a string anyway.
  private static String getStringInput(String inputPrompt) {
    System.out.printf("%s", inputPrompt);
    return scanner.nextLine();
  }

  // A utility function that gets the user double input.
  // This function also includes input validation which is another requirement from the instructions.
  // Basically, the way this function works is it runs on an infinite loop until it returns a valid user input.
  // If the user input is valid, it will print out an error message and go back to the top of the loop agian.
  // Double.parseDouble() is used here to directly avoid the bugs from non-nextLine() scanner methods.
  private static double getDoubleInput(String inputPrompt, double min, double max) { 
    while (true) { 
      try {
        System.out.printf("%s", inputPrompt);
        final double input = Double.parseDouble(scanner.nextLine());
        
        if (input >= min && input <= max) return input;
        throw new NumberFormatException();
      } catch (NumberFormatException exception) {
        System.out.printf("INPUT ERROR. Only accepts values %,.2f to %,.2f.\n", min, max);
      }
    }
  }

  // Last utility function that gets the user input.
  // This one has a bit of input validation, it only accepts value 'y' (true) and 'n' (false).
  // It will throw an error otherwise and loop back in this infinite loop.
  private static boolean getBooleanInput(String inputPrompt) {
    while (true) {
      System.out.printf("%s", inputPrompt);
      final char input = scanner.nextLine().toLowerCase().charAt(0);

      if (input == 'y') return true;
      if (input == 'n') return false;

      System.out.printf("INPUT ERROR. Only accepts values 'y' and 'n'.\n");
    }
  }
}
