# Hugo P. Molina
# ICT-102

# This is a simple program with error handling and some calculations.
# The program first asks for some essential data like employee name, hours worked, overtime, etc.
# Calculations on the income will then be made which are all based on the instructions.
# The results from said calculations will be printed in a neat format that follows the sample output.
# After all of those steps are done, the program will then be exited.
def main() -> None:
    print("Weekly Pay Slip")
    employee_name: str = input_str("Employee Name: ")
    hours_worked: int = input_int("Hours Worked (0-168): ", min=0, max=168)
    overtime_hours: int = input_int("Overtime Hours (0-168): ", min=0, max=168)
    hourly_rate: float = input_float("Hourly Rate: ₱")

    gross_pay: float = (hours_worked * hourly_rate) + (overtime_hours * hourly_rate * 1.25)
    income_text: float = gross_pay * 0.12
    cooperative_shares: float = gross_pay * 0.035
    union_dues: float = 135
    total: float = income_text + cooperative_shares + union_dues
    net_pay: float = gross_pay - total

    print(f"Employee Name: {employee_name}")
    print(f"Gross Pay: ₱{gross_pay:,.2f}")
    print("Deductions:")
    print(f"\tIncome Tax: ₱{income_text:,.2f}")
    print(f"\tCooperative Shares: ₱{cooperative_shares:,.2f}")
    print(f"\tUnion Dues: ₱{union_dues:,.2f}")
    print(f"\tTotal: ₱{total:,.2f}")
    print(f"Net Pay: ₱{net_pay:,.2f}")

    exit(0)

# The following functions are basically input() wrappers with some validation to help in activities.
# These functions will be copy pasted on the following activities and will act as a mini-library.

# A simple utility function that gets the user string input without any validation.
# The strip here simply removes excess whitespace the user might've inputted.
def input_str(prompt: str) -> str:
    return str(input(prompt).strip())

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

# A utility function that gets the user float input with some validation included.
# The function validates by checking if the input is a float and if it is in the range of arguments.
# The arguments min and max are optional but will default to the lowest and highest infinite values from Python.
# If the user input is found to be invalid, the function will print out a predetermined error message in the except block.
# Since the whole function is an infinite loop, the function will just prompt the user for inputs again.
# If the input is valid, the function simply returns the newly collect float input from the user.
def input_float(prompt: str, min: float = float("-inf"), max: float = float("inf")) -> float:
    while True:
        try:
            user_input: float = float(input(prompt).strip())
            if min <= user_input <= max: return user_input
            
            print(f"INPUT ERROR. Please input a value between {min:,.2f} to {max:,.2f}.")
        except ValueError:
            print("INPUT ERROR. Please input a float value.")

# Guards the file from imports and only runs main only if the interpreter is run here directly.
# These are dunder (double underline) values that are automatically set by Python at runtime.
if __name__ == "__main__":
    main()
