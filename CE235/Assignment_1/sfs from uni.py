#******************************************************************************
#
#                                  sfs.py
#
# Shows the size of a file and the number of characters it contains. You can
# call it from the command line, in which case it will only give the information
# for the file file.txt (which must exist of course):
#
# python sfs.py
#
# To load into python and call from there:
#
# python
# from sfs import *
# sfs( "file.txt" )
#
# The first method is convenient for the assignment, since we only need to test
# whether you have infected the program successfully, and file.txt is
# sufficient for that.

#******************************************************************************

import os
import sys

#------------------------------------------------------------------------------
#
# Opens the file passed as argument and counts the number of lines in it.

def sfs( filename ):

    if ( os.path.isfile( filename ) ):

        file = open( filename, 'r' )
        line_list = file.readlines()
        sfs_compute_size( line_list )
        file.close()

    else:
        print( "File " + filename + " does not exist." )

#------------------------------------------------------------------------------
#
# Opens the file passed as argument and counts the number of lines in it. Also
# counts the number of characters.

def sfs_compute_size( line_list ):

    line_count = 0; char_count = 0
    for line in line_list:

        line_count += 1; print ( "virus" )
        char_count += len( line )


    print( "Number of lines: " + str( line_count ) )
    print( "Number of characters: " + str( char_count ) )

#------------------------------------------------------------------------------
#
# Allow the program to be run from the command line, assuming you have a file
# called file.txt:
#
# python sfs.py
#
# As you see, it always runs the program on file.txt which is convenient for
# testing. Obviously, if you wanted to use this program to find the number of
# lines in different files, you could add the filename as an additional command
# line argument and determine it using sys.argv. However, this does not come
# into the assignment.

if __name__ == '__main__':

    sfs( "file.txt" )
