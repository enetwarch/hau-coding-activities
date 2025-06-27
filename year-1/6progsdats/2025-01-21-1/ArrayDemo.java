// Hugo P. Molina
// CS-102

// Imports that will be used throughout the program.
import java.util.Arrays;

// This class has its own main method or entry point for its own program.
// A simple program that has a predetermined output due to not needing any user input.
// The program initializes an array of integers which will be used as the basis of the outputs.
// First output will print all the elements of said integer array.
// Second output will print the smallest number of the array which is calculated via a method.
// Third output will print the total value of all the elements in the array which is also calculated by a method.
// After that, the program is exited.
public class ArrayDemo {
  public static void main(String[] args) {
    final int[] integerArray = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

    System.out.printf("All elements in the array: %s\n", Arrays.toString(integerArray));
    System.out.printf("The smallest number in the array: %s\n", findIntArraySmallestNumber(integerArray));
    System.out.printf("The sum of all the elements in the array: %s\n", calculateIntArraySum(integerArray));

    System.exit(0);
  }

  // This one-liner method uses the stream API to apply FP-style functions to the integer.
  // Basically, Arrays.stream on the int array will turn it into an IntStream which can then use stream methods.
  // min() is one of those stream methods which gets the lowest int inside the IntStream.
  // orElse(0) is a fallback method just in case min does not find any value due to IntStream being potentially empty.
  private static int findIntArraySmallestNumber(int[] integerArray) {
    return Arrays.stream(integerArray).min().orElse(0);
  }

  // Most of the explanation for this one-liner function is also done in the function before it.
  // The only difference is the sum() stream method which adds the value of all the array elements and returns it.
  private static int calculateIntArraySum(int[] integerArray) {
    return Arrays.stream(integerArray).sum();
  }
}
