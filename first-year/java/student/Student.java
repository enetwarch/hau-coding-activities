import java.util.Scanner;

public class Student {

    public static void main(String[] args) {
        for (int i = 0; i < STUDENT_AMOUNT; i++) {
            studentNames[i] = getStudentName();
            final int quizAmount = getQuizAmount(studentNames[i]);
            studentScores[i] = getQuizScores(quizAmount);
            System.out.printf("%n");
        }
        calculateAverages();
        printAverages();
        System.out.printf("%n");
        printHighestAverage();
    }

    private static final int STUDENT_AMOUNT = 5;
    private static final String[] studentNames = new String[STUDENT_AMOUNT];
    private static final int[][] studentScores = new int[STUDENT_AMOUNT][];
    private static final double[] studentAverages = new double[STUDENT_AMOUNT];

    private static String getStudentName() {
        return getUserInput("Name");
    }

    private static final int MIN_QUIZ_AMOUNT = 1;
    private static final int MAX_QUIZ_AMOUNT = Integer.MAX_VALUE;

    private static int getQuizAmount(String studentName) {
        return getUserInput(String.format("Number of quizzes for %s", studentName), MIN_QUIZ_AMOUNT, MAX_QUIZ_AMOUNT);
    }

    private static final int MIN_QUIZ_SCORE = 1;
    private static final int MAX_QUIZ_SCORE = 100;

    private static int[] getQuizScores(int quizAmount) {
        int[] quizScores = new int[quizAmount];
        for (int i = 0; i < quizAmount; i++) {
            quizScores[i] = getUserInput(String.format("Input quiz %d score", i + 1), MIN_QUIZ_SCORE, MAX_QUIZ_SCORE);
        }
        return quizScores;
    }

    private static void calculateAverages() {
        for (int i = 0; i < STUDENT_AMOUNT; i++) {
            double studentAverage = 0;
            for (int j = 0; j < studentScores[i].length; j++) {
                studentAverage += studentScores[i][j];
            }
            studentAverage /= studentScores[i].length;
            studentAverages[i] = studentAverage;
        }
    }

    private static void printAverages() {
        StringBuilder printAverages = new StringBuilder();
        printAverages.append(String.format("Averages%n"));
        for (int i = 0; i < STUDENT_AMOUNT; i++) {
            printAverages.append(String.format("%s: %.2f%n", studentNames[i], studentAverages[i]));
        }
        System.out.print(printAverages);
    }

    private static void printHighestAverage() {
        int highestAverageIndex = -1;
        double highestAverage = 0;
        for (int i = 0; i < STUDENT_AMOUNT; i++) {
            if (studentAverages[i] > highestAverage) {
                highestAverageIndex = i;
                highestAverage = studentAverages[i];
            }
        }
        System.out.printf("%s has the highest average: %.2f", studentNames[highestAverageIndex], highestAverage);
    }

    private static final Scanner scanner = new Scanner(System.in);

    private static String getUserInput(String message) {
        System.out.printf("%s: ",  message);
        return scanner.nextLine().trim(); 
    }

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