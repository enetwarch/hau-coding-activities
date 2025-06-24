# Hugo P. Molina
# ICT-102

# Imports that will be used in the program.
# Random will help generate a random computer move.
import random
# Typing will help increase string typesafety before runtime starts.
from typing import Literal

# Move is just a type to help with code robustness, it is ignored completely in runtime.
type Move = Literal["rock", "paper", "scissors"]
# Initializes a dictionary to help map integer values to actual moves in string format.
MOVES: dict[int, Move] = { 1: "rock", 2: "paper", 3: "scissors" }

# This function generates a random move meant for the computer.
def get_computer_move() -> Move:
  return MOVES[random.randint(1, 3)]

# Checks if the moves played by the player and computer result in a draw.
def is_draw(player_move: Move, computer_move: Move) -> bool:
  return player_move == computer_move

# Checks if the moves played result in a win for the player.
def is_player_winner(player_move: Move, computer_move: Move) -> bool:
  # This massive conditional block consists of all the winning conditions for the player.
  return (
    (player_move == "rock" and computer_move == "scissors") or
    (player_move == "paper" and computer_move == "rock") or
    (player_move == "scissors" and computer_move == "paper")
  )

# Initializes a dynamically changing variable in the program.
player_score: int = 0
computer_score: int = 0

# Starts an infinite loop that will act as the program interface.
while True:
  # Prints out the options available to the user.
  print("Rock Paper Scissors:")
  print("1. Rock")
  print("2. Paper")
  print("3. Scissors")
  print("4. Score")
  print("5. Exit")

  try:
    # Gets the user input in integer form.
    user_input: int = int(input("Choose an option: "))

    match user_input:
      case 1 | 2 | 3:
        # Gets the moves of both the player and the computer.
        player_move: Move = MOVES[user_input]
        computer_move: Move = get_computer_move()

        # Prints out the player and computer moves.
        print(f"You played {player_move}!")
        print(f"The computer played {computer_move}!")

        # Evaluates the moves and checks who won.
        # A draw will not add any scores while a win to either contestants will add one point to them.
        # It also prints the final state of the round for the user to see.
        if is_draw(player_move, computer_move):
          print("It's a draw!")
        else:
          if is_player_winner(player_move, computer_move):
            player_score += 1
            print("You won!")
          else:
            computer_score += 1
            print("You lost.")
      case 4:
        # Prints out the score of both the player and the computer.
        print(f"Player Score: {player_score}")
        print(f"Computer Score: {computer_score}")
      case 5:
        # Breaks out of the interface's infinite loop.
        break

      case _:
        # Handles the case where the user did input an integer but it is not in the match case.
        print("Please input an integer value between 1-5.")
  except ValueError:
    # Handles error in string to int parsing if the user didn't input an int.
    print("Please input an appropriate integer value.")

  # Gives the user ample time to look at the result or prompt before repeating the loop.
  input("Would you like to proceed? (Press enter)")
  # Prints an empty space after every cycle of the loop for visual separation.
  print()

# Terminates and exits the program.
print("Program terminated")
exit(0)
