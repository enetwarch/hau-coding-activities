# Hugo P. Molina
# ICT-102

# The shopping cart is initialized along with these types to help with typesafety.
# This type basically just means a list (cart) of string and float tuples (item, cost).
type Item = tuple[str, float]
type Cart = list[Item]
shopping_cart: Cart = []

# This is a functional programming style function that returns a brand new cart.
# It adheres to the paradigm's immutability and side effect reduction.
def add_cart_item(cart: Cart, item: Item) -> Cart:
  # Clones the passed in cart and adds an item to it.
  new_cart: Cart = cart.copy()
  new_cart.append(item)

  # Returns the new cart back.
  return new_cart

# Another function programming style function similar to add_cart_item().
# NOTE: This function removes all items that match the name, so it can remove multiple items with the same name.
def remove_cart_item(cart: Cart, name: str) -> Cart:
  # Uses list comprehension shorthand to only return a list that does not include the name provided.
  return [item for item in cart if item[0] != name]

# A simple functional programming style function.
# It uses the list comprehension shorthand which is basically a one-liner for loop with a return value.
def get_item_list(cart: Cart) -> list[str]:
  return [item[0] for item in cart]

# Yet another function programming style function.
# This function is slightly advanced because it uses list comprehension.
def calculate_total_cost(cart: Cart) -> float:
  # This list comprehension basically makes a float array from all the float values in the Item tuple.
  # The sum function then adds all of those values together which will then be returned.
  return sum(item[1] for item in cart)

# Starts an infinite loop that will act as the interface of the program.
while True:
  # Prints out the options available to the user.
  print("Shopping Cart:")
  print("1. Add Item")
  print("2. Remove Item")
  print("3. View Cart")
  print("4. Total Cost")
  print("5. Exit")

  try:
    # Gets the user input in integer form.
    user_input: int = int(input("Choose an option: "))

    match user_input:
      # Adds an item into the shopping cart.
      case 1:
        # An infinite loop to enable error handling.
        while True:
          try:
            # Prompts the user to provide information about the item to add.
            item_name: str = input("Input item name: ")
            # This could cause an error if the user input is not float parseable.
            item_cost: float = float(input("Input item cost: $"))

            # Breaks out of the infinite loop if no error is thrown.
            break 
          except ValueError:
            # Catches potential errors from parsing user input string into float.
            print("Please enter an appropriate float value for the cost.")

        # Adds the item to the shopping cart and lets the users know
        shopping_cart = add_cart_item(shopping_cart, (item_name, item_cost))
        print(f"Item (\"{item_name}\", ${item_cost:,.2f}) has been added to the shopping cart.")

      # Removes an item in the cart.
      # NOTE: This does not fully cover all edge-cases, but for a school activity, this is enough.
      case 2:
        # Asks the user what the name of the item is to be removed.
        item_name: str = input("Input item name: ")

        # Checks if the item_name has matching item names in the string item tuples in the cart.
        if item_name in get_item_list(shopping_cart):
          # Renews the shopping cart with the removed item.
          shopping_cart = remove_cart_item(shopping_cart, item_name)
          print(f"Item \"{item_name}\" removed from the shopping list.")
        else:
          # No changes to the cart because there was no such item.
          print(f"Cannot find item \"{item_name}\" from the shopping list.")

      # Views the entire cart.
      case 3:
        # Prints the header of this view.
        print("Shopping Cart:")
        
        if not shopping_cart:
          # Prints this out of the shopping cart is currently empty.
          print("Your shopping cart is empty.")
        else:
          # Looks through the entire shopping cart and prints the "item: cost".
          for (item_name, item_cost) in shopping_cart:
            print(f"{item_name}: ${item_cost:,.2f}")

      # Prints the total cost of all the items in the cart.
      case 4:
        # Calls the function responsible for calculating total cost and stores it in a variable.
        total_cost: float = calculate_total_cost(shopping_cart)
        print(f"Total cost: ${total_cost:,.2f}")

      case 5:
        # Breaks out of the interface's infinite loop.
        break

      case _:
        # Handles the case where the user did input an integer but it is not in the match case.
        print("Please input an integer value between 1-5.")
  except ValueError:
    # Handles error in string to int parsing if the user didn't input an int.
    print("Please input an appropriate integer value.")

  # Gives the user ample time to look at the result or prompt before repeating the loop.
  input("Would you like to proceed? (Press enter)")
  # Prints an empty space after every cycle of the loop for visual separation.
  print()

# Terminates and exits the program.
print("Program terminated.")
exit(0)
