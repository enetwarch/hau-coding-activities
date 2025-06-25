// Hugo P. Molina
// CS-102

// This class has a main or entry point for its own program.
// It also acts as an object prototype which will be used in the main.
// Since everything will happen in the same file, almost everything except main will be marked private.
// First, the <angle brackets> in the class header pertains to types being passed in as arguments AKA generics.
// These generics provide extra reusability to objects or functions because you are not locked to one particular type.
// Diving into the program, a Pair object is initialized with String and Integer (non-primitive int) data types.
// Pairs are tuples but for two values, meaning it can contain two values that have different or similar types.
// In this case, the pair contains name (String) and age (Integer) and are immutable due to having no mutator methods.
// After that, the name, age, and tuple representation are printed which all use the instance functions declared below.
// The program is then exited after all these steps are finished.
public class Pair<First, Second> {
  public static void main(String[] args) {
    final Pair<String, Integer> person = new Pair("Hugo", 19);

    System.out.printf("Name: %s\n", person.getFirst());
    System.out.printf("Age: %d\n", person.getSecond());
    System.out.printf("Tuple: %s\n", person);

    System.exit(0);
  }

  // The program will use a name and age pair of data based from the instructions.
  // The fields here will still be named as if it is not aware of the data types it will contain.
  // They will still depend on the types inserted through the generic.
  private final First first;
  private final Second second;

  // The following code will be constructor, accessor, and maybe mutator method boilerplate.
  // In this case, there will be no mutator because the instructions didn't need it.

  private Pair(First first, Second second) {
    this.first = first;
    this.second = second;
  }

  private First getFirst() {
    return this.first;
  }

  private Second getSecond() {
    return this.second;
  }

  // This method will be the string representation of any object which has a default method in Java.
  // We use override to change that default to this explicitly declared toString() method.
  // When there is an implicit need to turn this Pair into a String, this method will automatically be called.
  // Printing a pair for example will automatically call toString() because prints need strings.
  @Override 
  public String toString() {
    return String.format("(%s, %s)", this.first, this.second);
  }
}
