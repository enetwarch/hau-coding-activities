// Hugo P. Molina
// CS-202

// Imports that will be used throughout the program.
import java.util.Scanner;

// This is the main file that will coordinate the entire program.
// The program mimics the sample output and whatever is printed there.
// A scanner object is first initialized to make getting the user input from the terminal possible.
// The first patient is instantiated, whose data is all based on the first patient's data in the sample output.
// The first patient's details are then printed afterwards followed by the instantiation of the second patient.
// The instantiation of the second patient will prompt the user to input the data fields themselves.
// Notice the scanner is passed in through the Input class utility methods? They have their own explanation below.
// Lastly, the second patient's details are printed, followed by the closing of the scanner and exit of the program.
public class Main {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final Patient firstPatient = new Patient()
            .setId(1)
            .setFirstName("Felix")
            .setLastName("Angeles")
            .setConsultations(new String[] {"June 28, 2024", "July 1, 2024"})
            .setDoctorName("Angel Computing");
        firstPatient.printPatientDetails();

        System.out.printf("Please enter the details of your next patient: \n");
        final Patient secondPatient = new Patient()
            .setId(Input.getIntInput(scanner, "Enter patient ID: ", 0, Integer.MAX_VALUE))
            .setFirstName(Input.getStringInput(scanner, "Enter patient first name: "))
            .setLastName(Input.getStringInput(scanner, "Enter patient last name: "))
            .setConsultations(getConsultationsInput(scanner))
            .setDoctorName(Input.getStringInput(scanner, "Enter doctor's name: "));
        secondPatient.printPatientDetails();

        scanner.close();
        System.exit(0);
    }

    // Helper method for getting consultations because it takes multiple lines.
    // The second patient will call this method directly and get the consultation value from here.
    // It uses the passed in scanner to call the Input utility class for extra validation.
    private static String[] getConsultationsInput(Scanner scanner) {
        final int consultationAmount = Input.getIntInput(scanner, "Enter consultation amount: ", 0, Integer.MAX_VALUE);
        if (consultationAmount == 0) return new String[0];
        
        final String[] consultations = new String[consultationAmount];
        for (int i = 0; i < consultationAmount; i++) {
            consultations[i] = Input.getStringInput(scanner, String.format("%d. Enter the consultation date: ", i + 1));
        }

        return consultations;
    }
}

// This class is here to provide utility and it contains input methods with validation.
// The Scanner object will be passed in every function here to apply the dependency injection pattern.
class Input {
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

    // A utility function that gets the user String input.
    // This method only prints the input prompt and returns the user input.
    // There are no input validations involved here because every user input is basically a string anyway.
    // The trim method removes excess whitespace the user might've accidentally inputted.
    public static String getStringInput(Scanner scanner, String inputPrompt) {
        System.out.printf("%s", inputPrompt);
        return scanner.nextLine().trim();
    }
}
