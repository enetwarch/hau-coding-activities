# Hugo P. Molina
# ICT-102

# NOTE: The program will run with the bare minimum requirements from the instructions

class User:
  # This acts as the constructor function for the User class.
  def __init__(self, name: str, age: int, gender: str, address: str) -> None:
    self.name: str = name
    self.age: int = age
    self.gender: str = gender
    self.address: str = address

  # Runs when the users presses the first option.
  # Helper function with input validation for the name field.
  def input_name(self) -> str:
    while True:
      user_input: str = input("Please input your name: ")

      # Validation for name which checks if all characters are in the alphabet.
      # Returns the valid user input afterward as a new name.
      if user_input.isalpha():
        return user_input
      
      # Prints this if the output is not valid and repeats the loop.
      print("Please input a name that only contains alphabetical characters.")

  # Runs when the user presses the second option.
  # Helper function with input validation for the age field.
  def input_age(self) -> int:
    # The maximum age is set to 123 because that is the current world record.
    minimum_age: int = 0
    maximum_age: int = 123

    while True:
      try:
        user_input: int = int(input("Please input your age (): "))

        # Validation that makes sure the input is within the valid age range.
        if minimum_age <= user_input <= maximum_age:
          return user_input
        
        # Prompts the user to input a valid age range.
        print(f"Please input a valid age from {minimum_age} to {maximum_age}.")
      except ValueError:
        # Handles exceptions for when the user doesn't input an integer.
        print("Please input a valid integer.")

  # Runs when the user presses the third option.
  # Helper function with input validation for the gender field.
  def input_gender(self) -> str:
    while True:
      user_input: str = input("Please input your gender (m/f/nb): ").lower()

      # Validates the user option with only a small amount of valid options.
      # Only input "m", "f", and "nb" are valid.
      match user_input: # type: ignore
        case "m":
          return "Male"
        case "f":
          return "Female"
        case "nb":
          return "Non-binary"
        
      # If the function still has not returned something, it means the user input is invalid.
      # This will print out a prompt that will guide the user to correct their input.
      print('Please input "m", "f", or "nb" (case-insensitive).')

  # Runs when the user presses the fourth option.
  # Helper function with input validation for the address field.
  def input_address(self) -> str:
    # The address must be at least this many characters long.
    minimum_length: int = 9

    while True:
      user_input: str = input("Please input your address: ")
      
      # Validate the address to see if it is at least longer than the specified variable.
      if len(user_input) >= minimum_length:
        return user_input

      # This will print out a prompt that will guide the user to correct their input.
      print(f"Your address must be at least {minimum_length} characters long.")

  # Runs when the user presses the fifth option.
  # Displays the biodata like shown in the sample output.
  def display_biodata(self) -> None:
    print(f"Name: {self.name}")
    print(f"Age: {self.age}")
    print(f"Gender: {self.gender}")
    print(f"Address: {self.address}")

  # Main interaction interface in the program.
  def main(self) -> None:
    # Uses an infinite loop to keep the user locked in the interface.
    # The only way to break out of it is to press the exit option.
    while True:
      # Prints the possible options for the user.
      print("Options:")
      print("1. Set Name")
      print("2. Set Age")
      print("3. Set Gender")
      print("4. Set Address")
      print("5. Display Biodata")
      print("6. Exit")

      # Gets the user input in integer form with try catch for errors.
      try:
        user_input: int = int(input("Choose an option: "))

        # Handles the user's option accordingly.
        match user_input:
          case 1:
            # Sets the value of name to something else.
            self.name: str = self.input_name()
          case 2:
            # Sets the value of age to something else.
            self.age: int = self.input_age()
          case 3:
            # Sets the value of gender to something else.
            self.gender: str = self.input_gender()
          case 4:
            # Sets the value of address to something else.
            self.address: str = self.input_address()
          case 5:
            # Displays the biodata based on the sample output provided.
            self.display_biodata()
          case 6:
            # Breaks out of the loop and as a result, breaks out of the main() method.
            break

          case _:
            # Handles the case where the user did input an integer but it is not in the match case.
            print("Please input an integer value between 1-6.")
      except ValueError:
        # Handles error in string to int parsing if the user didn't input an int.
        print("Please input an appropriate integer value.")

      # Gives the user ample time to look at the result or prompt before repeating the loop.
      input("Would you like to proceed? (Press enter)")
      # Prints an empty space after every cycle of the loop for visual separation.
      print()

# Initializes default values which looks to appear by default in the sample output.
DEFAULT_NAME: str = "Rinel"
DEFAULT_AGE: int = 25
DEFAULT_GENDER: str = "Male"
DEFAULT_ADDRESS: str = "Mabalacat"

# Initializes the user object and runs main to initialize app interface.
# The user object will use the immutable constant variables named with CAPITAL_CASE.
user: User = User(DEFAULT_NAME, DEFAULT_AGE, DEFAULT_GENDER, DEFAULT_ADDRESS)
user.main()

# Exits the program with a program terminated message.
print("Program terminated.")
exit(0)
