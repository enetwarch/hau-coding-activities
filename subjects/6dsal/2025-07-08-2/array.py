# Hugo P. Molina
# CS-202

# This main() function will be the entry point of the program.
# The following program first initializes a 2d matrix list.
# There is a double for loop that then prompts the user to fill up the elements of the array.
# The matrix will then be printed alongside the row sum and column sum.
# exit(0) will then exit the program.
def main() -> None:
    matrix: list[list[int]] = []
    for i in range(2):
        matrix.append([])
        for j in range(3):
            matrix[i].append(input_int(f"Enter a value for [{i}][{j}]: "))
            
    print()
    print("Matrix:")
    for i in range(len(matrix)):
        print(matrix[i])

    print()
    print("Row sums:")
    for i in range(len(matrix)):
        print(f"Row {i + 1} sum: {calculate_row_sum(matrix, i)}")

    print()
    print("Column sums:")
    for i in range(len(matrix[0])):
        print(f"Column {i + 1} sum: {calculate_column_sum(matrix, i)}")

    exit(0)

# This is a calculator function that helps calculate the sum of a row.
# It simply uses the sum() method to get the sum of all the elements in a row.
def calculate_row_sum(matrix: list[list[int]], row: int) -> int:
    return sum(matrix[row])

# This is a calculator function that helps calculate the sum of a column.
# It uses list comprehension to collect only the columns of the array.
def calculate_column_sum(matrix: list[list[int]], column: int) -> int:
    return sum([row[column] for row in matrix])

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
