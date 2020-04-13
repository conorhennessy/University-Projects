<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Example 59a</title>
</head>
<body>
<?php
# Array indexed by numbers

$months[ 0 ] = 'Java';
$months[ 1 ] = 'Python';
$months[ 2 ] = 'C++';

echo '<h2>Array Indexed by Numbers</h2>', "\n"; # Double quotes for newline!
echo '<ul>';
echo '<li>', $months[ 0 ], '</li>';
echo '<li>', $months[ 1 ], '</li>';
echo '<li>', $months[ 2 ], '</li>';
echo '</ul>', "\n";

# Alternative Declaration, Array indexed by numbers

$months2 = array( 'Java2', 'Python2', 'C++2' );

echo '<h2>Alternative Declaration, Array Indexed by Numbers</h2>', "\n";
echo '<ul>';
echo '<li>', $months2[ 0 ], '</li>';
echo '<li>', $months2[ 1 ], '</li>';
echo '<li>', $months2[ 2 ], '</li>';
echo '</ul>', "\n";

# Array Indexed by Element Names

$schedule[ 'mon' ] = 'lecture';
$schedule[ 'tue' ] = 'lecture';
$schedule[ 'thu' ] = 'lab';
$schedule[ 'fri' ] = 'lab';

echo '<h2>Array Indexed by Element Names</h2>', "\n";
echo '<ol>';
echo '<li>', $schedule[ 'mon' ], '</li>';
echo '<li>', $schedule[ 'tue' ], '</li>';
echo '<li>', $schedule[ 'thu' ], '</li>';
echo '<li>', $schedule[ 'fri' ], '</li>';
echo '</ol>', "\n";

# Alternative Declaration, Array Indexed by Element Names

$schedule2 = array( 'mon' => 'lecture2', 'tue' => 'lecture2', 'thu' => 'lab2',
'fri' => 'lab2' );

echo '<h2>Alternative Declaration, Array Indexed by Element Names</h2>', "\n";
echo '<ol>';
echo '<li>', $schedule2[ 'mon' ], '</li>';
echo '<li>', $schedule2[ 'tue' ], '</li>';
echo '<li>', $schedule2[ 'thu' ], '</li>';
echo '<li>', $schedule2[ 'fri' ], '</li>';
echo '</ol>', "\n";

#Months array

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

echo '<h2>Months Array Indexed by Numbers</h2>', "\n"; 
echo '<ul>';
echo '<li>', $months[ 1 ], '</li>';
echo '<li>', $months[ 2 ], '</li>';
echo '<li>', $months[ 3 ], '</li>';
echo '<li>', $months[ 4 ], '</li>';
echo '<li>', $months[ 5 ], '</li>';
echo '<li>', $months[ 6 ], '</li>';
echo '<li>', $months[ 7 ], '</li>';
echo '<li>', $months[ 8 ], '</li>';
echo '<li>', $months[ 9 ], '</li>';
echo '<li>', $months[ 10 ], '</li>';
echo '<li>', $months[ 11 ], '</li>';
echo '<li>', $months[ 12 ], '</li>';
echo '</ul>', "\n";


?>
</body>
</html>
