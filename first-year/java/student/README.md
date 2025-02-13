Create a program that will hold the quiz scores of students. Declare parallel arrays, the first array will hold the names of the students and another array that will hold the scores for corresponding quizzes. Refer to the following requirements:

* Declare an array of Strings that will hold the names of five (5) students.
    * Input the names of the students.
* Declare a corresponding two-dimensional ragged array to hold the quiz scores for each of the five (5) student.
    * User will be asked how many quizzes each student took.
    * Input the scores (1-100) for each quiz for each student.
    * Compute and display the average (percentage) for each student.
* Save the computed averages in another array declared as double.
* Determine the student with highest percentage. Display the corresponding name.

### Scoring Guide for Student.java

Code meets problem requirements: (20pts)

* *array declarations/instantiation*
    * *one dimensional(2)*
    * *two dimensional(4)*
* *input values in arrays*
    * *names (2)*
    * *quiz scores(4)*
* *displays required outputs*
    * Average Percentage from array (4)
    * Student with highest percentage (4)

Code is efficient and follows good programming practice. (5pts)

### Sample Output:

```
Name: John
Number of quizzes for John: 2
Input scores:
    87
    84
Name: Luke
Number of quizzes for Luke: 3
Input scores:
    80
    84
    83
Name: Matthew
Number of quizzes for Matthew: 2
Input scores:
    90
    86
Name: Mark
Number of quizzes for Mark: 4
Input scores:
    87
    86
    88
    89
Name: James
Number of quizzes for James: 2
Input scores:
    85
    81

Averages
John: 85.50
Luke: 82.33
Matthew: 88.00
Mark: 87.50
James: 83.00

Matthew has the highest average.
```