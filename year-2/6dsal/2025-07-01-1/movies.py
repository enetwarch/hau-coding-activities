# Hugo P. Molina
# CS-202

# This will be the main function will only run if the interpreter is run here directly.
# The print blocks all mimic how the sample output is laid out.
# An empty watchlist string list is first initialized to make the program remember the watchlist.
# A for loop that repeats 5 times will then prompt the user to input their favorite movies.
# The current state of the movie watchlist will then be printed.
# The user will then be prompted to add and remove one entry in the watchlist.
# If there is a matching entry to be removed, it will be removed, otherwise it will print not found.
# The updated state of the movie watch list will then be printed and the program will be exited.
def main() -> None:
    watchlist: list[str] = []
    
    print("Enter 5 of your favorite movies:")
    for i in range(0, 5):
        watchlist.append(input_str(f"Movie {i + 1}: "))
        
    print()
    print(f"Your movie watchlist:")
    print(watchlist)
    print()
    
    watchlist.append(input_str("Enter a movie to add to your watchlist: "))
    to_remove: str = input_str("Enter a movie to remove from your watchlist: ")
    if to_remove in watchlist:
        watchlist.remove(to_remove)
        print(f"{to_remove} has been removed from your watchlist.")
    else:
        print(f"{to_remove} was not found in your watchlist.")
    
    print()
    print("Updated watchlist:")
    print(watchlist)
    print()
    print(f"You now have {len(watchlist)} movies in your watchlist")
    print()
    
    exit(0)
    
# This is a utility function that only gets the user input without any validation.
# The strip method removes any excess whitespace the user might've inputted.
def input_str(prompt: str) -> str:
    return input(prompt).strip()

# This is a guard clause to make sure the script only runs if the interpreter is run here directly.
# It is very useful when it comes to protecting this file against imports.
if __name__ == "__main__":
    main()
