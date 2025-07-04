# Hugo P. Molina
# ICT-102

# Imports that will be used in the program.
# Typing will help increase string typesafety before runtime starts.
from typing import Callable

# This is the main entry point for this small Python script.
# An empty history record string list is initialized to keep track of the record of all the operations.
# An infinite loop is initiated to keep the user locked in the interface full of printed options.
# The program will prompt an input from the user and the match case will handle it with various functions.
# An input buffer is added to give the user time to react to the newly printed output.
# When the user presses the 6th option (6. Exit Program), the infinite loop is broken.
# The program will then print terminated and be exited.
def main() -> None:
    history_record: list[str] = []

    while True:
        print("Calculator:")
        print("1. Addition")
        print("2. Subtraction")
        print("3. Multiplication")
        print("4. Division")
        print("5. Print History")
        print("6. Exit Program")

        match input_int("Choose an action (1/2/3/4/5/6): ", min=1, max=6):
            case 1: perform_operation(add, history_record)
            case 2: perform_operation(subtract, history_record)
            case 3: perform_operation(multiply, history_record)
            case 4: perform_operation(divide, history_record)
            case 5: print_history(history_record)
            case 6: break
            case _: pass

        input("Would you like to proceed? (Press enter) ")
        print()

    print("Program terminated.")
    exit(0)

# This is going to be the most used function in this small script.
# A function or lambda will be passed right in, type annotation will help with this.
# Annotating to this type means a type must have 2 float arguments and a string return which is what we have.
# This function asks for two float inputs and then uses the passed in operation to get the result.
# The result is then appended to the history record and printed.
def perform_operation(operation: Callable[[float, float], str], history_record: list[str]) -> None:
    x: float = input_float("Enter the first number: ")
    y: float = input_float("Enter the second number: ")

    result: str = operation(x, y)
    history_record.append(result)

    print(result)

# This is a simple function that prints out the record history and tells if it is empty.
# If the history is not empty, the results will be printed in a neat format based on the sample output.
def print_history(history_record: list[str]) -> None:
    if not history_record:
        print("History record is empty.")
    else:
        for i, history in enumerate(history_record):
            print(f"Result {i + 1}: {history}")

# The following code are all the calculator functions required by the instructions.
# All of these calculation functions will return an equation format.
# They all take in 2 float data type arguments (x, y).

def add(x: float, y: float) -> str:
    return f"{x} + {y} = {x + y}"

def subtract(x: float, y: float) -> str:
    return f"{x} - {y} = {x - y}"

def multiply(x: float, y: float) -> str:
    return f"{x} * {y} = {x * y}"

# This function uses ternary operation to return "Undefined" or the normal division quotient.
# Undefined will be returned as the quotient if the y or divisor is 0.
def divide(x: float, y: float) -> str:
    return f"{x} / {y} = {"Undefined" if y == 0 else x / y}"

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
