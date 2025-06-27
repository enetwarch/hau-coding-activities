# Hugo P. Molina
# ICT-102

# This is the main entry point of this small activity program in Python.
# The program first initializes a User object that has default data taken from the sample output.
# An infinite loop is then initialized to lock the user inside an option to input cycle.
# Based on the user input, the match case will call different functions that have their own explanation.
# An input buffer is included to give the user time to react on the newly printed output.
# The only way to leave the loop is by choosing the 6th option (6. Exit) which breaks out of the loop.
# The program will then print terminated and be exited.
def main() -> None:
  user: User = User("Rinel", 25, "Male", "Mabalacat")

  while True:
    print("Options:")
    print("1. Set Name")
    print("2. Set Age")
    print("3. Set Gender")
    print("4. Set Address")
    print("5. Display Biodata")
    print("6. Exit")

    match input_int("Choose an action (1/2/3/4/5/6): ", min=1, max=6):
      case 1: user.name = input_name()
      case 2: user.age = input_age()
      case 3: user.gender = input_gender()
      case 4: user.address = input_address()
      case 5: user.display_biodata()
      case 6: break
      case _: pass

    input("Would you like to proceed? (Press enter) ")
    print()

  print("Program terminated.")
  exit(0)

# This is the user object required by the instructions.
# It contains the necessary data fields (name, age, gender, address).
# Unlike Java, Python's object data are all accessible and mutatable by default without any boilerplate.
class User:
  def __init__(self, name: str, age: int, gender: str, address: str) -> None:
    self.name: str = name
    self.age: int = age
    self.gender: str = gender
    self.address: str = address

  # Runs when the user presses the fifth option.
  # Displays the biodata like shown in the sample output and instructions.
  def display_biodata(self) -> None:
    print(f"Name: {self.name}")
    print(f"Age: {self.age}")
    print(f"Gender: {self.gender}")
    print(f"Address: {self.address}")

# The following functions are wrappers on top of the copy pasted input validation functions.
# The instructions require some sort of input validation and so here are the functions responsible for it.

# Runs when the user presses the first option.
# Helper function with input validation for the name field.
# All characters in the input must be in the alphabet, meaning no numbers or special characters allowed.
def input_name() -> str:
  while True:
    user_input: str = input_str("Please input your name: ")
    if user_input.isalpha(): return user_input

    print("Please input a name that only contains alphabetical characters.")

# Runs when the user presses the second option.
# Helper function with input validation for the age field.
# The inputted age must be within 0 to 123 years old.
def input_age() -> int:
  return input_int("Please input your age (0-123): ", min=0, max=123)

# Runs when the user presses the third optin.
# Helper function with input validation for the gender field.
# An infinite loop runs until the user inputs "m", "f", or "nb" to make the function return something.
def input_gender() -> str:
  while True:
    match input_str("Please input your gender (m/f/nb): ").lower():
      case "m": return "Male"
      case "f": return "Female"
      case "nb": return "Non-binary"
      case _: pass

    print('Please input either "m", "f", or "nb" (case-insensitive).')

# Runs when the user presses the fourth option.
# Helper function with input validation for the address field.
# The address must be at least 9 characters long, otherwise the input will not be returned.
def input_address() -> str:
  minimum_length: int = 9

  while True:
    user_input: str = input_str("Please input your address: ")
    if len(user_input) >= minimum_length: return user_input

    print(f"Your address must be at least {minimum_length} characters long.")

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

# A simple utility function that gets the user string input without any validation.
# The strip here simply removes excess whitespace the user might've inputted.
def input_str(prompt: str) -> str:
  return str(input(prompt).strip())

# Guards the file from imports and only runs main only if the interpreter is run here directly.
# These are dunder (double underline) values that are automatically set by Python at runtime.
if __name__ == "__main__":
  main()
