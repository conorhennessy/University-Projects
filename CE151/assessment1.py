"""
ass1.py
CE151 assignment 1
created by sands 30/10/10
modified by sands 28/10/16 - number of exercises changed, example added
modified by ch17811 04 to 15/11/17 - For CE151 ass. 1
"""
from math import sqrt, acos, degrees
import re
from re import search
import string

def ex0():
    """
    example
    use 8 at exercise selection prompt in my code to select it
    """
    print("Exercise 8 - Example exercise find sqrt. of input\n")

    i = int(input("Enter a non-negative integer: "))
    if i<0:
        print("Negative numbers do not have real square roots")
    else:
        root = sqrt(i)
        print("The square root is", round(root, 2))

# Function to get width [w] and length of hyp. [hyp] inputs with error handling
def getTriangleInputs():
    global w
    global hyp
    try:
        w = float(input("Please input in the width of the triangle: "))
        hyp = float(input("Please input the length of the hypotenuse of the triangle: "))
    except:
        print("Incorrect input! Please input width and length as a decimal or integer number!")
        getTriangleInputs()

def ex1() :
    """
    exercise 1 - Triangle calculations
    """
    print("Exercise 1 - Right angle triangle calculator\n")

    getTriangleInputs()   # Call triangle function
    # Check if triangle can exist or not
    if w <= 0 or hyp <= 0:
        print("The hypotenuse or width of a triangle can not be a negative number!\nPlease try again!")
        getTriangleInputs()
    if w >= hyp:
        print("This triangle can not exist as the width is not less than the length!\nPlease input the values again!")
        getTriangleInputs()
    # Calculate the height [h] and two interior angles [a1 & a2] & then output results
    try:
        h = round((sqrt(hyp**2-w**2)),2)
        a1 = round(degrees(acos(w/hyp)),2)
        a2 = round((90 - a1),2)
        print("\nThe height of your triangle is {height}.".format(height=format(h, ".2f")))
        print("The interior angles of the triangle are","{0:.2f}°".format(a1),"and","{0:.2f}°.".format(a2))
    except ValueError:
        print("Unable to calculate a triangle with width of",w,"and hypotenuse of",h,"as either of the lengths are too big!")      
    ##### DONE: The outputs of the angles were on two separate lines, it's just one!  By using the {0:.2f} thingy - 6/11/17

def ex2() :
    """
    exercise 2 - Fibonacci Series
    """
    print("Exercise 2 - Fibonacci Series\n")
    
    try:
        try:
            t = int(input("How many terms of the Fibonacci Series would you like? "))
        except:
            print("Incorrect input! Please input your selection as a whole number!")
            t = int(input("How many terms of the Fibonacci Series would you like? "))
    except:
        print("Incorrect input! Please input your selection as a whole number!")
        t = int(input("How many terms of the Fibonacci Series would you like? "))
    if t < 0:
        print("Your input should be a positive number!")
        try:
            t = int(input("How many terms of the Fibonacci Series would you like? "))
            if t == 0:
                print("\nAs you selected 0, there is nothing of the sequence to show then!")
        except:
            print("Incorrect input! Please input your selection as a whole number!")
            t = int(input("How many terms of the Fibonacci Series would you like? "))
            if t == 0:
                print("\nAs you selected 0, there is nothing of the sequence to show then!")
    elif t == 0:
        print("\nAs you selected 0, there is nothing of the sequence to show then!")    
    else:
        print("\nYour Fibonacci series is as follows...")
        # Where n is the current term and n2 is the previous one
        n = 0
        n2 = 0
        while t > 1:
            print(n, end=" ")
            if n == 0:
                n = n + 1
            else:
                n = n + n2
                n2 = n - n2
                t = t - 1
        print()
    ##### DONE: The output needs to be single numbers separated by spaces not e.g [0, 1, 1, 2] - DONE 4/11/17
    ##### DONE: Only able to work out of the series supplied, unable to return more values if asked! - HALF DONE 6/11/17 DONE 7/11/17
    
