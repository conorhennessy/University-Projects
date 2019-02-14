# ******************************************************************************
#
#                            est_extract_secret_text.py
#                            Renamed to: cs_1703055.py - to reflect my reg number
#
# Extracts a secret text from within an image file.
#
# ------------------------------------------------------------------------------
#
# First, open an image file and get the bytes of the image. Second, given the
# values of p and q, extract the hidden bits of the text message from the
# image. Third, put the bits together into the bytes of the hidden
# text. Fourth, write out the hidden text to a file.


def est_extract():
    image_byte_array = est_get_bytes_containing_message()

    # header_len is always fixed at 54
    header_len = 54

    # Set the values of p and q for the extraction. We do not yet know what
    # values to use
    p = 1
    q = 1

    # ********************************************************
    # ADD CODE HERE WHICH FINDS THE CORRECT VALUES OF p and q.

    def est_bit_proportion(bit_array):
        # Compute the proportion of ones in array
        count = 0
        for bit in bit_array:
            if bit == 1:
                count += 1

        return count / len(bit_array)

    for a in range(1, 4):
        for b in range(1, 4):
            message_bit_array = est_extract_bits_from_image(
                image_byte_array, header_len, a, b)

            bit_proportion = est_bit_proportion(message_bit_array)

            print("p=" + str(a) + " q=" + str(b) + " bp=" + "%.3f" % bit_proportion)

            # If found proportion is < 0.5 we want to use the found values as P and Q
            if bit_proportion < 0.5:
                p = a
                q = b

    print("The answer is: p=" + str(p) + "\nq=" + str(q))

    # ********************************************************

    message_bit_array = est_extract_bits_from_image(
        image_byte_array, header_len, p, q)

    message_byte_array = est_convert_bits_to_bytes(message_bit_array)

    est_write_message_text(message_byte_array)


# ------------------------------------------------------------------------------
#
# Open a bmp file which is an image in which is hidden a secret text. Return a
# byte array containing the bytes of the image.

def est_get_bytes_containing_message():
    # Open file as bytes not characters
    file = open("flower_with_text.bmp", "rb")

    # Create a byte array of the file. Each element of the array corresponds to
    # one byte and is is a number 0-255.
    data = bytearray(file.read())
    file.close()

    return data


# ------------------------------------------------------------------------------
#
# The three arguments are data, a byte array containing the bytes of the image,
# header_len which is the size of the header in the image file, and the secret
# values p and q which are integers and which determine the
# encryption/decryption of the message within the image file.

def est_extract_bits_from_image(data, header_len, p, q):
    # Create a byte array in which to place the bits of the hidden text. Later
    # we will convert these to bytes. The argument to byte array is simply the
    # required size which we are computing from the length of the image file,
    # header_len (always 54) and the values of p and q (which we have to
    # determine. 
    text_as_bits = bytearray((len(data) - header_len - p) // q)

    # Copy the bits of the text into text_as_bits. Remember, we start at
    # position header_len + p in data, according to the encryption
    # algorithm. We then step forward q bytes at a time.
    #
    # How do we extract the bits of the message? This is the clever part. We
    # need the least significant (rightmost) bit from each byte of the image
    # which is stored in data. If we take a data byte and AND it with 00000001
    # the result will be 1, if the least significant bit in the byte is 1, and
    # 0, otherwise. In other words, we have extracted the least significant bit
    # by this means. 

    for i in range(0, len(text_as_bits)):
        text_as_bits[i] = data[header_len + p + i * q] & 0b00000001

    return text_as_bits


# ------------------------------------------------------------------------------
#
# Argument text_as_bits is a byte array containing the bits of the message. We
# convert these to the equivalent bytes and then return a byte array containing
# them .

def est_convert_bits_to_bytes(text_as_bits):
    # Create a byte array for the output text. The length of it is eight times
    # less than the length of text_as_bits, because one byte equals eight bits.

    text = bytearray(len(text_as_bits) // 8)

    # Extract the bits from text_as_bits, assemble as bytes and place the bytes
    # in text.
    #
    # The inner loop is dealing with one bit at a time. We extract the bit from
    # text_as_bits, then move it into the required position in a byte using bit
    # shift (<<). When we OR this with the existing output byte, we know that
    # the bit in this position in the existing output byte is zero. Therefore
    # it becomes 1 if the value we obtained from text_as_bits was 1 and 0
    # otherwise. So, the first value from text_as_bits is the least significant
    # bit; j is zero so it does not move anywhere. Suppose it was 1, then the
    # results 0b000001. We set that bit in the current byte in text. Now,
    # suppose the next number in text_as_bits is 1; this is the next column in
    # the binary number. j is now 1, so we move this one place to the left,
    # resulting in 0b00000010. We OR that with the text byte (which is
    # currently 0b00000001 from the previous step). The result is
    # 0b00000011. In this way we gradually populate the byte in text with its 
    # individual bits (taken from the image file). We then move on to the next
    # byte and so on.

    for i in range(0, len(text)):
        text[i] = 0
        for j in range(0, 8):
            text[i] = text[i] | (text_as_bits[i * 8 + j] << j)

    return text


# ------------------------------------------------------------------------------
#
# Argument text is a byte array containing the output text. Writes this to a
# file.

def est_write_message_text(text):
    # Now we have all the bytes of the hidden text in text. The final step is
    # to write them to the output file. Note that we open the output file as a
    # binary file.

    file = open("hidden_text_we_found.txt", "wb")
    file.write(text)
    file.close()


# ------------------------------------------------------------------------------
#
# Allow the program to be run from the command line:
#
# python est_extract_secret_text

if __name__ == '__main__':
    est_extract()
