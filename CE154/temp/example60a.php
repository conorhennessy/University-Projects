<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Example 60a</title>
</head>
<body>
<?php
# Looping through Arrays

$languages[ 0 ] = 'Java';
$languages[ 1 ] = 'Python';
$languages[ 2 ] = 'C++';

echo '<h2>Looping through Array Indexed by Numbers</h2>', "\n";
echo '<ul>';

foreach( $languages as $l )
{
  echo '<li>', $l, '</li>';
}

echo '</ul>', "\n";

# Looping through array with element names is similar

echo '<h2>Including Indices</h2>', "\n";
echo '<ul>';

foreach( $languages as $x => $l )
{
  echo '<li>', $x, ' ', $l, '</li>';
}

echo '</ul>', "\n";

# Looping through array showing values and name indices is similar

#months array
$months[ 1 ] = 'jan';
$months[ 2 ] = 'feb';
$months[ 3 ] = 'mar';
$months[ 4 ] = 'apr';
$months[ 5 ] = 'may';
$months[ 6 ] = 'jun';
$months[ 7 ] = 'jul';
$months[ 8 ] = 'aug';
$months[ 9 ] = 'sep';
$months[ 10 ] = 'oct';
$months[ 11 ] = 'nov';
$months[ 12 ] = 'dec';

foreach( $months as $x => $m)
{
	echo '<li>', 'Month ', $x,' is ', $m, '</li>';
}


?>
</body>
</html>
