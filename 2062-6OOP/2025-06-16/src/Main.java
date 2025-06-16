// Hugo P. Molina
// CS-202

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // The final keyword just makes this object unassignable to another Patient object again.
    // It is still modifyable.
    final Patient firstPatient = new Patient(1, "Felix", "Angeles", new String[]{"June 28, 2024", "July 1, 2024"}, "Angel Computing");
    Patient.banner(firstPatient);

    final Patient secondPatient = new Patient();
    System.out.printf("Please enter the details of your next patient: %n");

    // The sample output does not have an enter patient ID and immediately sets the 2nd patient's ID to 2.
    // This code is here to add more flexibility to the program.
    secondPatient.setId(getIntInput("Enter patient ID: ", 0, Integer.MAX_VALUE, "Please enter a positive integer."));
    
    // The sample output only asks the patient's name, but asking for the first and last name separately gives more flexibility.
    secondPatient.setFirstName(getStringInput("Enter patient first name: "));
    secondPatient.setLastName(getStringInput("Enter patient last name: "));

    secondPatient.setConsultations(getConsultations(
      getIntInput("Enter the instances of consultations: ", 0, Integer.MAX_VALUE, "Please enter a valid amount."),
      "Enter the consultation date: "
    ));

    secondPatient.setDoctorName(getStringInput("Enter doctor's name: "));

    Patient.banner(secondPatient);
  }

  // Helper method for getting consultations because it takes multiple lines.
  private static String[] getConsultations(int consultationAmount, String loopedInputPrompts) {
    // Returns an string array with 0 length if there are no consultations.
    if (consultationAmount == 0) return new String[0];
    
    final String[] consultations = new String[consultationAmount];
    for (int i = 0; i < consultationAmount; i++) {
      consultations[i] = getStringInput(String.format("%d. %s", i + 1, loopedInputPrompts));
    }

    return consultations;
  }

  // The following code are just scanner related functions.
  // They are utility functions that have input validation and self-explanatory variable and parameter names.

  private static final Scanner scanner = new Scanner(System.in);

  private static int getIntInput(String inputPrompt, int min, int max, String errorMessage) {
    while (true) {
      try {
        System.out.printf("%s", inputPrompt);
        final int input = Integer.parseInt(scanner.nextLine());

        if (input >= min && input <= max) {
          return input;
        } else {
          System.out.printf("%s%n", errorMessage);
        }
      } catch (NumberFormatException error) {
        System.out.printf("%s%n", errorMessage);
      }
    }
  }

  private static String getStringInput(String inputPrompt) {
    System.out.printf("%s", inputPrompt);
    return scanner.nextLine().trim();
  }
}