def ex3() :
    """
    exercise 3 - Numbers Table
    """
    
    print("Exercise 3  - Numbers Table\n")
    # Get inputs and some error handling
    try:
        try:
            r = int(input("How many rows do you want? "))
            c = int(input("How many columns do you want? "))
        except:
            print("Incorrect input! Your input should be a whole number (EG: 4)!")
            r = int(input("How many rows do you want? "))
            c = int(input("How many columns do you want? "))
    except:
        print("Incorrect input! Your input should be a whole number (EG: 4)!")
        r = int(input("How many rows do you want? "))
        c = int(input("How many columns do you want? "))
    if r <= 0 or c <= 0:
        print("Incorrect input! Your input can not be a negative number or zero!")
        try:
            r = int(input("How many rows do you want? "))
        except:
            print("Incorrect input! Your input should be a whole number (EG: 4)!")
            r = int(input("How many rows do you want? "))
        try:
            c = int(input("How many columns do you want? "))
        except:
            print("Incorrect input! Your input should be a whole number (EG: 4)!")
            c = int(input("How many columns do you want? "))
    if c >= 15:
        print("[!!!] This number of columns is too big for the shell window - make sure you enlarge the window (or the output may look odd)!\n Less than 15 columns looks best!")
        c = int(input("Can you confirm how many columns you want? "))
    print()
    # Find the last number [last] and the length of the last number [lastLen]
    last = r**c
    lastLen = len(str(last))
    spacing = str(lastLen) + "d"
    # [col] & [row] is the current column/row we are on, it is 0 by default to count up to their input [c or r]
    col = 1
    row = 1
    while row <= r:
        while col <= c:
            # Do calculations for each digit to for column
            value = row**col
            col = col + 1
            # print each value in the row individually
            print(format(value,spacing), end=" ")
        print()
        row = row + 1
        col = 1

def ex4() :
    """
    exercise 4 - word output and length checker
    """
    print("Exercise 4 - Sentence splitter and longest/shortest word finder.\n")

    try:
        try:
            sentence = str(input("Please input a sentence  to analyse... "))
        except:
            print("Incorrect input! Your input should be a sentence !")
            sentence = str(input("Please input a sentence to analyse... "))
    except:
        print("Incorrect input! Your input should be a sentence!")
        sentence = str(input("Please input a sentence to analyse... "))
    # To strip all punctuation from the sentence
    punc ='''!?,.(){}[];:\/<>'"@#%&~_=`¬|^*£$'''
    newsentence = ""
    for char in sentence:
        if char not in punc:
            newsentence = newsentence + char
    sentence = newsentence
    while sentence.islower() == False and sentence.isupper() == False:
        #If sentence does not contain any letters at all
        print("Incorrect input! Your input should be a sentence!\n (Your input was empty, just spaces or symbols)")
        sentence = str(input("Please input a sentence to analyse... "))
    if sentence == "":
            print("\nThere are no words forming a sentence in your input!\n(Your input was just spaces or symbols)")
    else:
        print("\nHere are all the individual words from the inputted sentence;")
        words = sentence.split()
        wordNum = 0
        for word in words:
            print(word)
            wordNum = wordNum + 1
        # To check length of words and assign longest word [maxi] and shortest word [mini] to vars.
        mini = word
        maxi = word
        for word in words:
            if len(word) <= len(mini): mini = word
            elif len(word) >= len(maxi): maxi = word
        print("The longest word is: '"+maxi+"'.\nAnd the shortest word is: '"+mini+"'.")
    ##### DONE if input had ' or is stuff, it would throw up this error handling ^ when it shouldn't - FIXED 13/11/17

