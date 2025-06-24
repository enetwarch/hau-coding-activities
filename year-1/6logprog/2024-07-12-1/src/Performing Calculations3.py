# Hugo P. Molina
# ICT-102

# NOTE: The program will run with the bare minimum requirements from the instructions.

# Asks the user to input a value.
X: float = float(input("Input value of x: "))

# Calculates the formulas given by the instructions.
ATHLETE_SPEED: float = X + 3
COVERED_DISTANCE: float = (X ** 2) + (5 * X) + 6
TIME_ELAPSED: float = COVERED_DISTANCE / ATHLETE_SPEED

# Prints the output which mirrors the sample output given in the instructions.
print(f"Time elapsed: {TIME_ELAPSED:,.2f}hrs")

# Exits the program.
exit(0)
