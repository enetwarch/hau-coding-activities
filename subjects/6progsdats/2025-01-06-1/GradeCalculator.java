// Hugo P. Molina
// CS-102

// Imports that will be used throughout the program. 
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// This is the main class that will be responsible for calculations.
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
public class GradeCalculator {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final List<Student> studentList = new ArrayList<>();

        while (true) { 
            final Student student = new Student()
                .setName(Input.getStringInput(scanner, "Enter Student Name: "))
                .setQuizScore(Input.getDoubleInput(scanner, "Enter Quiz Score (0-100): ", 0, 100))
                .setAssignmentScore(Input.getDoubleInput(scanner, "Enter Assignment Score (0-100): ", 0, 100))
                .setExamScore(Input.getDoubleInput(scanner, "Enter Exam Score (0-100): ", 0, 100))
                .setProjectScore(Input.getDoubleInput(scanner, "Enter Project Score (0-100): ", 0, 100));
            student
                .setFinalGrade(calculateFinalGrade(
                    student.getQuizScore(), 
                    student.getAssignmentScore(), 
                    student.getExamScore(), 
                    student.getProjectScore()
                ))
                .setLetterGrade(calculateLetterGrade(student.getFinalGrade()));
            studentList.add(student);

            if (!Input.getBooleanInput(scanner, "Would you like to add another student? (y/n): ")) break;
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
}

// This class will only be used as an object to store data.
// It will have the required fields for students based on the instructions.
class Student {
    private String name;
    private double quizScore;
    private double assignmentScore;
    private double examScore;
    private double projectScore;
    private double finalGrade;
    private char letterGrade;

    // There are no parameters for the student constructor because it will only set default values.
    // To set these values, I am using a semi-builder pattern for a chained style Student object creation.
    // The protected keyword makes the constructor accessible by subclasses or same package classes.
    protected Student() {
        this.name = "Unknown";
        this.quizScore = 0;
        this.assignmentScore = 0;
        this.examScore = 0;
        this.projectScore = 0;
        this.finalGrade = 0;
        this.letterGrade = 'F';
    }

    // These setter methods will be returning the Student object back to allow method chaining.
    // The Student will still be mutated regardless, but it is only for method chaining fluency.

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public Student setQuizScore(double quizScore) {
        this.quizScore = quizScore;
        return this;
    }

    public Student setAssignmentScore(double assignmentScore) {
        this.assignmentScore = assignmentScore;
        return this;
    }

    public Student setExamScore(double examScore) {
        this.examScore = examScore;
        return this;
    }

    public Student setProjectScore(double projectScore) {
        this.projectScore = projectScore;
        return this;
    }

    public Student setFinalGrade(double finalGrade) {
        this.finalGrade = finalGrade;
        return this;
    }

    public Student setLetterGrade(char letterGrade) {
        this.letterGrade = letterGrade;
        return this;
    }

    // The following getters will be pretty normal.
    // They are here to make the encapsulated private data fields accessible.

    public String getName() {
        return this.name;
    }

    public double getQuizScore() {
        return this.quizScore;
    }

    public double getAssignmentScore() {
        return this.assignmentScore;
    }

    public double getExamScore() {
        return this.examScore;
    }

    public double getProjectScore() {
        return this.projectScore;
    }

    public double getFinalGrade() {
        return this.finalGrade;
    }

    public char getLetterGrade() {
        return this.letterGrade;
    }
}

// This class is here to provide utility and it contains input methods with validation.
// The Scanner object will be passed in every function here to apply the dependency injection pattern.
class Input {
    // A utility function that gets the user String input.
    // This method only prints the input prompt and returns the user input.
    // There are no input validations involved here because every user input is basically a string anyway.
    // The trim method removes excess whitespace the user might've accidentally inputted.
    public static String getStringInput(Scanner scanner, String inputPrompt) {
        System.out.printf("%s", inputPrompt);
        return scanner.nextLine().trim();
    }

    // A utility function that gets the user double input.
    // This function also includes input validation for when the user does not input a double or is out of bounds.
    // Basically, the way this function works is it runs on an infinite loop until it returns a valid user input.
    // If the user input is valid, it will print out an error message and go back to the top of the loop again.
    // Double.parseDouble() is used here to directly avoid the bugs from non-nextLine() scanner methods.
    // The thrown exception has a message for readability, but the catch block will print its own message.
    public static double getDoubleInput(Scanner scanner, String inputPrompt, double min, double max) { 
        while (true) { 
            try {
                System.out.printf("%s", inputPrompt);
                final double input = Double.parseDouble(scanner.nextLine().trim());
                if (input >= min && input <= max) return input;

                System.out.printf("INPUT ERROR. Please input a value between %,.2f to %,.2f.\n", min, max);
            } catch (NumberFormatException exception) {
                System.out.printf("INPUT ERROR. Please input a double value.");
            }
        }
    }

    // A utility function that gets the user input in boolean form.
    // The input validation step for this method is that it only accepts fixed values which are:
    // "y" or "yes" (true) and "n" or "no" (false) all of which are case-insensitive and whitespace safe due to trim.
    // It will print an error message otherwise and loop back in this infinite loop.
    public static boolean getBooleanInput(Scanner scanner, String inputPrompt) {
        while (true) {
            System.out.printf("%s", inputPrompt);
            final String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("y") || input.equals("yes")) return true;
            if (input.equals("n") || input.equals("no")) return false;

            System.out.printf("INPUT ERROR. Please input either 'y', 'yes', 'n', or 'no'.\n");
        }
    }
}
