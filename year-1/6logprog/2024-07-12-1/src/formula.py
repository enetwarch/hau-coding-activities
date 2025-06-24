# Hugo P. Molina
# ICT-102

# NOTE: The program will run with the bare minimum requirements from the instructions.

# A function that returns the calculations based on the formula given by the instructions.
def formula(x: int, y: int, z: int) -> float:
  return float(((3 * (x ** 3) * (y ** 2) * (z ** 3)) + x) / (x + y + z))

# Asks the user to input 3 integer values and stores them in x, y, and z variables.
x: int = int(input("Input value for x: "))
y: int = int(input("Input value for y: "))
z: int = int(input("Input value for z: "))

# Uses the formula function to calculate the answer and stores it in a variable.
result: float = formula(x, y, z)

# Prints the result like shown in the sample output.
print(f"Result: {result:,.2f}")

# Exits the program.
exit(0)
