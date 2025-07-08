# Hugo P. Molina
# CS-202

# This main() function will be the entry point of the program.
# The program first initializes a file_name variable.
# A try with resources block is started with a file writer on "grades.txt" variable.
# Try with resources makes it so the file handler is closed automatically after the block ends.
# A for loop that repeats 5 times will then ask the user to input student name and grade.
# The file writer will then write the output on the file based on the given sample output.
# After 5 cycles of the loop, the program will read the file and print the readed file.
# The program will then be exited afterwards
def main() -> None:
    file_name: str = "grades.txt"
    
    with open(file_name, "w") as file:
        for _ in range(0, 5):
            student_name: str = input_str("Enter student name: ")
            student_grade: int = input_int("Enter student grade: ", min=0, max=100)
            file.write(f"{student_name} - {student_grade}\n")

    print()
    print("Stored Student Grades:")
    with open(file_name, "r") as file:
        print(file.read())

    exit(0)

# A simple utility function that gets the user string input without any validation.
# The strip here simply removes excess whitespace the user might've inputted.
def input_str(prompt: str) -> str:
    return str(input(prompt).strip())

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

# Guards the file from imports and only runs main only if the interpreter is run here directly.
# These are dunder (double underline) values that are automatically set by Python at runtime.
if __name__ == "__main__":
    main()
