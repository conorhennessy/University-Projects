<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Example 65</title>
</head>
<body>
<?php
# Illustration of while loop to access Multi-Dimensional Array

# The same array as in Example 61.
# This code has the same effect as Example 61.

$first_line = array( 1, 2, 3, 4 );
$second_line = array( 5, 6, 7, 8 );

$coords[ 0 ] = $first_line;
$coords[ 1 ] = $second_line;

# Display values with a nested loop

echo '<h2>Nested Loop for 2-Dimensional Array</h2>', "\n";
echo '<ul>';

$x = 0; # Must create variable first
while ( $x < sizeof( $coords ) )
{
  $y = 0; # Must create before loop
  while ( $y < sizeof( $coords[ $x ] ) )
  {
    echo '<li>The value of $coords[', $x, ',', $y, '] is:',
    $coords[ $x ] [ $y ];
    '</li>';
    $y++;
  }
  $x++;
}

echo '</ul>', "\n";
?>
</body>
</html>
