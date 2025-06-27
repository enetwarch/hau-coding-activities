# Hugo P. Molina
# ICT-102

# This is a very simple program which asks for an input, does some calculations, and displays the result.
# A float value will be asked first (input validation included), and calculations will be made based from the instructions.
# The calculated result will be printed afterwards, and the program exits.
def main() -> None:
  x: float = input_float("Input value of x: ")

  athlete_speed: float = x + 3
  covered_distance: float = (x ** 2) + (5 * x) + 6
  time_elapsed: float = covered_distance / athlete_speed

  print(f"Time elapsed: {time_elapsed:,.2f}hrs")

  exit(0)

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
      
      print(f"INPUT ERROR. Please input a value between {min:,d} to {max:,d}.")
    except ValueError:
      print("INPUT ERROR. Please input a float value.")

# Guards the file from imports and only runs main only if the interpreter is run here directly.
# These are dunder (double underline) values that are automatically set by Python at runtime.
if __name__ == "__main__":
  main()
