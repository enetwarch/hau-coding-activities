# Hugo P. Molina
# ICT-102

# NOTE: The program will run with the bare minimum requirements from the instructions.

# Prints the program header as shown in the sample output.
print("Weekly Pay Slip")

# Asks for the user input on the following fields.
employee_name: str = input("Employee Name: ")
hours_worked: int = int(input("Hours Worked: "))
overtime_hours: int = int(input("Overtime Hours: "))
hourly_rate: float = float(input("Hourly Rate: ₱"))

# Initializes self documenting and well named variables to help calculations.
overtime_rate: float = 1.25
income_text_rate: float = 0.12
cooperative_shares_rate: float = 0.035

# Calculates the output based on the formula given on the instructions.
gross_pay: float = (hours_worked * hourly_rate) + (overtime_hours * hourly_rate * overtime_rate)
income_text: float = gross_pay * income_text_rate
cooperative_shares: float = gross_pay * cooperative_shares_rate
union_dues: float = 135
total: float = income_text + cooperative_shares + union_dues
net_pay: float = gross_pay - total

# Prints the output as requested by the instructions.
print(f"Gross Pay: ₱{gross_pay:,.2f}")
print("Deductions:")
print(f"\tIncome Tax: ₱{income_text:,.2f}")
print(f"\tCooperative Shares: ₱{cooperative_shares:,.2f}")
print(f"\tUnion Dues: ₱{union_dues:,.2f}")
print(f"\tTotal: ₱{total:,.2f}")
print(f"Net Pay: ₱{net_pay:,.2f}")

# Exits the program.
exit(0)
