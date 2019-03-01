#******************************************************************************
#
#                            dec_decrypt_aes_part.py
#
# Deccrypt a string using a method based on AES
# 
# Completed by ch17811 - Reg number 1703055

import sys
# needed for sys.argv

#------------------------------------------------------------------------------
#
# The text to decode and key to use

text = \
[132, 201, 141, 74, 140, 94, 141, 140, 141, 15, 31, 164, 90, 229, 201, 141, 78,
114, 241, 217, 141, 217, 140, 180, 141, 164, 51, 141, 188, 221, 31, 164, 241,
177, 141, 140, 51, 217, 141, 201, 229, 152, 141, 78, 241, 114, 78, 102, 94,
141, 74, 152, 31, 152, 141, 94, 201, 31, 164, 102, 164, 51, 90, 141, 201, 229,
164, 31, 201, 152, 152, 51, 115]

key = 84

#------------------------------------------------------------------------------
#
# Decrypt the list of integers passed as argument using the integer key passed
# as second argument and return the decrypted form. The first arg is a list of
# integers, one for each byte, e.g. [ 132, 201 ... ]. The second arg is an
# integer <=255 (i.e. it corresponds to a byte) The output returned is a string.

def dec_decrypt( int_list, int_key ):

    crypt_bytes = bytearray( int_list )
    crypt_bytes_as_nibbles = dec_convert_bytes_to_nibbles( crypt_bytes )
    # List of bytearrays, each holding four bytes, one for each nibble 

    key_as_nibbles = dec_byte_to_nibbles( int_key )
    # one bytearray, holding four bytes, one for each nibble of the key

    decrypt_bytes_as_nibbles = []
    for nibbles in crypt_bytes_as_nibbles:
        decrypt_bytes_as_nibbles +=  \
        [ dec_decrypt_byte_as_nibbles( nibbles, key_as_nibbles ) ]

    decrypt_bytes = \
    dec_convert_nibbles_to_bytes( decrypt_bytes_as_nibbles )
    # Integers in fact

    decrypt_string = dec_convert_bytes_to_string( decrypt_bytes )
    return decrypt_string

#------------------------------------------------------------------------------
#
# Input is a bytearray. Output is a list of quadruples. Each quadruple is a
# bytearray of four elements, one for each nibble.

def dec_convert_bytes_to_nibbles( a_bytearray ):

    quadruple_list = []    
    for a_byte in a_bytearray:

        quadruple = dec_byte_to_nibbles( a_byte )
        quadruple_list += [ quadruple ]

    return quadruple_list

#------------------------------------------------------------------------------
#
# Input is a byte. Output is a bytearray of four bytes, each containing one
# nibble.

def dec_byte_to_nibbles( a_byte ):

    nibble4 = a_byte & 0b00000011
    nibble3 = ( a_byte >> 2 ) & 0b00000011
    nibble2 = ( a_byte >> 4 ) & 0b00000011
    nibble1 = ( a_byte >> 6 ) & 0b00000011

    return( bytearray( [ nibble1, nibble2, nibble3, nibble4 ] ) )

#------------------------------------------------------------------------------
#
# Input is a list of bytearrays, each with four nibbles. Output is a list of
# bytes.

def dec_convert_nibbles_to_bytes( bytes_as_nibbles ):

    byte_list = []
    for nibble_quad in bytes_as_nibbles:

        byte_list += [ dec_convert_nibbles_to_byte( nibble_quad ) ] 

    return byte_list

#------------------------------------------------------------------------------
#
# Input is a bytearray of length four containing the four nibbles. Output is
# these nibbles combined into one byte.

def dec_convert_nibbles_to_byte( quadruple_bytearray ):

    a_byte = \
    ( quadruple_bytearray[ 0 ] << 6 ) | \
    ( quadruple_bytearray[ 1 ] << 4 ) | \
    ( quadruple_bytearray[ 2 ] << 2 ) | \
    ( quadruple_bytearray[ 3 ] )

    return a_byte

#------------------------------------------------------------------------------
#
# First argument nibble_quadruple is a bytearray containing four nibbles. This
# corresponds to a byte in the original encrypted text. Second arg
# key_quadruple is the key, also converted to nibbles in a bytearray. This
# function carries out the decryption process and returns the answer as a
# quadruple bytearray. In other words, the bytearray returned is the decrypted
# form of the input nibble_quadruple, done using the key key_quadruple.
# 
# To write this, you need to follow the instructions in the assignment
# specification. You will need to start off by writing dec_xor,
# dec_swap_last_two, dec_s_box, dec_subtract_last_two_first_two. Using the
# command-line interface you can conveniently test these other functions. Then
# you must use them all to define this function.

