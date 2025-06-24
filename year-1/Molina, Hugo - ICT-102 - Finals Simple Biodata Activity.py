# Hugo P. Molina
# ICT-102

name = "No input"
age = "No input"
gender = "No input"
address = "No input"
# Initializes variables.

class User:
    def display_biodata(name, age, gender, address):
        print("Name: {}".format(name))
        print("Age: {} years old".format(age))
        print("Gender: {}".format(gender))
        print("Address: {}".format(address))
# This object contains the function for displaying the biodata written by the user.

while True:
# Initializes the loop
    print("1. Set Name")
    print("2. Set Age")
    print("3. Set Gender")
    print("4. Set Address")
    print("5. Display Biodata")
    print("6. Exit")
    userOption = int(input("Choose an option (1/2/3/4/5/6): "))
    # Prints the options for the user and prompts them for an input between numbers 1 to 6.

    match userOption:
        case 1:
            while True:
                name = str(input("Please input your name: "))
                if not (name.isalpha()):
                    print("Please input a name that only contains letters.")
                else:
                    break
        # This option asks for the user's name.
        # In order for the input to be valid, the user's name must only contain alphabet letters.

        case 2:
            while True:
                age = int(input("Please input your age (123 max): "))
                if not (age >= 0 and age <= 123):
                    print("Please input a valid number for your age that does not exceed 123 and go into the negatives.")
                else:
                    break
        # This option asks for the user's age
        # In order for the input to be valid, the age must be within 0 to 123 years old, no more, no less.

        case 3:
            while True:
                gender = str(input("Please input your gender (m/f/nb): "))
                match gender:
                    case "m":
                        gender = "Male"
                    case "f":
                        gender = "Female"
                    case "nb":
                        gender = "Non-binary"
                    case _:
                        continue
                break
        # This options asks for the user's gender.
        # In order for the input to be valid, the inputted gender must be either m, n, or nb.

        case 4:
            while True:
                address = str(input("Please input your address: "))
                if len(address) < 10:
                    print("Please make sure that your address has atleast 10 characters.")
                else:
                    break
        # This option will ask for the user's address and will undergo through input validations.
        # In order for the input to be valid, the inputted address of the user must be atleast 10 characters long.

        case 5:
            User.display_biodata(name, age, gender, address)
        # Calls the function within the User object. Prints the currently inputted biodata of the user.

        case 6:
            print("Program terminated.")
            break
        # This option stops the loop and terminates the program entirely.

        case _:
            print("Please input a number between 1 to 6")
        # Will be printed if the number inputted by the user is not within 1 to 6.

    input("Press enter to proceed.")
    # Gives the user ample time to read the recently printed data before repeating the loop.
    print()
    # Adds an empty space after each loop.