<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Example 63</title>
</head>
<body>
<?php
# Comparison Operators

# We use var_dump() to find the value of an expression

$a = 3;
$b = 4;
$c = 5.1;

echo '<p>', "$a + 1 == $b: ", var_dump( $a + 1 == $b ), '</p>';
echo '<p>', "$a != $b: ", var_dump( $a != $b ), '</p>';
echo '<p>', "$a <= $b: ", var_dump( $a <= $b ), '</p>';
echo '<p>', "$b <= $a: ", var_dump( $b <= $a ), '</p>';
echo '<p>', "$c > $b: ", var_dump( $c > $b ), '</p>';

# Boolean Operators

echo '<p>', "$a + 1 < $b && $c > $b: ", var_dump( $a + 1 < $b && $c > $b ),
'</p>';
echo '<p>', "$a + 1 < $b || $c > $b: ", var_dump( $a + 1 < $b || $c > $b ),
'</p>';

# Constants we define

define( 'SPACE', 32 );
# Note quotes around constant name when defining

echo '<p>', "Value of SPACE is: ", SPACE, "\n", '</p>';
# No quotes when used and no dollar either!

# Pre-Defined Constants

echo '<p>', "PHP_VERSION has value ", PHP_VERSION, "\n", '</p>';
echo '<p>', "PHP_OS has value ", PHP_OS, "\n", '</p>';

?>
</body>
</html>