def dec_decrypt_byte_as_nibbles( nibble_quadruple, key_quadruple ):

    ## Function completed by 1703055

    # Bitwise XOR of the block and the key 
    xorBytearray = dec_xor( nibble_quadruple, key_quadruple )
    # Swap the last two nibbles of the block
    swappedBytearray = dec_swap_last_two( xorBytearray )
    # Use the S-box substitution on each nibble of the block
    sboxBytearray = dec_s_box( swappedBytearray )
    # Bitwise XOR of the block and the key 
    xorBytearray = dec_xor( sboxBytearray, key_quadruple )
    # Subtract the last two nibbles from the first two
    subtractedBytearray = dec_subtract_last_two_first_two( xorBytearray )
    # Swap the last two nibbles of the block
    secondSwappedBytearray = dec_swap_last_two( subtractedBytearray )
    # Use the S-box substitution on each nibble of the block
    secondSboxBytearray = dec_s_box( secondSwappedBytearray )
    # Bitwise XOR of the block and the key 
    secondXorBytearray = dec_xor( secondSboxBytearray, key_quadruple )
    
    return( bytearray( secondXorBytearray ) )


#------------------------------------------------------------------------------
#
# Both arguments are bytearrays of four elements. XORs them and returns the
# result in a new bytearray called ans.

def dec_xor( nibbles, key ):

    ## Function completed by 1703055
    
    i = 0
    xorAns = []
    while i != 4:
        xorAns.append( nibbles[i] ^ key[i] )
        i += 1

    ans = bytearray( xorAns )

    return ans

#------------------------------------------------------------------------------
#
# Both arguments are bytearrays of four elements. Swaps last two nibbles and
# returns the result in the new bytearray called ans.

def dec_swap_last_two( nibbles ):

    ## Function completed by 1703055
    
    nibbles[2], nibbles[3] = nibbles[3], nibbles[2]

    ans = bytearray( nibbles )

    return ans

#------------------------------------------------------------------------------
#
# Implements the s box transformation. The input is a bytearray of four
# elements, one for each nibble. We return the answer as a new bytearray
# called ans. 

def dec_s_box( nibbles ):

    ## Function completed by 1703055
    
    ans = bytearray()
    
    for nibble in nibbles:
        if nibble == 0:
            ans.append(2)
        if nibble == 1:
            ans.append(0)
        if nibble == 2:
            ans.append(3)
        if nibble == 3:
            ans.append(1)

    return ans

#------------------------------------------------------------------------------
#
# Subtracts the last two from the first two. Leaves the third and fourth
# (i.e. the last two) the same. Returns the answer in a new bytearray called
# ans. Uses modulo 4 (% 4). In the event of a negative result, % makes it
# positive again. e.g. (3-2)%4=1 (2-3)%4 = +3 . % is a standard python operator.
#
# Explanation of modulo operations on negative numbers:
# http://stackoverflow.com/questions/3883004/negative-numbers-modulo-in-python

def dec_subtract_last_two_first_two( nibbles ):

    ## Function completed by 1703055
    
    ans = nibbles

    ans[0] = (nibbles[0] - nibbles[2])%4
    ans[1] = (nibbles[1] - nibbles[3])%4

    return ans

#------------------------------------------------------------------------------
#
# Input is a list of bytes (integers in fact). Converts them to a string and
# returns.

def dec_convert_bytes_to_string( byte_list ):

   ans = ''
   for a_byte in byte_list:

       ans += chr( a_byte )

   return ans

#------------------------------------------------------------------------------
#
# Allow the program to be run from the command line:
#
# python dec_decrypt_aes

if __name__ == '__main__':

    if len( sys.argv ) < 2:

        print( "Must have another command-line argument" )

    elif sys.argv[ 1 ] == 'a':

        print( "dec_decrypt:" )
        print( dec_decrypt( text, key ) )

    elif sys.argv[ 1 ] == 'b':

        ans = \
        dec_xor( dec_byte_to_nibbles( 0b10101010 ),\
                 dec_byte_to_nibbles( 0b10001000 ) )
        ans2 = dec_convert_nibbles_to_byte( ans )
        print( "dec_xor \n10101010 with \n10001000:\n" )
        print( format( ans2, '08b' ) )

    elif sys.argv[ 1 ] == 'c':

        ans = \
        dec_swap_last_two( dec_byte_to_nibbles( 0b10001000 ) )
        ans2 = dec_convert_nibbles_to_byte( ans )
        print( "dec_swap_last_two of \n10001000:\n" )
        print( format( ans2, '08b' ) )

    elif sys.argv[ 1 ] == 'd':

        ans = \
        dec_s_box( dec_byte_to_nibbles( 0b00011011 ) )
        ans2 = dec_convert_nibbles_to_byte( ans )
        print( "dec_s_box of \n00011011:\n" )
        print( format( ans2, '08b' ) )

    elif sys.argv[ 1 ] == 'e':

        ans = \
        dec_subtract_last_two_first_two( dec_byte_to_nibbles( 0b00011011 ) )
        ans2 = dec_convert_nibbles_to_byte( ans )
        print( "dec_subtract_last_two_first_two of \n00011011:\n" )
        print( format( ans2, '08b' ) )

    else:
        print( 'Bad argument' )
