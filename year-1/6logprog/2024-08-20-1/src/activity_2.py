# Hugo P. Molina
# ICT-102

# Initializes the values of the necessary variables.
i = 0
total_grade = 0
num_subjects = int(input("Input the number of subjects: "))
AVERAGE_DIVIDER = num_subjects

# The loop will ask for the grade in each subject based on the amount of subjects inputted.
# After the loop ends, the average grade will be calculated.
while num_subjects > 0:
  i += 1
  total_grade += float(input(f"What is your grade in subject {i}? "))
  num_subjects -= 1

AVERAGE_GRADE = total_grade / AVERAGE_DIVIDER
print(f"Your average grade is: {AVERAGE_GRADE:.2f}")
