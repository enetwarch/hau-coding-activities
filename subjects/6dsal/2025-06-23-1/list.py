# Hugo P. Molina
# CS-202

# This is the main function that will run if the Python interpreter runs directly in this file.
# It first initializes an empty shopping list variable which is supposed to be a list that contains strings.
# A loop then prompts the user to add an item to their shopping list 5 times.
# range(0, 5) translates to [0, 1, 2, 3, 4] which is a 5 length array because 5 (2nd arg) is exclusive in range().
# The for loop runs 5 times, but the _ variable just means it will not be used in the loop, just a stick to make it run.
# After that, the user is prompted to enter an item to remove in the shopping list.
# The if conditional looks for the matching item in the list and removes the first matching item.
# Item not found will be printed if the program did not find any matching strings in the shopping list.
# Lastly, the sort() function is played which arranges the list alphabetically by default.
# The final sorted list is then printed and the program is exited.
def main() -> None:
    shopping_list: list[str] = []

    for _ in range(0, 5):
        shopping_list.append(input_str("Add an item to your shopping list: "))
    
    print(f"Current list: {shopping_list}")

    to_remove: str = input_str("Enter an item to remove: ")
    if to_remove in shopping_list:
        shopping_list.remove(to_remove)
    else:
        print("Item not found!")
    
    shopping_list.sort()
    print(f"Final sorted list: {shopping_list}")

    exit(0)

# A simple utility function that gets the user string input without any validation.
# The strip here simply removes excess whitespace the user might've inputted.
def input_str(prompt: str) -> str:
    return str(input(prompt).strip())

# Guards the file from imports and only runs main only if the interpreter is run here directly.
# These are dunder (double underline) values that are automatically set by Python at runtime.
if __name__ == "__main__":
    main()
