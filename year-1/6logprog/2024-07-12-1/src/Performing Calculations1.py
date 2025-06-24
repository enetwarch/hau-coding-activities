# Hugo P. Molina
# ICT-102

# NOTE: The program will run with the bare minimum requirements from the instructions.

# A function that returns the calculations based on the formula given by the instructions.
def formula(x: int, y: int, z: int) -> float:
  return float(((3 * (x ** 3) * (y ** 2) * (z ** 3)) + x) / (x + y + z))

# Asks the user to input 3 integer values and stores them in X, Y, and Z variables.
X: int = int(input("Input value for x: "))
Y: int = int(input("Input value for y: "))
Z: int = int(input("Input value for z: "))

# Uses the formula function to calculate the answer and stores it in a variable.
RESULT: float = formula(X, Y, Z)

# Prints the result like shown in the sample output.
print(f"Result: {RESULT:,.2f}")

# Exits the program.
exit(0)
