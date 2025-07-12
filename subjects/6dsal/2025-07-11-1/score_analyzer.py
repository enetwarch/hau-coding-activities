# Hugo P. Molina
# CS-202

# This main() function will act as the main entry point for the program.
# The program first stores the file name in a variable and prompts the user for the students and subject amount.
# A try with resources that has for loops will then prompt the user for the student name and subject scores.
# The try with for that part has a write access to file, and thus, it will write the collect data in CSV format.
# Some calculations will then be made by calling some functions which have their own explanation.
# The data calculated will then be printed, which will be based on the sample output provided.
# After all of those steps are finished, the program will then be exited with code 0.
# NOTE: The enumerate() function being used in some for loops just means it will iterate the element and its index.
# NOTE: A variable with the name _ just means that variable will not be used and is only there due to it being required.
def main() -> None:
    file_name: str = "exam_scores.txt"

    students: int = input_int("Enter number of students: ", min=1) 
    subjects: int = input_int("Enter number of subjects: ", min=1)
    print()

    with open(file_name, "w") as file:
        for _ in range(students):
            file.write(input_str("Enter student name: "))

            for i in range(subjects):
                file.write(f",{input_int(f"Enter score for Subject {i + 1}: ", min=0, max=100)}")
            
            file.write("\n")
            print()

    print(f"Data written to {file_name}")
    print()

    grades: list[tuple[str, list[int]]] = parse_file(file_name)
    student_scores: list[tuple[int, float]] = calculate_student_scores(grades)
    subject_average: list[float] = calculate_subject_average(grades)
    top_scorer: tuple[str, int] = calculate_top_scorer(grades)
    lowest_scorer: tuple[str, int] = calculate_lowest_scorer(grades)

    print("Student Scores:")
    for i, (name, scores) in enumerate(grades):
        (total, average) = student_scores[i]
        print(f"Student: {name} | Scores: {scores} | Total: {total} | Average: {average:,.2f}")
    print()

    print("Class Average per Subject:")
    for i, average in enumerate(subject_average):
        print(f"Subject {i + 1}: {average:,.2f}")
    print()

    (top_scorer_name, top_scorer_total) = top_scorer
    print(f"Top Scorer: {top_scorer_name} (Total: {top_scorer_total})")
    (lowest_scorer_name, lowest_scorer_total) = lowest_scorer
    print(f"Lowest Scorer: {lowest_scorer_name} (Total: {lowest_scorer_total})")
    print()

    exit(0)

# This is a helper function that extracts the data out of the file based on the file writer.
# It assumes that the data is stored in CSV style and that they are separated by commas.
# After reading through the line, it will append that data into an array and proceed to the next loop cycle.
# The way it parses scores is by appending all the data in the values list as ints starting from index 1 onwards.
# It returns a Grade data type which is a 2d array that stores a tuple with string and a list of ints.
def parse_file(file_name: str) -> list[tuple[str, list[int]]]:
    grades: list[tuple[str, list[int]]] = []

    with open(file_name, "r") as file:
        for line in file:
            values: list[str] = line.strip().split(",")
            name: str = values[0]
            scores: list[int] = list(map(int, values[1:]))

            grades.append((name, scores))

    return grades

# This is a calculator function that returns a list of tuples with int (total) and float (average) values.
# It will return an empty array if grades is a completely empty array.
# It loops through all the scores in the grades array, calculates the total and average, and then appends it to student_scores.
# After the loop ends, it will return student_scores.
def calculate_student_scores(grades: list[tuple[str, list[int]]]) -> list[tuple[int, float]]:
    student_scores: list[tuple[int, float]] = []
    if not grades: return student_scores

    for (_, scores) in grades:
        total: int = sum(scores)
        average: float = total / len(scores)
        
        student_scores.append((total, average))
    
    return student_scores


# This function will calculate the average of each subject.
# It will initialize an empty array and then return it only if the grades argument is an empty array.
# A for loop will then be initialized that will loop with each amount of subjects.
# List comprehension is used in the for loop to get only the scores in that subject, basically get its column.
# The average is then calculated and appended to subject_average, which is returned after the loop ends.
def calculate_subject_average(grades: list[tuple[str, list[int]]]) -> list[float]:
    subject_average: list[float] = []
    if not grades: return subject_average

    for i in range(len(grades[0][1])):
        scores: list[int] = [grade[1][i] for grade in grades]
        average: float = sum(scores) / len(scores)

        subject_average.append(average)

    return subject_average

# This is a calculator function that returns a tuple with a string (name) and int (total) as values.
# It initializes top_scorer with "Unknown" and the lowest integer limit (to make comprisons better) as the value.
# It will return that initialized top_scorer if the grades array is completely empty.
# It will loop through all the students and replace top_scorer with the student with a higher total.
# After all of that, it will return the top_scorer with an actual student.
def calculate_top_scorer(grades: list[tuple[str, list[int]]]) -> tuple[str, int]:
    top_scorer: tuple[str, int] = ("Unknown", -2**31)  
    if not grades: return top_scorer

    for (name, scores) in grades:
        total: int = sum(scores)
        if total > top_scorer[1]:
            top_scorer = (name, total)
    
    return top_scorer

# This is a calculator function that returns a tuple with a string (name) and int (total) as values.
# It does exactly the same thing as calculate_top_scorer but the inverse.
def calculate_lowest_scorer(grades: list[tuple[str, list[int]]]) -> tuple[str, int]:
    top_scorer: tuple[str, int] = ("Unknown", 2**31)  
    if not grades: return top_scorer

    for (name, scores) in grades:
        total: int = sum(scores)
        if total < top_scorer[1]:
            top_scorer = (name, total)
    
    return top_scorer

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

# A simple utility function that gets the user string input without any validation.
# The strip here simply removes excess whitespace the user might've inputted.
def input_str(prompt: str) -> str:
    return str(input(prompt).strip())

# Guards the file from imports and only runs main only if the interpreter is run here directly.
# These are dunder (double underline) values that are automatically set by Python at runtime.
if __name__ == "__main__":
    main()
