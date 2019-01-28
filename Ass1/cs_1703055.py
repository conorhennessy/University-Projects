from sfs import *

def cs_1703055():
    ## Open 'sfs.py' file in cd
    # Done by opening the file for reading, storing lines into a list,
    # close the file and then open the file for writing - ready for next step.
    pyFile = 'sfs.py'
    if ( os.path.isfile( pyFile ) ):
        file = open( pyFile, 'r' )
        line_list = file.readlines()
        file.close()
        file = open( pyFile, 'w' )
    else:
        print( "File " + pyFile + " does not exist." )

    ## Goto line 52 and add '; print ( "virus" )' to the line
    # Done by already reading the file, storing all lines in a list,
    # rewriting the 52nd line, write rest of lines to file and then closing the file.
    count = 0
    for line in line_list:
        count += 1
        if count == 52:
            line = line.rstrip() + '; print ( "virus" )\n'
        # Now save that line back to file overriding it.
        file.write(line)
    file.close()


if __name__ == '__main__':
    cs_1703055()
