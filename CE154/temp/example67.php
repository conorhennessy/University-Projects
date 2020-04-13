<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Example 67</title>
</head>
<body>
<?php
# Illustration of function call within a loop

# Use a test to make odd columns bold, even columns italics
# (assuming first column is numbered one)

$first_line = array( 1, 2, 3, 4 );
$second_line = array( 5, 6, 7, 8 );

$coords[ 0 ] = $first_line;
$coords[ 1 ] = $second_line;

# Display values with a nested loop

#----------------------------------------------------------------------
#
# This function takes as arguments two integer variables which are the
# x and y indices of the element to be displayed. The third argument is
# a two-dimensional array. Based on the value of $y_index we print out
# the value of the array element as either <strong> (bold) or <em>
# (italics).

function display( $x_index, $y_index, $array )

{
  if ( ( $y_index + 1 ) % 2 == 1 )
  {
    echo '<strong>';
    echo $array[ $x_index ] [ $y_index ], ' ';
    echo '</strong>';
  }
  else
  {
    echo '<em>';
    echo $array[ $x_index ] [ $y_index ], ' ';
    echo '</em>';
  }
}

#----------------------------------------------------------------------
#                      Display Contents of Array
#----------------------------------------------------------------------

echo '<h2>Nested Loop for 2-Dimensional Array</h2>', "\n";

for ( $x = 0; $x < sizeof( $coords ); $x++ )
{
  for ( $y = 0; $y < sizeof( $coords[ $x ] ); $y++ )
  {
    display( $x, $y, $coords );
    # Call function to apply <strong> or <em> tags
  }
  echo '<br/>', "\n";
}

?>
</body>
</html>
