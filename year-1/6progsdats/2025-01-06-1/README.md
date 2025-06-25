# PRELIM LAB EXAM -- January 6, 2025 Monday

## Instructions:

This LABORATORY EXAM machine problem will require you to design and develop a program that will meet the different user requirements.

Read and follow the specific instructions of the given problem below.

**You will be allowed to use any available IDLE for writing and running your codes. You are only allowed to have the Canvas window and your IDLE open during the exam.**

Your screens are monitored, and you will be warned when you open another window. **The second time you open another window, you will be advised to submit whatever you have completed.**

**Total Points:** 50

**Submission Format:** Submit the PDF file(s) containing your program with proper documentation (comments) and output screenshots.

## Problem Statement

Develop a Java program to manage a simple **Student Grade Calculator**. The program will compute the final grade of a student based on input grades, validate inputs, and assign a letter grade based on a predefined grading scale. It will also calculate the average grade of all students after processing multiple entries.

## Requirements

1. **Input Validation (10 points)**

* The program should prompt the user to enter the **Student Name** and scores for **Quizzes, Assignments, Exams, and Projects**.
* Scores must be between **0** and **100**. If invalid, the program should display an error message and re-prompt the user until valid input is provided.

2. **Decision-Making (10 points)**

* Compute the **final grade** using the following weight distribution:
  * Quizzes: 20%
  * Assignments: 30%
  * Exams: 30%
  * Projects: 20%
* Determine the letter grade based on the final grade using this scale as follows:
  * A: 90 - 100
  * B: 80 - 89
  * C: 70 - 79
  * D: 60 - 69
  * F: Below 60

3. **Looping (20 points)**

Allow the user to calculate grades for multiple students. The program should continue asking for student details until the user decides to stop (e.g., by typing “No” when asked if they want to continue).

4. **Average Calculation (5 points)**

After processing all students, display the average final grade and the highest grade among all students.

5. **Code Documentation (comments) and User-Friendly Output (5 points)**

Include comments explaining key sections of your code. Ensure the program displays all outputs in a clear and readable format.

## Sample Input and Output

### Sample Input:

```
Enter Student Name: John Doe  
Enter Quiz Score (0-100): 85  
Enter Assignment Score (0-100): 92  
Enter Exam Score (0-100): 78  
Enter Project Score (0-100): 88  

Enter Student Name: Jane Smith  
Enter Quiz Score (0-100): 95  
Enter Assignment Score (0-100): 89  
Enter Exam Score (0-100): 84  
Enter Project Score (0-100): 90  
```

### Sample Output:

```
Student: John Doe  
Quiz Score: 85  
Assignment Score: 92  
Exam Score: 78  
Project Score: 88  
Final Grade: 85.5  
Letter Grade: B  

Student: Jane Smith  
Quiz Score: 95  
Assignment Score: 89  
Exam Score: 84  
Project Score: 90  
Final Grade: 89.8  
Letter Grade: B  

Average Grade of All Students: 87.65  

Highest Final Grade: 89.8  
```
