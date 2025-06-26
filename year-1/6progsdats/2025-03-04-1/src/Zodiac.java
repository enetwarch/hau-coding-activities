// Hugo P. Molina
// CS-102

// Imports that will be used throughout the program.
import java.util.Scanner;

// This is the main class of this short activity program about Zodiac signs.
// The flow of the program is very similar to all the previous activities we have completed.
// Essential details will be prompted and collected from the user (name, year, month, and date of birth).
// The program will then do some calculations and print details such as their age and Zodiac sign.
// After all of that, the program will close the scanner and get exited.
public class Zodiac {
  @SuppressWarnings("ConvertToTryWithResources")
  public static void main(String[] args) {
    final Scanner scanner = new Scanner(System.in);

    final String name = Input.getStringInput(scanner, "Enter your name: ");
    final int year = Input.getIntInput(scanner, "Enter year of birth: ", 1900, 2025);
    final int month = Input.getIntInput(scanner, "Enter your month of birth [1-12]: ", 1, 12);

    final int validDay = calculateValidDay(year, month);
    final int day = Input.getIntInput(scanner, String.format("Enter your day of birth [1-%d]: ", validDay), 1, validDay);
    System.out.printf("\n");

    System.out.printf("Hi %s! You are %d years old.\n", name, calculateAge(year, month, day));
    System.out.printf("Your birthday is %s %d, %d\n", getMonthString(month), day, year);
    System.out.printf("Your Zodiac sign is: %s\n", getZodiacSign(month, day).toUpperCase());

    scanner.close();
    System.exit(0);
  }

  // A simple function that calculates the valid day based on the year and month.
  // The first line takes into account a leap year february month, which allows the date February 29.
  // The switch case just returns the correct days based on that month which are self-explanatory.
  private static int calculateValidDay(int year, int month) {
    if (year % 4 == 0 && month == 2) return 29;

    return switch (month) {
      case 1, 3, 5, 7, 8, 10, 12 -> 31;
      case 4, 6, 9, 11 -> 30;
      case 2 -> 28;
      default -> 0;
    };
  }

  // A simple function that calculates the age of the user while taking into account the current date.
  // This activity was completed in March 4, 2025 which is why the current variables are like that.
  // The logic here also takes into account whether the user's birthday already passed this year or not.
  private static int calculateAge(int year, int month, int day) {
    final int currentYear = 2025;
    final int currentMonth = 3;
    final int currentDay = 4;

    if (currentMonth > month) return currentYear - year;
    if (currentMonth == month && currentDay >= day) return currentYear - year;
    return currentYear - year - 1;
  }

  // This method is very simple despite looking very long.
  // It basically acts as a HashMap, and it maps the int to String representation of months.
  // If the month argument passed in is not within 1-12, the method will return "Unknown".
  private static String getMonthString(int month) {
    return switch (month) {
      case 1 -> "January";
      case 2 -> "February";
      case 3 -> "March";
      case 4 -> "April";
      case 5 -> "May";
      case 6 -> "June";
      case 7 -> "July";
      case 8 -> "August";
      case 9 -> "September";
      case 10 -> "October";
      case 11 -> "November";
      case 12 -> "December";
      default -> "Unknown";
    };
  }

  // This method is also very long but it basically just returns the Zodiac sign according to month and day.
  // Aquarius (Water Bearer): January 20 - February 18
  // Pisces (Fish): February 19 - March 20
  // Aries (Ram): March 21 - April 19
  // Taurus (Bull): April 20 - May 20
  // Gemini (Twins): May 21 - June 21
  // Cancer (Crab): June 22 - July 22
  // Leo (Lion): July 23 - August 22
  // Virgo (Virgin): August 23 - September 22
  // Libra (Balance): September 23 - October 23
  // Scorpius (Scorpion): October 24 - November 21
  // Sagittarius (Archer): November 22 - December 21
  // Capricornus (Goat): December 22 - January 19
  // Source: https://www.britannica.com/topic/zodiac
  private static String getZodiacSign(int month, int day) {
    if ((month == 1 && day >= 20) || (month == 2 && day <= 18)) return "Aquarius";
    if ((month == 2 && day >= 19) || (month == 3 && day <= 20)) return "Pisces";
    if ((month == 3 && day >= 21) || (month == 4 && day <= 19)) return "Aries";
    if ((month == 4 && day >= 20) || (month == 5 && day <= 20)) return "Taurus";
    if ((month == 5 && day >= 21) || (month == 6 && day <= 20)) return "Gemini";
    if ((month == 6 && day >= 21) || (month == 7 && day <= 22)) return "Cancer";
    if ((month == 7 && day >= 23) || (month == 8 && day <= 22)) return "Leo";
    if ((month == 8 && day >= 23) || (month == 9 && day <= 22)) return "Virgo";
    if ((month == 9 && day >= 23) || (month == 10 && day <= 22)) return "Libra";
    if ((month == 10 && day >= 23) || (month == 11 && day <= 21)) return "Scorpio";
    if ((month == 11 && day >= 22) || (month == 12 && day <= 21)) return "Sagittarius";
    if ((month == 12 && day >= 22) || (month == 1 && day <= 19)) return "Capricorn";
    return "Unknown";
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
        final int input = Integer.parseInt(scanner.nextLine());
        
        if (input >= min && input <= max) return input;
        throw new IllegalArgumentException("Invalid input.");
      } catch (IllegalArgumentException exception) {
        System.out.printf("INPUT ERROR. Only accepts values %d to %d.\n", min, max);
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
