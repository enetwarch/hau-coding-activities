// Hugo P. Molina
// CS-202

// DISCLAIMER: The code here does not strictly follow the names written in the attached UML.
// Otherwise, the variables still function the same, albeit with just a different alias.
// This class is just here to follow the UML from the instructions and will mostly just contain data.
// It contains the necessary fields required by the instructions and UML.
public class Patient {
    private int id;
    private String firstName;
    private String lastName;
    private String[] consultations;
    private String doctorName;

    // Method overloading is applied on the constructor to allow empty argument initialization.
    // The other constructor can directly accept values while the first one initializes with defalts.

    protected Patient() {
        this.id = 0;
        this.firstName = "John";
        this.lastName = "Doe";
        this.consultations = new String[0];
        this.doctorName = "Jane Doe";
    }

    protected Patient(int id, String firstName, String lastName, String[] consultations, String doctorName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.consultations = consultations;
        this.doctorName = doctorName;
    }

    // The follow methods are public mutator methods for the Patient object and its data field.
    // They all return this; to allow for method chaining, but they basically act as void methods.
    // The return this; is inspired by a semi-builder pattern that still allows mutation.

    public Patient setId(int id) {
        this.id = id;
        return this;
    }

    public Patient setFirstName(String firstName) {
        this.firstName = firstName.trim();
        return this;
    }

    public Patient setLastName(String lastName) {
        this.lastName = lastName.trim();
        return this;
    }

    public Patient setConsultations(String[] consultations) {
        this.consultations = consultations;
        return this;
    }

    public Patient setDoctorName(String doctorName) {
        this.doctorName = doctorName;
        return this;
    }

    // The following are public accessor methods for the Patient object and its data fields.
    // They all keep the data fields encapsulated if they are only accessible through methods.

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

    // This method prints out the patient details like how the sample output did.
    // It is an instance method that can directly access the data of the current Patient object.
    public void printPatientDetails() {
        System.out.printf("Patient Details: \n");
        System.out.printf("\tID: %d\n", this.id);
        System.out.printf("\tFull Name: %s %s\n", this.firstName, this.lastName);
        
        System.out.printf("\tConsultations: \n");
        for (final String consultation: this.consultations) {
            System.out.printf("\t\t%s\n", consultation);
        }

        System.out.printf("\tDoctor's Name: %s\n", this.doctorName);
    }

    // A static method requested by the attached UML that only prints a simple message.
    // There are no actual implementation requriements for this method so i decided to keep it basic.
    public static void banner() {
        System.out.printf("Patient Banner Called!%n");
    }
}
