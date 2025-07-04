# Hugo P. Molina
# CS-202

# Imports the math package which will be used in this activity as said by the instructions.
import math

# The main method will be run if the Python interpreter is initialized directly in this file.
# 2 point coordinates will be made with type tuple (x, y) where x and y are integers.
# The tuples will be unpacked for easier variable assignment and the distance is calculated.
# The print statements will then mirror the output from the sample output.
# After all of those procedures are done, the program will be exited.
def main() -> None:
    point_a: tuple[int, int] = (3, 4)
    point_b: tuple[int, int] = (7, 1)

    (x1, y1) = point_a
    (x2, y2) = point_b
    distance: float = calculate_euclidean_distance(x1, x2, y1, y2)

    print(f"Point A: {point_a}")
    print(f"Point B: {point_b}")
    print(f"Distance between points: {distance}")

    exit(0)

# A calculator function that will return the result based on the Euclidean distance formula.
# Takes in x1, x2, y1, and y2 as arguments just like the instructions wrote.
# Each of the arguments are typed with float to make the program safer.
def calculate_euclidean_distance(x1: float, x2: float, y1: float, y2: float) -> float:
    return math.sqrt(((x2 - x1) ** 2) + ((y2 - y1) ** 2))

# Guards the file from imports and only runs main only if the interpreter is run here directly.
# These are dunder (double underline) values that are automatically set by Python at runtime.
if __name__ == "__main__":
    main()
