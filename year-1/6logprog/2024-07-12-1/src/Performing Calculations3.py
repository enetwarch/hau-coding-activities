X = float(input("Input value of x: "))

ATHLETE_SPEED = X + 3
COVERED_DISTANCE = (X ** 2) + (5 * X) + 6
TIME_ELAPSED = COVERED_DISTANCE / ATHLETE_SPEED

print(f"Time elapsed: {TIME_ELAPSED:,.2f}hrs")
