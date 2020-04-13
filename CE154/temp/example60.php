<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Example 60</title>
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


?>
</body>
</html>
