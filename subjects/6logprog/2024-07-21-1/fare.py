# Hugo P. Molina
# ICT-102

# This is the main entry point of the program that will only run after the import guard at the last line.
# The program will first prompt the user about their distance travelled and whether they are eligible for discount.
# The fare will then be calculated by a function with its own explanations and then the payment is prompted.
# If the payment is more than 0, it will be printed, and then the program will be exited afterwards.
def main() -> None:
    distance: float = input_float("Distance Travelled (km): ")
    discount: bool = input_bool("Student/Senior/PWD (y/n): ")

    total_fare: float = calculate_total_fare(13, distance, discount)
    print(f"Total fare: ₱{total_fare:,.2f}")

    payment: float = float(input("Payment: ₱"))
    change: float = payment - total_fare
    if change > 0: print(f"Change: ₱{change:,.2f}")

    exit(0)

# A function that calculates the fare of the user based on the distance and discounts.
# The formula it follows it based from the instructions and sample output.
def calculate_total_fare(base_fare: float, distance: float, discounted: bool) -> float:
    if distance > 4: return base_fare + ((int(distance) - 4) * 1.5)
    if discounted: return base_fare * 0.8
    return base_fare

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

# A utility function that gets a string input but returns a boolean based on the user input.
# The input validation step for this method is that it only accepts fixed values which are:
# "y" or "yes" (true) and "n" or "no" (false) all of which are case-insensitive and whitespace safe due to lower and strip.
# It will print an error message otherwise and loop back in this infinite loop.
def input_bool(prompt: str) -> bool:
    while True:
        user_input: str = input(prompt).strip().lower()

        if user_input in {"y", "yes"}: return True
        if user_input in {"n", "no"}: return False

        print("INPUT ERROR. Please input either 'y', 'yes', 'n', or 'no'.")

# Guards the file from imports and only runs main only if the interpreter is run here directly.
# These are dunder (double underline) values that are automatically set by Python at runtime.
if __name__ == "__main__":
    main()
