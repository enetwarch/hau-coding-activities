# These lines of code allow the user to input the names.
FIRST_NAME = input("Input the first name: ")
SECOND_NAME = input("Input the second name: ")

# The first if else condition will determine if the names are similar and prints out the corresponding message.
# The second if else condition will only run if both names are not equal.
# It will determine which of the two names have a greater value based on the ASCII table.
if FIRST_NAME == SECOND_NAME:
  print("The names are the same.")
else:
  print("The names are NOT the same.")
  if FIRST_NAME > SECOND_NAME:
    print(f"The name {FIRST_NAME} is greater than {SECOND_NAME}.")
  else:
    print(f"The name {SECOND_NAME} is greater than {FIRST_NAME}.")
