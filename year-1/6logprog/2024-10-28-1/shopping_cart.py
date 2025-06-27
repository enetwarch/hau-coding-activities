# Hugo P. Molina
# ICT-102

# The shopping cart is initialized along with these types to help with typesafety.
# This type basically just means a list (cart) of string and float tuples (item, cost).
type Cart = list[Item]

# This is the main entry point of this school activity program script.
# The program first initializes an empty cart which will dynamically increase and decrease at runtime.
# An infinite loop is initiated which perpetually prints out options and asks the user for the choice.
# Based on the choice, the program will handle it differently by calling different functions.
# There is an input buffer at the end of the loop cycle to give the user time to react to the changes.
# Choosing the fifth option (5. Exit) will break the infinite loop and terminate the program.
def main() -> None:
  shopping_cart: Cart = []

  while True:
    print("Shopping Cart:")
    print("1. Add Item")
    print("2. Remove Item")
    print("3. View Cart")
    print("4. View Cost")
    print("5. Exit")

    match input_int("Choose an option (1/2/3/4/5): ", min=1, max=5):
      case 1: add_item(shopping_cart)
      case 2: remove_item(shopping_cart)
      case 3: view_cart(shopping_cart)
      case 4: view_cost(shopping_cart)
      case 5: break
      case _: pass

    input("Would you like to proceed? (Press enter)")
    print()

  print("Program terminated.")
  exit(0)

# This is a small class or object blueprint for the program.
# It is basically a semantic data container for item names, and cost.
# Way better than using tuples and trying to guess the type of the data.
class Item:
  def __init__(self, name: str, cost: float) -> None:
    self.name: str = name
    self.cost: float = cost

  # Overrides the default string representation of this object when it is inserted to prints.
  def __str__(self) -> str:
    return f'"{self.name}, {self.cost}"'

# This helper function mutates the cart argument and is run if the user presses the first option.
# The function first prompts the user about the item name & cost, and an item is created afterward.
# The item is then appended to the cart and the successfull proccess is printed out.
def add_item(cart: Cart) -> None:
  name: str = input_str("Input item name: ")
  cost: float = input_float("Input item cost: $", min=0)

  item = Item(name, cost)
  cart.append(item)

  print(f'Item ({item}) has been added to the shopping cart.')

# This helper function mutates the cart argument and is run if the user presses the second option.
# The function first prompts what the name of the item to remove in the cart is.
# The if block then looks if there are matching names in the cart using list comprehension.
# If there are no items, the function will print that there are no item named like that in the shopping cart.
# If there is/are items named like that, the shopping cart will get reassigned to have no items with said name.
# The cart reassignment uses [:] to make sure the passed in cart object is mutated, and not just create a new cart.
# The successfull removal process is then printed out by the function.
def remove_item(cart: Cart) -> None:
  name: str = input_str("Input item name: ")

  if name in [item.name for item in cart]:
    cart[:] = [item for item in cart if item.name != name]
    print(f'Items named "{name}" have been removed from the shopping cart.')
  else:
    print(f'No item named "{name}" found in the cart.')

# This helper function does not mutate the cart argument and is run at the third option.
# The function just prints out empty if the cart does not have any elements with the if not cart condition.
# The function will then print the amount if items in the cart and all of the items inside it.
# The *cart means to individually separate the items in the list and sep="\n" means they are separated by enter space.
def view_cart(cart: Cart) -> None:
  if not cart:
    print("Your shopping cart is empty.")
  else:
    print(f"You have {len(cart)} items in your shopping cart.")
    print(*cart, sep="\n")
      
# This helper function does not mutate the cart argument and is run at the fourth option.
# The function just prints out the total cost of all the items inside the cart.
# It calculates the cost through list comprehension to get all item costs in a list and then pass it to the sum function.
# The sum function takes all the elements in a list and gets the sum of all of them as the name suggests.
def view_cost(cart: Cart) -> None:
  print(f"Total item costs: {sum([item.cost for item in cart])}")

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

# A simple utility function that gets the user string input without any validation.
# The strip here simply removes excess whitespace the user might've inputted.
def input_str(prompt: str) -> str:
  return str(input(prompt).strip())

# Guards the file from imports and only runs main only if the interpreter is run here directly.
# These are dunder (double underline) values that are automatically set by Python at runtime.
if __name__ == "__main__":
  main()