def ex5() :
    """
    exercise 5 - vowel finder
    """
    print("Exercise 5 - Vowel finder\n")

    try:
        try:
            text = str(input("Please input a sentence to analyse for vowels... "))
        except:
            print("Incorrect input! Your input should be a sentence!")
            text = str(input("Please input a sentence to analyse for vowels... "))
    except:
        print("Incorrect input! Your input should be a sentence!")
        text = str(input("Please input a sentence to analyse for vowels... "))
    # Check if text is empty and get input again
    if text == "":
        print("You didn't input anything! Your input should be some text!")
        text = str(input("Please input a sentence to analyse for vowels... "))
    #First strip out vowels to count
    vowels ='''aeiouAEIOU'''
    newText = ""
    for char in text:
        if char in vowels:
            newText = newText + char
    text = newText.lower()
    # Check occurrences of letters [l] and find most occurring vowel [mostVowel] & how many times it occurs [freq]
    mostVowel = char
    freq = 0
    count = {}
    for l in text:
        count.setdefault(l, 0)
        count[l] = count[l] + 1
        if count[l] > freq:
            freq = count[l]
            mostVowel = l
    # Check if there is more than one vowel with the same number of occurrences!
    if freq > 0:
        output = ""
        vowelNum = 0
        for key,value in count.items():
            if value == freq:
                otherVowel = key
                output = output + otherVowel + " "
                vowelNum = vowelNum + 1
        # Different outputs depending on plurals and number of stuff
        if vowelNum == 1:
            output = otherVowel
            print("\nThe most occurring vowel is "+output+".")
        else: print("\nThe most occurring vowels are: "+output)
        if len(output) == 1: print("Occurring",freq,"time(s).")
        else: print("Occurring",freq,"times each.")
    else: print("There are no vowels in this text!")       
    ###### DONE: if there is more than one vowel with the same number of occurrences they should all be outputted
        
def ex6() :
    """
    exercise 6 - Encrypt and decrypt input
    """
    print("Exercise 6 - ASCII Encryption/decryption\n")

    # Get sentence input [sentence] with error handling
    try:
        sentence = str(input("Please input a sentence to encrypt or decrypt, THE INPUTS MUST BE IN CAPITALS!... "))
    except:
        print("Incorrect input! Your input should be a sentence!")
        sentence = str(input("Please input a sentence to analyse for vowels... "))
    # Check if text is empty and get input again
    if sentence == "":
        print("You didn't input anything! Your input should be some text!")
        sentence = str(input("Please input a sentence to analyse for vowels... "))
    # Check input if it only contains only upper case and spaces
    punc ='''!?,.(){}[];:\/<>'"@#%&~_=`¬|^*£$'''
    sentenceCheck = ""
    for char in sentence:
        if char in punc:
            sentenceCheck = sentenceCheck + char
    if sentence.islower() == True or sentenceCheck != "":
        print("\nNo encryption/decryption is able to be performed!\n[Input contains non upper-case and/or space characters]")
        process = False
    else:
        process = True
        # Get key to use for processing [k]
        try:
            try:
                k = int(input("Please input key to use for encryption/decryption of sentence (Where negative values decrypts)... "))
            except:
                print("Incorrect input! Your input should be a whole positive or negative number!")
                k = int(input("Please input key to use for encryption/decryption of sentence (Where negative values decrypts)... "))
        except:
            print("Incorrect input! Your input should be a whole positive or negative number!")
            k = int(input("Please input key to use for encryption/decryption of sentence (Where negative values decrypts)... "))
        if k == 0:
            print("\nNo encryption or decryption to be performed as key selected was 0...")
            print(sentence)
            process = False
    # Perform encryption/decryption on the input string
    if process == True:
        output = ""
        for char in sentence:
            if char == " ":
                # Don't process spaces, just add to output
                output = output + char
            else:
                charVal = ord(char)
                newCharVal = ((charVal - 65 + k) % 26) + 65
                newChar = chr(newCharVal)
                output = output + newChar
        if k < 0:
            state = "decrypted"
        elif k > 0:
            state = "encrypted"
        elif k == 0:
            print("\nNo encryption or decryption to be performed as key selected was 0...")
            print(sentence)
        print("\nYour",state,"input...")
        print(output)

# Both below for ex7, to get character inputs [char1 & char2] and then the inner width [inW] with error handling
def getCharInput():
    global char1
    global char2
    try:
        char1 = str(input("Please input the first character to use: "))
        char2 = str(input("Please input the second character to use: "))
    except:
        print("Incorrect Input! Your input should be a single keyboard character!")
        char1 = str(input("Please input the first character to use: "))
        char2 = str(input("Please input the second character to use: "))
    if char1 == "" or char2 == "":
        print("One of your inputs was empty! Please try again!")
        getCharInput()
