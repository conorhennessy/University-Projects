<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Example 62</title>
</head>
<body>
<?php
# Arithmetic

$a = 3;
$b = 4;
$c = 5.1;

# Addition
echo '<p>', $a, " ", $b, " ", $a + $b, " ", $a - $b, '</p>', "\n";

# Multiplication, division, Remainder after integer division
echo '<p>', $a * $b, " ", $a / $b, " ", $a % $b, '</p>', "\n";

# Using brackets to indicate order of operation
echo '<p>', ( ( $a - $b ) * ( $a + $b ) ) / $c, '</p>', "\n";

# Rounding numbers

echo '<p>', round( 4.4 ), " ", round( 4.5 ), " ", floor( 4.4 ), " ",
floor( 4.5 ), '</p>', "\n";

# Check up on the type of the result, integer or double??

# Try var_dump first:
echo '<p>Type of round( 4.4 ) is ', var_dump( round( 4.4 ) ), '</p>', "\n";

# Now try gettype:
echo '<p>Type of round( 4.4 ) is ', gettype( round( 4.4 ) ), '</p>', "\n";

# Well the answers are different, but we assume they are equivalent!!
?>
</body>
</html>
