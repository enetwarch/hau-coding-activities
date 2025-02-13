import java.util.Random;
import java.util.Scanner;

public class Lotto {

    public static void main(String[] args) {
        generateWinningNumbers();
        getUserNumbers();
        System.out.printf("%n");
        printWinningNumbers();
        int matches = calculateNumberMatches();
        printNumberMatches(matches);
        determinePrize(matches);
    }

    private static final int NUMBER_AMOUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 49;
    private static final Random random = new Random();

    private static final int[] winningNumbers = new int[NUMBER_AMOUNT];

    private static void generateWinningNumbers() {
        for (int i = 0; i < winningNumbers.length; i++) {
            winningNumbers[i] = random.nextInt(MAX_NUMBER) + 1;
        }
    }

    private static final int[] userNumbers = new int[NUMBER_AMOUNT];

    private static void getUserNumbers() {
        System.out.printf("Input %d numbers [%,d-%,d].%n", NUMBER_AMOUNT, MIN_NUMBER, MAX_NUMBER);
        for (int i = 0; i < NUMBER_AMOUNT; i++) {
            while (true) { 
                int userNumber = getUserInput(String.format("Input #%d", i + 1), MIN_NUMBER, MAX_NUMBER);
                if (validateUserNumber(userNumber)) {
                    userNumbers[i] = userNumber;
                    break;
                }
            }
        }
    }

    private static boolean validateUserNumber(int userNumber) {
        for (int i = 0; i < userNumbers.length; i++) {
            if (userNumber == userNumbers[i]) {
                System.out.printf("Please do not repeat number inputs.%n");
                return false;
            }
        }
        return true;
    }

    private static void printWinningNumbers() {
        StringBuilder printWinningNumbers = new StringBuilder();
        printWinningNumbers.append("The winning numbers are:");
        for (int winningNumber : winningNumbers) {
            printWinningNumbers.append(String.format(" %d", winningNumber));
        }
        System.out.printf("%s%n", printWinningNumbers);
    }

    private static int calculateNumberMatches() {
        int matches = 0;
        for (int winningNumber : winningNumbers) {
            for (int userNumber : userNumbers) {
                if (winningNumber == userNumber) {
                    matches++;
                    break;
                }
            }
        }
        return matches;
    }

    private static void printNumberMatches(int matches) {
        System.out.printf("Number Match/es: %,d%n", matches);
    }

    private static void determinePrize(int matches) {
        switch (matches) {
            case 3 -> System.out.printf("You won Php50.00!%n");
            case 4 -> System.out.printf("You won Php1,200.00!%n");
            case 5 -> System.out.printf("You won Php50,000.00!%n");
            case 6 -> System.out.printf("You hit the Jackpot!%n");
            default -> System.out.printf("Better luck next time.%n");
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    private static int getUserInput(String message, int min, int max) {
        while (true) {
            try {
                System.out.printf("%s: ", message);
                int userInput = Integer.parseInt(scanner.nextLine().trim());
                if (userInput >= min && userInput <= max) {
                    return userInput;
                } else {
                    inputErrorPrompt(min, max);
                }
            } catch (Exception e) {
                inputErrorPrompt(min, max);
            }
        }
    }

    private static void inputErrorPrompt(int min, int max) {
        System.out.printf("INPUT ERROR. Only accepts integers %,d to %,d.%n", min, max);
    }

}