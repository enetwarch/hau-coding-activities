# Hugo P. Molina
# ICT-102

# This is the main entry point of this simple program.
# The first line prompts the user to input a word.
# The for loop iterates through every character of the word and prints it.
# The program will then be exited afterwards.
def main() -> None:
  word: str = input("Input a word: ")
  for character in word:
    print(character)

  exit(0)

# A simple utility function that gets the user string input without any validation.
# The strip here simply removes excess whitespace the user might've inputted.
def input_str(prompt: str) -> str:
  return str(input(prompt).strip())

# Guards the file from imports and only runs main only if the interpreter is run here directly.
# These are dunder (double underline) values that are automatically set by Python at runtime.
if __name__ == "__main__":
  main()
