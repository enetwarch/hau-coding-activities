// Hugo P. Molina
// CS-202

// This class will act as an Abstract Data Type (ADT) to act as a data container.
// It contains the necessary fields and methods required by the instructions which are all listed here. 
// There is also a print method here that prints student details based on the sample output.
public class Student {
    private String number;
    private String name;
    private String programAndSection;
    private int totalUnitsEnrolled;
    private double tuitionFee;
    private double miscellaneousFee;

    // This constructor initializes the Student object with default values and one required value.
    // The required value (miscenalleousFee) will be defaulted to 8000.00 which is passed through the main method.
    public Student(double miscellaneousFee) {
        this.number = "Unknown";
        this.name = "Unknown";
        this.programAndSection = "Unknown";
        this.totalUnitsEnrolled = 0;
        this.tuitionFee = 0;
        this.miscellaneousFee = miscellaneousFee;
    }

    // The following methods are instance getter or accessor methods for the Student object.
    // Nothing special here, just standard Java boilerplate.

    public String getNumber() {
        return this.number;
    }

    public String getName() {
        return this.name;
    }

    public String getProgramAndSection() {
        return this.programAndSection;
    }

    public int getTotalUnitsEnrolled() {
        return this.totalUnitsEnrolled;
    }

    public double getTuitionFee() {
        return this.tuitionFee;
    }

    public double getMiscellaneousFee() {
        return this.miscellaneousFee;
    }

    // The following methods are instance setter or mutator methods for the Student object.
    // They all have a Student return type but they still basically act as void methods.
    // The Student return type makes it so that these methods are chainable.
    // This is inspired by the Builder pattern but it is not the official way to do it.

    public Student setNumber(String number) {
        this.number = number;
        return this;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public Student setProgramAndSection(String programAndSection) {
        this.programAndSection = programAndSection;
        return this;
    }

    public Student setTotalUnitsEnrolled(int totalUnitsEnrolled) {
        this.totalUnitsEnrolled = totalUnitsEnrolled;
        return this;
    }

    public Student setTuitionFee(double tuitionFee) {
        this.tuitionFee = tuitionFee;
        return this;
    }

    public Student setMiscellaneousFee(double miscellaneousFee) {
        this.miscellaneousFee = miscellaneousFee;
        return this;
    }

    // This is another requested method by the instructions with some basic calculations.
    // The instructions said void-type method, but this one returns Student.
    // As explained earlier in the setter method portion, the Student return still acts as void.
    // The Student return just makes it so that the method is chainable and does not return a new object.
    // Again, pay no heed to the Student return type and just treat it as a void type which it basically is.
    // The calculations made here are based on the instructions.
    public Student calculateTuitionFee(double ratePerUnit) {
        this.tuitionFee = (ratePerUnit * this.totalUnitsEnrolled) + this.miscellaneousFee;
        return this;
    }

    // The last method requested by the instructions for the Student object.
    // This prints out the student enrollment certificate which is based on the sample output.
    public void printCertificate() {
        System.out.printf("Student Certificate of Enrollment:\n");
        System.out.printf("\tStudent Number: %s\n", this.number);
        System.out.printf("\tName: %s\n", this.name);
        System.out.printf("\tProgram and Section: %s\n", this.programAndSection);
        System.out.printf("\tTotal Units Enrolled: %d.0\n", this.totalUnitsEnrolled);
        System.out.printf("\tTotal Tuition Fee: P %,.2f\n", this.tuitionFee);
    }
}
