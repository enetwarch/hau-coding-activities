# Hugo P. Molina
# ICT-102

# NOTE: The program will run with the bare minimum requirements from the instructions.

# Prompts the user to input the amount of subjects they will calculate.
number_of_subjects: int = int(input("Input the number of subjects: "))

# Initializes mutable variables for the while loop.
subject_number: int = 1
total_grade: float = 0

# The loop will ask for the grade in each subject based on the amount of subjects inputted.
# After the loop ends, the average grade will be calculated.
while subject_number <= number_of_subjects:
  total_grade += float(input(f"What is your grade in subject {subject_number}? "))
  subject_number += 1

# Calculates the average grade and prints it.
AVERAGE_GRADE = total_grade / number_of_subjects
print(f"Your average grade is: {AVERAGE_GRADE:.2f}")

# Exits the program.
exit(0)
