# Hugo P. Molina
# ICT-102

# NOTE: The program will run with the bare minimum requirements from the instructions.

# Initializes the variable for history records.
history_record: list[str] = []

# All of these calculation functions will return an equation format.
# They all take in 2 float data type arguments (x, y).

def add(x: float, y: float) -> str:
  return f"{x} + {y} = {x + y}"

def subtract(x: float, y: float) -> str:
  return f"{x} - {y} = {x - y}"

def multiply(x: float, y: float) -> str:
  return f"{x} * {y} = {x * y}"

def divide(x: float, y: float) -> str:
  if y == 0:
    return f"{x} / {y} = Undefined"
  else:
    return f"{x} / {y} = {x / y}"

# Initiates the infinite loop.
while True:
  # Prints out the options for the user to choose.
  print("Select an action:")
  print("1. Addition")
  print("2. Subtraction")
  print("3. Multiplication")
  print("4. Division")
  print("5. Print History")
  print("6. Exit Program")
  
  # Gets the user input in integer form.
  user_input: int = int(input("Choose an option (1/2/3/4/5/6): "))

  match user_input: 
    # Performs an operation.
    case 1 | 2 | 3 | 4:
      # Asks the user to input 2 numbers for the operation.
      x: float = float(input("Enter the first number: "))
      y: float = float(input("Enter the second number: "))

      # Performs the operation based on the user input.
      match user_input:
        case 1: result: str = add(x, y)
        case 2: result: str = subtract(x, y)
        case 3: result: str = multiply(x, y)
        case 4: result: str = divide(x, y)

      # Prints out the result and records it.
      print(f"Result: {result}")
      history_record.append(result)

    case 5:
      # Prints out the current history record.
      for i, history in enumerate(history_record):
        print(f"Result {i + 1}: {history}")
      
    case 6:
      # Exits the program with a program terminated message.
      print("Program terminated.")
      exit(0)

    case _:
      # This is the default case which prints out this statement if the user input is invalid.
      print("Please input a number from 1 to 6.")

  # Gives the user ample time to look at the result or prompt before repeating the loop.
  input("Would you like to proceed? (Press enter)")
  # Prints an empty space after every cycle of the loop for visual separation.
  print()
