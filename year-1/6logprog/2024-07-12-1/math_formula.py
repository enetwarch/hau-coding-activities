# Hugo P. Molina
# ICT-102

# This is the short snippet of the activity which has very basic steps.
# The program first asks the user for 3 integer values (input validation included).
# It then prints the result based on the formula from the instructions.
# The program will then get exited after all those procedures are finished.
def main() -> None:
  x: int = input_int("Input value for x: ")
  y: int = input_int("Input value for y: ")
  z: int = input_int("Input value for z: ")

  print(f"Result: {use_formula(x, y, z):,.2f}")

  exit(0)

# A function that returns the calculations based on the formula given by the instructions.
# The parameters and the return value have type annotations to help reduce bugs and ambiguity.
def use_formula(x: int, y: int, z: int) -> float:
  return float(((3 * (x ** 3) * (y ** 2) * (z ** 3)) + x) / (x + y + z))

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
