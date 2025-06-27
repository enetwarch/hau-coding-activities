// Hugo P. Molina
// CS-102

// This class has its own main method or entry point for its own program to run.
// This is a simple program that already has predetermined output because they are declared directly in the program.
// The x and y variables are initialized as 45 and 78 respectively.
// Max is calculated by calling in the findMax method which just returns the greater number.
// It then prints out both the numbers and the greater number.
// The program will exit afterward as that is the last step.
public class MaxNumber {
    public static void main(String[] args) {
        final int x = 45;
        final int y = 78;
        final int max = findMax(x, y);

        System.out.printf("The maximum of %,d and %,d is: %,d\n", x, y, max);

        System.exit(0);
    }

    // Simple method that returns the number with the greater value.
    // It uses ternary operators which is basically an inline if else with a return value.
    private static int findMax(int x, int y) {
        return (x > y) ? x : y;
    }
}
