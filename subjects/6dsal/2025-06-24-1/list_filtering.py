# Hugo P. Molina
# CS-202

# This main function will run if the Python interpreter runs directly in this file.
# The numbers variable is a range of 1 to 20 because the 2nd arg (21) is exclusive or not included.
# Even and odd numbers are lists that use list comprehension which are basically for loops that return a list.
# The way list comprehension is used here is to only return said number if it fulfills the condition given.
# In this case, even numbers checks if there are no remainders while odd numbers checks if there are.
# Afterwards, the print blocks will print the output based on the sample output given in the instructions.
# The program will then be guaranteed to exit because of exit(0)
def main() -> None:
    numbers: range = range(1, 21)
    even_numbers: list[int] = [num for num in numbers if num % 2 == 0]
    odd_numbers: list[int] = [num for num in numbers if num % 2 == 1]

    print(f"Even numbers: {even_numbers}")
    print(f"Odd numbers: {odd_numbers}")

    exit(0)

# Guards the file from imports and only runs main only if the interpreter is run here directly.
# These are dunder (double underline) values that are automatically set by Python at runtime.
if __name__ == "__main__":
    main()
