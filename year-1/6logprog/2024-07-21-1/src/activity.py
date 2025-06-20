DISTANCE = float(input("Distance Travelled(km): "))
DISCOUNT = input("Student/Senior/PWD(yes/no): ")

FARE = 13
if DISTANCE > 4:
    FARE += ((int(DISTANCE) - 4) * 1.5)
if DISCOUNT == "yes":
    FARE *= .8

print(f"Total fare: ₱{FARE:,.2f}")
PAYMENT = float(input("Payment: ₱"))

CHANGE = PAYMENT - FARE
if CHANGE > 0:
  print(f"Change: ₱{CHANGE:,.2f}")
