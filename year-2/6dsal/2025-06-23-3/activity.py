# Hugo P. Molina
# CS-202

# This main function will run if the Python interpreter is directly run in thsi file.
# In the first line, the program first asks for the user to enter a sentence.
# After the user has inputted a sentence, it will be lowercased and then split into separate arrays.
# The final result will be stored in the unique_words variable as a set.
# The print calls will print the unique_words set and the amount of elements it has.
# exit(0) will then guarantee the Python program to exit.
def main() -> None:
    unique_words: set[str] = set(input_str("Enter a sentence").lower().split(" "))

    print(f"Unique words: {unique_words}")
    print(f"Total unique words: {len(unique_words)}")

    exit(0)

# A simple utility function that gets the user string input without any validation.
# The strip here simply removes excess whitespace the user might've inputted.
def input_str(prompt: str) -> str:
    return str(input(prompt).strip())

# Guards the file from imports and only runs main only if the interpreter is run here directly.
# These are dunder (double underline) values that are automatically set by Python at runtime.
if __name__ == "__main__":
    main()
