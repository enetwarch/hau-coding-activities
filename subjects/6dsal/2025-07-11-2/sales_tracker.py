# Hugo P. Molina
# CS-202

# This main() function will act as the main entry point for the program.
# It will initialize an empty sales 2d array, and then prompt inputs for agent and month amount.
# The program will then do some calculations for the necessary data by calling calculator functions.
# Based from the sample output, it will then print the calculated necessary data.
# After all of those steps, the program will then be exitted with code 0.
# NOTE: The enumerate() function being used in some for loops just means it will iterate the element and its index.
def main() -> None:
    sales: list[list[int]] = []    

    agents: int = input_int("Enter number of agents: ", min=1)
    months: int = input_int("Enter number of months: ", min=1)
    print()
    
    for i in range(agents):
        sales.append([])

        print(f"Enter sales for Agent {i + 1}:")
        for j in range(months):
            sales[i].append(input_int(f"  Month {j + 1}: ", min=0))
        print()

    agent_data: list[tuple[int, float]] = calculate_agent_data(sales)
    monthly_data: list[tuple[int, float]] = calculate_montly_data(sales)
    top_performer: tuple[int, int] = calculate_top_performer(agent_data)

    print("Sales Data:")
    for i in range (len(sales)):
        print(sales[i])
    print() 

    print("Agent Totals and Averages:")
    for i, (total, average) in enumerate(agent_data):
        print(f"Agent {i + 1}: Total = {total} | Average = {average:.2f}")
    print()

    print("Monthly Totals and Averages:")
    for i, (total, average) in enumerate(monthly_data):
        print(f"Month {i + 1}: Total = {total} | Average = {average:.2f}")
    print()

    (agent_number, total_sales) = top_performer
    print(f"Top Performer: Agent {agent_number} with {total_sales} total sales")
    print()

    exit(0)

# This function will calculate the total and average sales for each agent.
# This basically calculates the sum of the rows of the 2d array.
# The function will loop through all the rows of the 2d array and calculate the total and average sales.
# It will return a list of tuples containing the total and average sales of all agents.
# It will return an empty list if the sales list is empty.
def calculate_agent_data(sales: list[list[int]]) -> list[tuple[int, float]]:
    agent_data: list[tuple[int, float]] = []
    if not sales: return agent_data

    for months in sales:
        total: int = sum(months)
        average: float = total / len(months)
        
        agent_data.append((total, average))
    
    return agent_data

# This function will calculate the total average sales for each month.
# This basically calculates the sum of the columns of the 2d array.
# It assumes that the inner array in the 2d array all have the same size, which they will in this program.
# The function loops through all the columns of the 2d array and calculate the total and average sales.
# It uses list comprehension which is a one-line for loop that returns a list to only get the columns of the 2d array.
# It will return a list of tuples containing the total and average sales for each month.
# It will return an empty list if the sales list is empty.
def calculate_montly_data(sales: list[list[int]]) -> list[tuple[int, float]]:
    monthly_data: list[tuple[int, float]] = []
    if not sales: return monthly_data

    for j in range(len(sales[0])):
        month: list[int] = [sales[i][j] for i in range(len(sales))]
        total: int = sum(month)
        average: float = total / len(month)

        monthly_data.append((total, average))

    return monthly_data

# This function will calculate the top performer from the agent data.
# It will return a tuple containing the agent number and the total sales of the top performer.
# If the agent data is empty, it will return (0, 0) as the default value.
# The agent number is 1-based, so it will return the index + 1 for the first tuple data.
# The second tuple data will be the total sales which will override the previous total sales if it is greater.
# The instructions just mentioned the top agent, not all the top agents.
def calculate_top_performer(agent_data: list[tuple[int, float]]) -> tuple[int, int]:
    top_performer: tuple[int, int] = (0, 0)  
    if not agent_data: return top_performer

    for i, (total_sales, _) in enumerate(agent_data):
        if total_sales > top_performer[1]:
            top_performer = (i + 1, total_sales)
    
    return top_performer

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

# Guards the file from imports and only runs main only if the interpreter is run here directly.
# These are dunder (double underline) values that are automatically set by Python at runtime.
if __name__ == "__main__":
    main()
