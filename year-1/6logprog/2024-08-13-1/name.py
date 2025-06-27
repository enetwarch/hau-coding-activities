# Hugo P. Molina
# ICT-102

# This is the main entry point of this short and simple program.
# The first lines of code will prompt the user to input 2 names which are then stored in variables.
# The first if else condition will determine if the names are similar and prints out the corresponding message.
# The second if else condition will only run if both names are not equal.
# It will determine which of the two names have a greater value based on the ASCII table.
# After all of that is done, the program will be exited.
def main() -> None:
  first_name: str = input_str("Input the first name: ")
  second_name: str = input_str("Input the second name: ")

  if first_name == second_name:
    print("The names are the same.")
  else:
    print("The names are NOT the same.")
    if first_name > second_name:
      print(f"The name {first_name} is greater than {second_name}.")
    else:
      print(f"The name {second_name} is greater than {first_name}.")

  exit(0)

# A simple utility function that gets the user string input without any validation.
# The strip here simply removes excess whitespace the user might've inputted.
def input_str(prompt: str) -> str:
  return str(input(prompt).strip())

# Guards the file from imports and only runs main only if the interpreter is run here directly.
# These are dunder (double underline) values that are automatically set by Python at runtime.
if __name__ == "__main__":
  main()
