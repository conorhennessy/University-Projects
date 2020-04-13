<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Example 59</title>
</head>
<body>
<?php
# Array indexed by numbers

$languages[ 0 ] = 'Java';
$languages[ 1 ] = 'Python';
$languages[ 2 ] = 'C++';

echo '<h2>Array Indexed by Numbers</h2>', "\n"; # Double quotes for newline!
echo '<ul>';
echo '<li>', $languages[ 0 ], '</li>';
echo '<li>', $languages[ 1 ], '</li>';
echo '<li>', $languages[ 2 ], '</li>';
echo '</ul>', "\n";

# Alternative Declaration, Array indexed by numbers

$languages2 = array( 'Java2', 'Python2', 'C++2' );

echo '<h2>Alternative Declaration, Array Indexed by Numbers</h2>', "\n";
echo '<ul>';
echo '<li>', $languages2[ 0 ], '</li>';
echo '<li>', $languages2[ 1 ], '</li>';
echo '<li>', $languages2[ 2 ], '</li>';
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

?>
</body>
</html>
