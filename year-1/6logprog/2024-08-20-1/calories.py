# Hugo P. Molina
# ICT-102

# NOTE: The program will run with the bare minimum requirements from the instructions.

# The calories burnt per minute is set to 4.2.
# The loop will start at number 10 with increments of 5 and will stop once it reaches 30.
# The interval of 10, 15, 20, 25, 30 minutes, and the amount of calories burnt in those time periods will be displayed.
calories_per_min: float = 4.2
for minutes in range(10, 31, 5):
  calories_burned: float = minutes * calories_per_min
  print(f"{minutes} minutes: {calories_burned:.0f} calories.")

# Exits the program.
exit(0)
