// Hugo P. Molina
// CS-102

// This class will only be used as an object to store data.
// It will have the required fields for students based on the instructions.
public class Student {
  private String name;
  private double quizScore;
  private double assignmentScore;
  private double examScore;
  private double projectScore;
  private double finalGrade;
  private char letterGrade;

  // There are no parameters for the student constructor because it will only set default values.
  // To set these values, I am using a semi-builder pattern for a chained style Student object creation.
  // The protected keyword makes the constructor accessible by subclasses or same package classes.
  protected Student() {
    this.name = "Unknown";
    this.quizScore = 0;
    this.assignmentScore = 0;
    this.examScore = 0;
    this.projectScore = 0;
    this.finalGrade = 0;
    this.letterGrade = 'F';
  }

  // These setter methods will be returning the Student object back to allow method chaining.
  // The Student will still be mutated regardless, but it is only for method chaining fluency.

  public Student setName(String name) {
    this.name = name;
    return this;
  }

  public Student setQuizScore(double quizScore) {
    this.quizScore = quizScore;
    return this;
  }

  public Student setAssignmentScore(double assignmentScore) {
    this.assignmentScore = assignmentScore;
    return this;
  }

  public Student setExamScore(double examScore) {
    this.examScore = examScore;
    return this;
  }

  public Student setProjectScore(double projectScore) {
    this.projectScore = projectScore;
    return this;
  }

  public Student setFinalGrade(double finalGrade) {
    this.finalGrade = finalGrade;
    return this;
  }

  public Student setLetterGrade(char letterGrade) {
    this.letterGrade = letterGrade;
    return this;
  }

  // The following getters will be pretty normal.
  // They are here to make the encapsulated private data fields accessible.

  public String getName() {
    return this.name;
  }

  public double getQuizScore() {
    return this.quizScore;
  }

  public double getAssignmentScore() {
    return this.assignmentScore;
  }

  public double getExamScore() {
    return this.examScore;
  }

  public double getProjectScore() {
    return this.projectScore;
  }

  public double getFinalGrade() {
    return this.finalGrade;
  }

  public char getLetterGrade() {
    return this.letterGrade;
  }
}
