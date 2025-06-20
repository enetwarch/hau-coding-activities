X = int(input("Input value for x: "))
Y = int(input("Input value for y: "))
Z = int(input("Input value for z: "))

FORMULA = ((3 * (X ** 3) * (Y ** 2) * (Z ** 3)) + X) / (X + Y + Z)

print(f"Result: {FORMULA:,.2f}")
