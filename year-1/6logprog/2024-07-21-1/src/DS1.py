# Hugo P. Molina
# ICT-102

# NOTE: The program will run with the bare minimum requirement from the instructions.

# A function that calculates the fare of the user.
def calculate_total_fare(base_fare: float, distance: float, discount: bool) -> float:
  if distance > 4:
    return base_fare + ((int(distance) - 4) * 1.5)
  if discount:
    return base_fare * 0.8
  return base_fare

# Prompts the user to input the distance and possible discount based on several factors.
DISTANCE: float = float(input("Distance Travelled (km): "))
DISCOUNT: bool = input("Student/Senior/PWD (yes/no): ") == "yes"

# Calculates the fare by calling the function responsible for it.
BASE_FARE: float = 13
TOTAL_FARE: float = calculate_total_fare(BASE_FARE, DISTANCE, DISCOUNT)

# Prints the total fare and asks the user for their payment.
print(f"Total fare: ₱{TOTAL_FARE:,.2f}")
PAYMENT: float = float(input("Payment: ₱"))

# Calculates the change and prints it if there is a change.
CHANGE: float = PAYMENT - TOTAL_FARE 
if CHANGE > 0:
  print(f"Change: ₱{CHANGE:,.2f}")

# Exits the program.
exit(0)
