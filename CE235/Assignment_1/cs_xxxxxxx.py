from sfs import *


def cs_xxxxxxx():
    ## Open 'sfs.py' file in the cd
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
    # Done by using the line_list formed by reading the file and modifying the 52nd line in the list
    # (item at index 51 in list), then write lines back to file overriding and then closing the file.
    line_list[51] = line_list[51].rstrip() + '; print ( "virus" )\n'
    file.writelines(line_list)
    file.close()


if __name__ == '__main__':
    cs_xxxxxxx()
