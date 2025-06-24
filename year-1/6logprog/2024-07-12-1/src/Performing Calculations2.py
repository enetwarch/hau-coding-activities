# Hugo P. Molina
# ICT-102

# NOTE: The program will run with the bare minimum requirements from the instructions.

# Prints the program header as shown in the sample output.
print("Weekly Pay Slip")

# Asks for the user input on the following fields.
EMPLOYEE_NAME: str = str(input("Employee Name: "))
HOURS_WORKED: int = int(input("Hours Worked: "))
OVERTIME_HOURS: int = int(input("Overtime Hours: "))
HOURLY_RATE: float = float(input("Hourly Rate: ₱"))

# Initializes self documenting and well named variables to help calculations.
OVERTIME_RATE: float = 1.25
INCOME_TAX_RATE: float = 0.12
COOPERATIVE_SHARES_RATE: float = 0.035

# Calculates the output based on the formula given on the instructions.
GROSS_PAY: float = (HOURS_WORKED * HOURLY_RATE) + (OVERTIME_HOURS * HOURLY_RATE * OVERTIME_RATE)
INCOME_TAX: float = GROSS_PAY * INCOME_TAX_RATE
COOPERATIVE_SHARES: float = GROSS_PAY * COOPERATIVE_SHARES_RATE
UNION_DUES: float = 135
TOTAL: float = INCOME_TAX + COOPERATIVE_SHARES + UNION_DUES
NET_PAY: float = GROSS_PAY - TOTAL

# Prints the output as requested by the instructions.
print(f"Gross Pay: ₱{GROSS_PAY:,.2f}")
print("Deductions:")
print(f"\tIncome Tax: ₱{INCOME_TAX:,.2f}")
print(f"\tCooperative Shares: ₱{COOPERATIVE_SHARES:,.2f}")
print(f"\tUnion Dues: ₱{UNION_DUES:,.2f}")
print(f"\tTotal: ₱{TOTAL:,.2f}")
print(f"Net Pay: ₱{NET_PAY:,.2f}")

# Exits the program.
exit(0)
