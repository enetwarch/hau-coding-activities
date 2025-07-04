// Hugo P. Molina
// CS-102

// This class has its own main method or entry point for its own program.
// The program is a simple StringBuilder activity that has multiple printed steps.
// Step 1: "Learning" (Initialize StringBuilder)
// Step 2: "Learning Java" (Append " Java")
// Step 3: "Learning with StringBuilder Java" (Insert " with StringBuilder" after "Learning")
// Step 4: "Learning with String Manipulation Java" (Replace "StringBuilder" with "String Manipulation")
// Step 5: "avaJ noitalupinaM gnirtS htiw gninraeL" (Reverse the entire StringBuilder)
// For more details on StringBuilder, the instructions or Oracle website can help you.
// The other file-specific functions are small and have their own descriptions.
public class StringBuilderDemo {
    public static void main(String[] args) {
        final StringBuilder stringBuilder = new StringBuilder("Learning");
        System.out.printf("Step 1: %s\n", stringBuilder);

        stringBuilder.append(" Java");
        System.out.printf("Step 2: %s\n", stringBuilder);

        stringBuilder.insert(getSubstringEndIndex(stringBuilder, "Learning"), " with StringBuilder");
        System.out.printf("Step 3: %s\n", stringBuilder);

        stringBuilder.replace(
            getSubstringStartIndex(stringBuilder, "StringBuilder"), 
            getSubstringEndIndex(stringBuilder, "StringBuilder"), 
            "String Manipulation"
        );
        System.out.printf("Step 4: %s\n", stringBuilder);

        stringBuilder.reverse();
        System.out.printf("Step 5: %s\n", stringBuilder);
    }

    // A function to get the start argument for most StringBuilder methods.
    // It gets the starting index of the String instance based on its location in the StringBuilder.
    // Example: "Ahh yes" (StringBuilder) and "yes" (String), it will return 4.
    private static int getSubstringStartIndex(StringBuilder stringBuilder, String string) {
        return stringBuilder.indexOf(string);
    }

    // A function to get the end argument for most StringBuilder methods.
    // It gets the ending index of the String instance based on its location in the StringBuilder.
    // Example: "Ahh yes" (StringBuilder) and "yes" (String), it will return 7.
    private static int getSubstringEndIndex(StringBuilder stringBuilder, String string) {
        return stringBuilder.indexOf(string) + string.length();
    }
}
