// Hugo P. Molina
// CS-202

// Imports that will be used throughout the program.
import java.util.Scanner;

// This class has a main method or entry point for its own program.
// The program first initializes a Scanner object and a Student[] array with size 3 for 3 elements.
// A for loop is then started which is used to initialize and print out student certificates.
// The for loop cycles by the amount of elements in the studentArray which in this case is 3 times.
// The initialization of the Student uses method chaining technique which is explained in Student.java.
// The input prompt and print certificate messages are all based on the given sample output.
// An empty space is then printed at the end of the cycle to create visual separation.
// After all of those steps, the scanner will close and the program will then be exited afterwards.
public class TestStudent {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final Student[] studentArray = new Student[3];

        for (int i = 0; i < studentArray.length; i++) {
            System.out.printf("Student #%d:\n", i + 1);
            studentArray[i] = new Student(8000.00)
                .setNumber(Input.getStringInput(scanner, "Enter the student number: "))
                .setName(Input.getStringInput(scanner, "Enter the student name: "))
                .setProgramAndSection(Input.getStringInput(scanner, "Enter the student program and section: "))
                .setTotalUnitsEnrolled(Input.getIntInput(scanner, "Enter the total units enrolled: ", 0, Integer.MAX_VALUE))
                .calculateTuitionFee(Input.getDoubleInput(scanner, "Enter the rate per unit: P ", 0, Double.MAX_VALUE));
            
            studentArray[i].printCertificate();
            System.out.printf("\n");
        }

        scanner.close();
        System.exit(0);
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

    // A utility function that gets the user integer input.
    // This function features input validation for when the user does not input an integer or when its out of range.
    // The function runs on an infinite loop that can only be broken when the user inputs a valid integer.
    // A predetermined error message will always be printed if the user insists on inputting an invalid integer.
    // Integer.parseInt() is used to remove the need to absorb the enter key on a non-nextLine() scanner method.
    // The thrown exception has a message for readability, but the catch block will print its own message.
    public static int getIntInput(Scanner scanner, String inputPrompt, int min, int max) { 
        while (true) { 
            try {
                System.out.printf("%s", inputPrompt);
                final int input = Integer.parseInt(scanner.nextLine().trim());
                if (input >= min && input <= max) return input;

                System.out.printf("INPUT ERROR. Please input a value between %,d to %,d.\n", min, max);
            } catch (NumberFormatException exception) {
                System.out.printf("INPUT ERROR. Please input an integer value.\n");
            }
        }
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
}
