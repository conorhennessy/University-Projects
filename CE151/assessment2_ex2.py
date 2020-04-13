"""
ass2_ex1.py
for Assignment 2 - Exercise 2
created by ch17811 15/12/17
Please see to comments throughout!
"""
#Get grid file name from user
while True:
    try:
        grid = open(input("Input name of word search grid file to open: "), "r")
        print("\nWord search grid...")
        #Input success so break out of loop
        break
    #Error handling
    except IOError:
        print("This file does not exist or can not be opened! Please check your input!")
    except:
        print("Problem opening file!")
#Read grid file supplied and store lines in a list of strings
linesF = grid.readlines()
store = []
for line in linesF:
    #remove newline char
    line = line[:-1]
    store.append(line)
    print(line)
grid.close()

#Get 
while True:
    try:
        wordsToFind = open(input("\nInput name of file with words to find to open: "), "r")
        #Question full so break out of loop
        break
    # Error handling
    except IOError:
        print("This file does not exist or can not be opened! Please check your input!")
    except:
        print("Problem opening file!")

wordsF = wordsToFind.readlines()
searchWords = []
for word in wordsF:
    #remove newline char
    word = word[:-1]
    searchWords.append(word)
searchWords.sort()
wordsToFind.close()
#remove empty strings from searchWords, otherwise it would search for them
searchWords=list(filter(None, searchWords))

def wordSearch(word,gridStore):
    """
    An word searching for a grid function.
    Takes the word being searched for and the grid store.
    Then looks for word patterns in the strings of the grid
    Returning either a tuple of 'direction, row and col positions'

    arguments: word : str
               gridStore: list (of strings)
    returns: Tuple or boolean 'None', depending on word found status
    """
    ##Search horizontally
    lineNum = 1
    for line in gridStore:
        #For left to right
        if word in line:
            #return info about word as a tuple 
            return ("Left to right", lineNum, line.index(word)+1)
        #For right to left, reverse line string then check
        line = line[::-1]
        if word in line:
            return ("Right to left", lineNum, len(line)-line.index(word))
        lineNum+=1
        
    ##Search vertically
    # Creation of a vertical line store from gridStore input
    col = 0
    widthOfGrid = len(line)
    vertLineStore = []
    while col != widthOfGrid:
        vertLine = ""
        for line in store:
            vertLine+=line[col]
        vertLineStore.append(vertLine)
        col+=1
    #Start searching
    colNum = 1
    for line in vertLineStore:
        #For downwards
        if word in line:
            return ("Downward", colNum, line.index(word)+1)
        #For upwards, reverse vertLine then search
        line = line[::-1]
        if word in line:
            return ("Upward", len(line)-line.index(word), colNum)
        colNum+=1
    # Word not found in grid so return None
    return None

#Run function and add store words found and not found respectively
wordsFound= {}
wordsNotFound = []
print("\nWords found, in alphabetical order...")
for word in searchWords:
    #Call function & check returned state
    #if None word not found
    if wordSearch(word,store) == None:
        # Word not found, add to list
        wordsNotFound.append(word)
    else:
        # Word was found, add to dict
        wordsFound[word]=wordSearch(word,store)

#Output all words found and info about it from dict
for word in wordsFound:
    print(word,"found -",wordsFound[word][0],"at row",wordsFound[word][1],"col",wordsFound[word][2])
#Print out words not found, if any
if len(wordsNotFound)!=0:
    print(', '.join(wordsNotFound)+": were not found in grid!")
else:
    print("All words from",wordsToFind,"file were found!")
