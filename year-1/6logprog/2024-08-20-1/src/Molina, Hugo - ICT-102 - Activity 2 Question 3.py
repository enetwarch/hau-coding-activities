# Hugo P. Molina
# ICT-102

# The calories burnt per minute is set to 4.2.
# The loop will start at number 10 with increments of 5 and will stop once it reaches 30.
# The interval of 10, 15, 20, 25, 30 minutes, and the amount of calories burnt in those time periods will be displayed.
CALORIES_PER_MIN = 4.2
for i in range(10, 31, 5):
  CALORIES_BURNED = i * CALORIES_PER_MIN
  print(f"{i} minutes: {CALORIES_BURNED:.0f} calories.")
