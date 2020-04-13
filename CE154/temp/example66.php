<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Example 66</title>
</head>
<body>
<?php
# Illustration of if-then-else within for loop

# Use a test to make odd columns bold, even columns italics
# (assuming first column is numbered one)

$first_line = array( 1, 2, 3, 4 );
$second_line = array( 5, 6, 7, 8 );

$coords[ 0 ] = $first_line;
$coords[ 1 ] = $second_line;

# Display values with a nested loop

echo '<h2>Nested Loop for 2-Dimensional Array</h2>', "\n";

for ( $x = 0; $x < sizeof( $coords ); $x++ )
{
  for ( $y = 0; $y < sizeof( $coords[ $x ] ); $y++ )
  {
    if ( ( $y + 1 ) % 2 == 1 )
    {
      echo '<strong>';
      echo $coords[ $x ] [ $y ], ' ';
      echo '</strong>';
    }
    else
    {
      echo '<em>';
      echo $coords[ $x ] [ $y ], ' ';
      echo '</em>';
    }
  }
  echo '<br/>', "\n";
}

?>
</body>
</html>
