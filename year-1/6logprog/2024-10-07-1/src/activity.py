# Hugo P. Molina
# ICT-102

# Initializes the variable for history records.
HISTORY_RECORD = []

# Add function that returns the sum of 2 numbers.
def add(x, y):
  return f"{x} + {y} = {x + y}"

# Subtract function that returns the difference of 2 numbers.
def subtract(x, y):
  return f"{x} - {y} = {x - y}"

# Multiply function that returns the product of 2 numbers.
def multiply(x, y):
  return f"{x} * {y} = {x * y}"

# Divide function that returns the quotient of 2 numbers.
def divide(x, y):
  if y == 0:
    return f"{x} / {y} = Undefined"
  else:
    return f"{x} / {y} = {x / y}"

def finish():
  # Gives the user ample time to look at the result or prompt before repeating the loop.
  input("Would you like to proceed? (Press enter)")
  # Prints an empty space after every cycle of the loop.
  print()

# Initiates the loop.
while True:
  # Prints out the options for the user to choose.
  print("Select an action:")
  print("1. Addition")
  print("2. Subtraction")
  print("3. Multiplication")
  print("4. Division")
  print("5. Print History")
  print("6. Exit Program")
  
  # Gets the user input
  INPUT = int(input("Choose an option (1/2/3/4/5/6): "))

  # Validates user input.
  if not (INPUT >= 1 and INPUT <= 6):
    # Prints out this statement if the user input is invalid.
    print("Please input a valid number from 1 to 6.")
    finish()

    # Go back to the top of the loop.
    continue

  match INPUT: 
    # Performs an operation.
    case 1 | 2 | 3 | 4:
      # Asks the user to input 2 numbers for the operation.
      X = float(input("Enter the first number: "))
      Y = float(input("Enter the second number: "))

      # Performs the operation based on the user input.
      match INPUT:
        case 1: RESULT = add(X, Y)
        case 2: RESULT = subtract(X, Y)
        case 3: RESULT = multiply(X, Y)
        case 4: RESULT = divide(X, Y)

      # Prints out the result and records it.
      print(f"Result: {RESULT}")
      HISTORY_RECORD.append(RESULT)

    case 5:
      # Prints out the current history record.
      for i, HISTORY in enumerate(HISTORY_RECORD):
        print(f"Result {i + 1}: {HISTORY}")
      
    case 6:
      # Terminates the program by breaking out of the infinite loop.
      print("Program terminated.")
      break

  finish()
