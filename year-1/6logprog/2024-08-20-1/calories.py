# Hugo P. Molina
# ICT-102

# The calories burnt per minute is set to 4.2.
# The loop will start at number 10 with increments of 5 and will stop once it reaches 30.
# The interval of 10, 15, 20, 25, 30 minutes, and the amount of calories burnt in those time periods will be displayed.
# After all of that is done, the program will be exited.
def main() -> None:
  calories_per_min: float = 4.2
  for minutes in range(10, 31, 5):
    calories_burned: float = minutes * calories_per_min
    print(f"{minutes} minutes: {calories_burned:.0f} calories.")

  exit(0)

# Guards the file from imports and only runs main only if the interpreter is run here directly.
# These are dunder (double underline) values that are automatically set by Python at runtime.
if __name__ == "__main__":
  main()
