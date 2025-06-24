# Hugo P. Molina
# ICT-102

# NOTE: The program will run with the bare minimum requirements from the instructions.

# These lines of code allow the user to input the names.
first_name: str = input("Input the first name: ")
second_name: str = input("Input the second name: ")

# The first if else condition will determine if the names are similar and prints out the corresponding message.
# The second if else condition will only run if both names are not equal.
# It will determine which of the two names have a greater value based on the ASCII table.
if first_name == second_name:
  print("The names are the same.")
else:
  print("The names are NOT the same.")
  if first_name > second_name:
    print(f"The name {first_name} is greater than {second_name}.")
  else:
    print(f"The name {second_name} is greater than {first_name}.")

# Exits the program.
exit(0)
