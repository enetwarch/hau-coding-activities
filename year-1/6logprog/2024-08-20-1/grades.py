# Hugo P. Molina
# ICT-102

# This is the main entry point of this simple Python program.
# The first line prompts the user to input the amount of subjects they will calculate.
# Afterwards, the loop will ask for the grade in each subject based on the amount of subjects inputted.
# After the loop ends, the average grade will be calculated and printed.
# The program will be exited after all of those processes are completed.
def main() -> None:
    number_of_subjects: int = input_int("Input the number of subjects: ", min=0)
    subject_number: int = 1
    total_grade: float = 0

    while subject_number <= number_of_subjects:
        grade: float = input_float(f"What is your grade in subject #{subject_number} (0-100)?: ", min=0, max=100)
        total_grade += grade
        subject_number += 1

    average_grade: float = total_grade / number_of_subjects
    print(f"Your average grade is: {average_grade:.2f}")

    exit(0)

# A utility function that gets the user integer input with some validation included.
# The function validates by checking if the input is an integer and if it is in the range of arguments.
# The arguments min and max are optional but will default to the 32-bit integer limit.
# If the user input is found to be invalid, the function will print out a predetermined error message in the except block.
# Since the whole function is an infinite loop, the function will just prompt the user for inputs again.
# If the input is valid, the function simply returns the newly collect integer input from the user.
def input_int(prompt: str, min: int = -2**31, max: int = 2**31) -> int:
    while True:
        try:
            user_input: int = int(input(prompt).strip())
            if min <= user_input <= max: return user_input
            
            print(f"INPUT ERROR. Please input a value between {min:,d} to {max:,d}.")
        except ValueError:
            print("INPUT ERROR. Please input an integer value.")

# A utility function that gets the user float input with some validation included.
# The function validates by checking if the input is a float and if it is in the range of arguments.
# The arguments min and max are optional but will default to the lowest and highest infinite values from Python.
# If the user input is found to be invalid, the function will print out a predetermined error message in the except block.
# Since the whole function is an infinite loop, the function will just prompt the user for inputs again.
# If the input is valid, the function simply returns the newly collect float input from the user.
def input_float(prompt: str, min: float = float("-inf"), max: float = float("inf")) -> float:
    while True:
        try:
            user_input: float = float(input(prompt).strip())
            if min <= user_input <= max: return user_input
            
            print(f"INPUT ERROR. Please input a value between {min:,.2f} to {max:,.2f}.")
        except ValueError:
            print("INPUT ERROR. Please input a float value.")

# Guards the file from imports and only runs main only if the interpreter is run here directly.
# These are dunder (double underline) values that are automatically set by Python at runtime.
if __name__ == "__main__":
    main()
