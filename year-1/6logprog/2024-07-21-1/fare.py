# Hugo P. Molina
# ICT-102

# NOTE: The program will run with the bare minimum requirements from the instructions.

# A function that calculates the fare of the user.
def calculate_total_fare(base_fare: float, distance: float, discount: bool) -> float:
  if distance > 4:
    return base_fare + ((int(distance) - 4) * 1.5)
  if discount:
    return base_fare * 0.8
  return base_fare

# Prompts the user to input the distance and possible discount based on several factors.
distance: float = float(input("Distance Travelled (km): "))
discount: bool = input("Student/Senior/PWD (yes/no): ") == "yes"
base_fare: float = 13

# Calculates the fare by calling the function responsible for it.
total_fare: float = calculate_total_fare(base_fare, distance, discount)

# Prints the total fare and asks the user for their payment.
print(f"Total fare: ₱{total_fare:,.2f}")
payment: float = float(input("Payment: ₱"))

# Calculates the change and prints it if there is a change.
change: float = payment - total_fare
if change > 0:
  print(f"Change: ₱{change:,.2f}")

# Exits the program.
exit(0)
