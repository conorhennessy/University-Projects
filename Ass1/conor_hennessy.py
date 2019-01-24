from sfs import *

def conor_hennessy( filename ):
    # Open 'sfs.py' file in cd
    pyFile = 'sfs.py'

    if ( os.path.isfile( pyFile ) ):

        file = open( pyFile, 'r' )
        line_list = file.readlines()
        sfs_compute_size( line_list )
        file.close()

    else:
        print( "File " + filename + " does not exist." )

    # TODO goto line 52 and add '; print ( "virus" )' to the line


    # TODO save modified file under its original name

    # Open and run sfs.py file
    sys( filename )



if __name__ == '__main__':
    conor_hennessy( "file.txt" )
