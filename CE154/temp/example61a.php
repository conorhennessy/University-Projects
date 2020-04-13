<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Example 61a</title>
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
echo '<p>To display a 2D array as a table...</p>';

echo '<table><tr><td></td>';
foreach( $coords[0] as $y => $arr)
{
  echo '<th>', $arr,'</th>';
}
echo '</tr>';
foreach( $coords as $x => $inner_array )
{
  echo '<tr><th>', $x,'</th>';
  foreach( $inner_array as $y => $val )
  {
    echo '<td>', $val, '</td>';
  }
  echo '</tr>';
}
echo '</table>';

?>
</body>
</html>
