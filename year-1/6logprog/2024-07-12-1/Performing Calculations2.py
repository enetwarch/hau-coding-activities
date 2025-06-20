print("Weekly Pay Slip")
EMPLOYEE_NAME = input("Employee Name: ")
HOURS_WORKED = int(input("Hours Worked: "))
OVERTIME_HOURS = int(input("Overtime Hours: "))
HOURLY_RATE = float(input("Hourly Rate: ₱"))

GROSS_PAY = (HOURS_WORKED * HOURLY_RATE) + (OVERTIME_HOURS * HOURLY_RATE * 1.25)
INCOME_TAX = GROSS_PAY * .12
COOPERATIVE_SHARES = GROSS_PAY * .035
UNION_DUES = 135
TOTAL = INCOME_TAX + COOPERATIVE_SHARES + UNION_DUES
NET_PAY = GROSS_PAY - TOTAL

print(f"Gross Pay: ₱{GROSS_PAY:,.2f}")
print("Deductions:")
print(f"\tIncome Tax: ₱{INCOME_TAX:,.2f}")
print(f"\tCooperative Shares: ₱{COOPERATIVE_SHARES:,.2f}")
print(f"\tUnion Dues: ₱{UNION_DUES:,.2f}")
print(f"\tTotal: ₱{TOTAL:,.2f}")
print(f"Net Pay: ₱{NET_PAY:,.2f}")