def getInW():
    global inW
    try:
        inW = int(input("What would you like the width of the inner triangle to be? This must be an odd number! "))
    except:
        print("Incorrect Input! Your input should be an integer!")
        inW = int(input("What would you like the width of the inner triangle to be? This must be an odd number! "))

def ex7() :
    """
    exercise 7 - Nested Triangles
    """
    print("Exercise 7 - Nested Triangles\n")
    
    try:
        getCharInput()
        getInW()
    except:
        getCharInput()
        getInW()

    if inW == 0:
        print("Your input can not be 0, as no triangle would be shown!\nPlease try again...")
        getInW()
    elif inW < 0:
        print("Your input can not be negative! Your input should be a positive value!\nPlease try again...")
        getInW()
    elif inW > 19:
        print("The width can not be greater than 19 due to the size of shell window (unless enlarged)!\nPlease try again...")
        getInW()
    elif inW % 2 == 0:
        #Input was even!
        print("The width for the inner triangle can not be an even number! Your input should be odd!\nPlease try again...")
        getInW()

    # Form funky triangles...
    #Find base width
    oneW = inW
    twoW = inW*2 + 1
    threeW = inW*4 + 1
    #Find number of rows
    rows = 0
    temp = inW
    while temp >= 0:
        rows += 1
        temp = temp - 2
    oneR = rows
    twoR = 2*rows
    threeR = 4*rows+1
    row = 0 
    print("\nLevel one triangle...")
    while row != oneR:
        line = char1 * oneW
        print(format(line,'^80s'))
        oneW -= 2
        row += 1
    row = 0
    print("\nLevel two triangle...")
    tempW = 1 #this is for the char2 triangle and will reset to 1 when char1 triangle starts
    newOneR = (2*rows)-1
    inner = False
    while row != twoR:
        if tempW > inW:
            # then the inner triangle needs to start
            tempW = 1
            inner = True
        if inner == True:
            # Do the inner bit and below of triangle
            line = (char2 * tempW) + (char1 * newOneR) + (char2 * tempW)
            newOneR -= 2
            tempW += 2
        else:
            line = char2 * (tempW) # Do the top one
            tempW += 2
        print(format(line,'^80s'))
        row += 1
    row = 0
    print("\nLevel three triangle...")
    # tooooo many variables!!! argh - but it works
    fullW = (4*inW+2) + 1 # this is the full current width, -= 2 with each row
    ininW = 3*inW + 2 # this is the width where iner iner triangle starts
    stopW1 = 2*inW + 3 # this is the width that inner char2 triangle stops
    topW = 2*inW + 1 # this is the start width of the top char1 triangles
    bottomW = 2*inW + 1
    innerW = 1
    innerW2 = 1
    inner = True
    while row != threeR:
        if fullW >= stopW1:
            if fullW > ininW:
                # make top of inner tirangle
                line = (char1 * topW) + (char2 * innerW) + (char1 * topW)
                innerW += 2
            else:
                # make inner inner triangle
                line = (char1 * topW) + (char2 * innerW2) + (char1 * topW) + (char2 * innerW2) + (char1 * topW)
                innerW2 += 2
            topW -= 2            
        elif fullW < stopW1:
            # make bottom char1 triangle
            line = char1 * bottomW
            bottomW -= 2
        print(format(line, '^80s'))
        row += 1
        fullW -= 2 




# To display my name and do the menu
print("CE151 Assignment 1 - Conor Hennessy - ch17811")
exlist = [None, ex1, ex2, ex3, ex4, ex5, ex6, ex7, ex0]
running = True
while running :
    line = input("\nSelect exercise (0 to quit): ")
    if line == "0" : running = False
    elif len(line)==1 and "1"<=line<="8": exlist[int(line)]()
    else : print("Invalid input, your input should be a number 1 to 8 - try again")
