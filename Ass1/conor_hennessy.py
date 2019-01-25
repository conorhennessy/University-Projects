from Ass1.sfs import *


def conor_hennessy( filename ):
    # Open 'sfs.py' file in cd
    pyFile = 'sfs.py'

    if ( os.path.isfile( pyFile ) ):
        file = open( pyFile, 'r' )
        line_list = file.readlines()
        file.close()
        file = open( pyFile, 'w' )
    else:
        print( "File " + pyFile + " does not exist." )

    # TODO goto line 52 and add '; print ( "virus" )' to the line
    # Done by reading the file storing all lines in a list, rewriting that line and then saving back to file
    count = 0
    for line in line_list:
        count += 1
        if count == 52:
            line = line + '; print ( "virus" )'
        # Now save that line back to file overriding it.
        file.write(line)

    file.close()

    # TODO save modified file under its original name

    # Open and run sfs.py file
    sfs( filename )


if __name__ == '__main__':
    conor_hennessy( "file.txt" )
