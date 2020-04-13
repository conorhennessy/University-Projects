<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Example 61</title>
</head>
<body>
<?php
# Multi-Dimensional Arrays

$first_line = array( 1, 2, 3, 4 );
$second_line = array( 5, 6, 7, 8 );

$coords[ 0 ] = $first_line;
$coords[ 1 ] = $second_line;

# Display values with a nested loop

echo '<h2>Nested Loop for 2-Dimensional Array</h2>', "\n";
echo '<ul>';

foreach( $coords as $x => $inner_array )
{
  foreach( $inner_array as $y => $val )
  {
    echo '<li>The value of $coords[', $x, ',', $y, '] is:', $val,
    '</li>';
  }
}

echo '</ul>', "\n";

?>
</body>
</html>
