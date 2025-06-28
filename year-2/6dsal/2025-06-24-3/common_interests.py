# Hugo P. Molina
# CS-202

# This is the main entry point of this small Python program.
# The program first initializes alice and bob's interests in set data types to prevent repeating elements.
# The common interests is then calculated using the intersection method from the set objects in Python.
# Print statements are then run which all mirror the output from the sample output.
# The common interests print uses ternary if else to print "none" if common interests are empty.
# The program is then guaranteed to be exited through exit(0).
def main() -> None:
    alice_interests: set[str] = {"gaming", "shopping", "sleeping"}
    bob_interests: set[str] = {"watching", "music", "eating"}
    common_interests: set[str] = alice_interests.intersection(bob_interests)

    print(f"Alice's interests: {alice_interests}")
    print(f"Bob's interests: {bob_interests}")
    print(f"Common interests: {"none" if len(common_interests) == 0 else common_interests}")

    exit(0)

# Guards the file from imports and only runs main only if the interpreter is run here directly.
# These are dunder (double underline) values that are automatically set by Python at runtime.
if __name__ == "__main__":
    main()
