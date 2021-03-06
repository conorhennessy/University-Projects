<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Example 64</title>
</head>
<body>
<?php
# Illustration of for loop to access Multi-Dimensional Array

# The same array as in Example 61.
# This code has the same effect as Example 61.

$first_line = array( 1, 2, 3, 4 );
$second_line = array( 5, 6, 7, 8 );

$coords[ 0 ] = $first_line;
$coords[ 1 ] = $second_line;

# Display values with a nested loop

echo '<h2>Nested Loop for 2-Dimensional Array</h2>', "\n";
echo '<ul>';

for ( $x = 0; $x < sizeof( $coords ); $x++ )
{
  for ( $y = 0; $y < sizeof( $coords[ $x ] ); $y++ )
  {
    echo '<li>The value of $coords[', $x, ',', $y, '] is:',
    $coords[ $x ] [ $y ];
    '</li>';
  }
}

echo '</ul>', "\n";
?>
</body>
</html>
