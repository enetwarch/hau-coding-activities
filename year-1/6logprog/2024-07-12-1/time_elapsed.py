# Hugo P. Molina
# ICT-102

# NOTE: The program will run with the bare minimum requirements from the instructions.

# Asks the user to input a value.
x: float = float(input("Input value of x: "))

# Calculates the formulas given by the instructions.
athlete_speed: float = x + 3
covered_distance: float = (x ** 2) + (5 * x) + 6
time_elapsed: float = covered_distance / athlete_speed

# Prints the output which mirrors the sample output given in the instructions.
print(f"Time elapsed: {time_elapsed:,.2f}hrs")

# Exits the program.
exit(0)
