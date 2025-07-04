# Hugo P. Molina
# CS-202

# This function will be invoked when the Python interpreter runs directly in this file.
# The program first assigns a student_grades tuple with 3 values which immediately gets unpacked.
# The average is calculated using sum() which adds all the tuple ints and len() divisor to get the amount of elements.
# The grades will be printed using the unpacked tuple values and average grade based on the sample output.
# exit(0) then guarantees termination of this small Python program.
def main() -> None:
    student_grades: tuple[int, int, int] = (85, 92, 78)
    (math, science, english) = student_grades
    
    average: float = sum(student_grades) / len(student_grades)

    print(f"Grades: Math={math}, Science={science}, English={english}")
    print(f"Average Grade: {average}")

    exit(0)

# Guards the file from imports and only runs main only if the interpreter is run here directly.
# These are dunder (double underline) values that are automatically set by Python at runtime.
if __name__ == "__main__":
    main()
