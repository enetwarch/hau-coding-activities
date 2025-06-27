# Hugo P. Molina
# ICT-102

# Imports that will be used in the program.
# Random will help generate a random computer move.
# Typing will help increase string typesafety before runtime starts.
import random
from typing import Literal

# These are just types to help with code robustness, they are ignored completely in runtime.
# Move here only allows these 3 string literals and Score is a dictionary with only player and computer keys.
type Move = Literal["rock", "paper", "scissors"]
type Score = dict[Literal["player", "computer"], int]

# This is the main entry point of this school activity program script.
# The program first initializes a score dictionary that has type annotations for safety.
# An infinite loop is then started which prints out the user options, and gets the user input.
# Based on the user input, different actions will be done using various helper functions to accomplish them.
# Before the end of every loop, an input buffer asking the user to press enter will be printed to give them time to react.
# The user can exit the program by choosing the fourth option (5. Exit) which breaks out of the infinite loop.
# After the loop is broken, the last line of main just exits the program.
def main() -> None:
  score: Score = {"player": 0, "computer": 0}

  while True:
    print("Rock Paper Scissors:")
    print("1. Rock")
    print("2. Paper")
    print("3. Scissors")
    print("4. Score")
    print("5. Exit")

    match input_int("Choose an option (1/2/3/4/5): ", min=1, max=5):
      case 1: play_round("rock", score)
      case 2: play_round("paper", score)
      case 3: play_round("scissors", score)
      case 4: print_scores(score)
      case 5: break
      case _: pass

    input("Would you like to proceed? (Press enter) ")
    print()

  print("Program terminated.")
  exit(0)

# One of the more prevalent functions in this small script file as it handles the game.
# This function takes in the player move and the current scores which is a pass by reference dictionary.
# Using helper functions to determine who won, the function prints out the result and updates the scores accordingly.
# It is a non-pure function because it mutates the score and prints out something without returning anything.
# But the important part is this function is able to accomplish what it is designed to do and is pythonic.
def play_round(player_move: Move, score: Score) -> None:
  computer_move: Move = generate_computer_move()

  print(f"You played {player_move}!")
  print(f"The computer played {computer_move}!")

  if is_draw(player_move, computer_move): 
    print("It's a draw!")
  elif is_winner(player_move, computer_move):
    score["player"] += 1
    print("You won!")
  else:
    score["computer"] += 1
    print("You lost.")

# This is a helper function that triggers when the user presses the score option.
# There is nothing special in this void function, it just prints the scores like the name suggests.
def print_scores(score: Score) -> None:
  print(f"Player Score: {score["player"]}")
  print(f"Computer Score: {score["computer"]}")

# This function generates a random move meant for the computer.
# Randomly generates "rock", "paper", or "scissors" using the random library.
def generate_computer_move() -> Move:
  return random.choice(["rock", "paper", "scissors"])

# Checks if the moves played by the player and computer are equal, resulting in a draw.
def is_draw(player_move: Move, computer_move: Move) -> bool:
  return player_move == computer_move

# Checks if the moves played result in a win for the player.
# This massive conditional block consists of all the winning conditions for the player.
def is_winner(player_move: Move, computer_move: Move) -> bool:
  return (
    (player_move == "rock" and computer_move == "scissors") or
    (player_move == "paper" and computer_move == "rock") or
    (player_move == "scissors" and computer_move == "paper")
  )

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

# Guards the file from imports and only runs main only if the interpreter is run here directly.
# These are dunder (double underline) values that are automatically set by Python at runtime.
if __name__ == "__main__":
  main()
