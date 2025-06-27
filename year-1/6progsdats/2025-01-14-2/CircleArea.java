// Hugo P. Molina
// CS-102

// This class has its own main method or entry point for its own program.
// It basically has a predetermined radius already, that radius will then be passed in a calculator method.
// That calculator method calculates the area of the circle, look at the method header for more details.
// After that, the program will print the radius and area and only print out 2 decimal places at most.
// The program will exit afterwards as that is the final step.
public class CircleArea {
    public static void main(String[] args) {
        final double radius = 5.5;
        final double area = calculateCircleArea(radius);

        System.out.printf("The area of the circle with radius %,.2f is: %,.2f\n", radius, area);

        System.exit(0);
    }

    // Method to calculate the area of a circle based on the formulas online.
    // The formula is "\(\pi r^{2}\)" or "pi r squared" where r is the radius of the circle.
    private static double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }
}
