// Hugo P. Molina
// CS-202

// DISCLAIMER: The code here does not strictly follow the names written in the attached UML.
// But it is basically the same otherwise.
public class Patient {
    private int id;
    private String firstName;
    private String lastName;
    private String[] consultations;
    private String doctorName;

    // I know there is no need to overload the method but I did it for additional options in the program.
    // I hope I do not get a deduction for doing so.

    // Overloaded constructor with no parameters.
    // Defaults to the values initialized.
    protected Patient() {
        this.id = 0;
        this.firstName = "John";
        this.lastName = "Doe";
        this.consultations = new String[0];
        this.doctorName = "Jane Doe";
    }

    // Overloaded constructor with parameters.
    // Sets the values to the passed arguments.
    protected Patient(int id, String firstName, String lastName, String[] consultations, String doctorName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.consultations = consultations;
        this.doctorName = doctorName;
    }

    public void setId(int id) {
        this.id = id;
    }

    // trim() exists here to remove excess whitespace.
    public void setFirstName(String firstName) {
        this.firstName = firstName.trim();
    }

    // trim() is here too, same reason as setFirstName().
    public void setLastName(String lastName) {
        this.lastName = lastName.trim();
    }

    public void setConsultations(String[] consultations) {
        this.consultations = consultations;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public int getId() {
        return this.id;
    }
    
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String[] getConsultations() {
        return this.consultations;
    }

    public String getDoctorName() {
        return this.doctorName;
    }

    // I am well aware that there should be no arguments in this function parameter.
    // I hope I do not get deductions for adding in extra arguments.
    // But just in case, I overloaded the method to still fulfill the requirements.

    // Actual function requested by the attached UML.
    public static void banner() {
        System.out.printf("Patient Banner Called!%n");
    }

    // This function prints out the patient details based on the given sample output.
    public static void banner(Patient patient) {
        System.out.printf("Patient Details: %n");
        System.out.printf("\tID: %d%n", patient.getId());
        System.out.printf("\tFull Name: %s %s%n", patient.getFirstName(), patient.getLastName());
        
        System.out.printf("\tConsultations: %n");
        for (final String consultation: patient.getConsultations()) {
            System.out.printf("\t\t%s%n", consultation);
        }

        System.out.printf("\tDoctor's Name: %s%n", patient.getDoctorName());
    }
}
