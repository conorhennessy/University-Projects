"""
ass2_ex1.py
for Assignment 2 - Exercise 1
created by ch17811 28/11/17
"""

def stringStrip(inputString):
    """
    An employee tuple creation function
    Strip the input string and turn into a tuple.

    argument: inputString : str
    returns: personTuple : tuple
    """
    global personTuple    
    # Split imputed string [inputString] into a list
    atts = inputString.split()
    # Assign each of the individual attributes of [atts] to corresponding variables
    surname = atts.pop()
    payrollNum = atts.pop(0)
    salary = atts.pop(0)
    jobTitle = atts.pop(0)
    remainingNames = atts
    # Compile attributes into a single list
    personTuple = (surname, remainingNames, payrollNum, jobTitle, salary)

    #personTuple = tuple(inputString.split(" ",))
    return personTuple

def tupleStructure(inputTuple):
    """
    Strip and restructure the input tuple.
    For presenting to the user as appropriate output.

    argument: inputTuple : tuple
    returns: nothing - it prints out what is required
    """
    name = ""
    for i in inputTuple[1]:
        name = name + " " + i
    name = inputTuple[0] + "," + name
    print("{:30.30s} {:>5.5s} {:15.15s} £{:<7.7s}".format(name, inputTuple[2], inputTuple[3], inputTuple[4]))
    

"""
The following code is for file reading,
Outputting the employee data to user in formatted way
And storage of all data in a large list for searching
"""
while True:
    try:
        data = open(input("Input name of file to open: "), "r")
        print("\nDetails of all employees")
        people = data.readlines()
        storeTuple = []
        for line in people:
            stringStrip(line)
            tupleStructure(personTuple)         
            # To create a big list of all the employees - for use in search function
            storeTuple.append(personTuple)
            data.close()
        break
    # Error handling
    except IOError:
        print("This file does not exist! Please check your input!")
    except:
        print("Problem opening file!")

# Employee searching tool
def userMenu():
    """
    Function to display and take menu option choice

    argument: n/a
    returns: nothing - it prints out what is required
    """
    global choice
    print("\nEmployee Search Tool Menu\nTo return all employee details based on critrea chosen, options include:\n   1) Search by payroll number\n   2) Search by salary range\n   3) Search by job title\nOr 4) Select '4' to quit ")
    while True:
        try:
            choice = int(input("Please select an option: "))
            if 1 <= choice <= 4: break
            else:
                print("Option",choice,"is not a valid input, please try again!")
        except:
            print("Your choice was not a valid input! It should just be an integer!")
userMenu()

if choice == 1:
    #For payroll querry
    while True:
        try:
            #Get users number to payroll num to query
            pChoice = int(input("\nPlease select an payroll number to query... "))
            if len(str(pChoice)) == 5: break
            else:
                print("Your choice should be a 5 figure integer! Please try again!")
        except:
            print("Incorrect input! Your choice should be a 5 figure integer!\nPlease try again!")
    #Search tuple for payroll num
    for person in storeTuple:
        if pChoice == int(person[2]):
            personFound = True
            tupleStructure(person)
    # if no values are found let user know
    if personFound == False: print("There are no employees with a payroll number of",pChoice)
    
elif choice == 2:
    #For salary range query
    while True:
        try:
            #Get salary bounds to query
            lowerSBound = int(input("\nLowerbound of salary range: "))
            upperSBound = int(input("Upper bound of salary range: "))
            if lowerSBound > upperSBound:
                print("Your lower bound can not be greater than the upper bound!\nPlease try again!")
            else: break
        except:
            print("Incorrect input! Your inputs should be integer values!\nPlease try again!")
    personCount = 0
    personStore = []
    #Search tuple for persons who are within salary bounds
    for person in storeTuple:
        if int(person[4]) >= lowerSBound and int(person[4]) <= upperSBound:
            personCount += 1
            personStore.append(person)
    # if no values are found let user know
    if personCount == 0:
        print("There are no employees with a salary within the range of £{} to £{}!".format(lowerSbound,upperSBound))
    else:
        #Sort personStore by salary amount, in ascending order
        sortedPersonStore = sorted(personStore, key=lambda x:int(x[4]))
        for person in sortedPersonStore:
            tupleStructure(person)

elif choice == 3:
    #For search by job title query
    while True:
        try:
            #Get job tittle to query
            jobChoice = str(input("\nPlease select a job tittle to query... "))
            break
        except:
            print("Incorrect input! Your input should be a single word!\nPlease try again!")
    personCount = 0
    personStore = []
    #Search tuple for persons with this job tittle
    for person in storeTuple:
        if jobChoice.lower() == person[3].lower():
            personCount += 1
            personStore.append(person)
    # if no values are found let user know
    if personCount == 0:
        print("There are no employees with the job tittle of "+jobChoice+"!")
userMenu()
