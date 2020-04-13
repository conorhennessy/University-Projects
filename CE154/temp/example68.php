<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Example 68</title>
</head>
<body>
<?php
# Illustration of Local vs. Global Variables
# and call by value/reference

$line = array( 1, 2, 3, 4 );
$x = 1;
$y = 50;

#----------------------------------------------------------------------
#
# We are going to pass global variable $x as $x_outside to see what
# happens. Place '&' before $x_outside to make it call by reference!

function display( $x_outside )

{
  $x = 10;

  echo '<h2>Inside the function display()</h2>', "\n";
  echo "<p>Local variable \$x = $x; Parameter \$x_outside = $x_outside</p>\n";
  echo "<p>Changing $x_outside to 100;</p>\n";
  $x_outside = 100;
  echo "<p>Now, \$x_outside = $x_outside</p>\n";

  # echo "<p>Trying to access Global variable \$y = $y</p>\n";
  # Uncomment this to see what happens!
}

#----------------------------------------------------------------------
#
# We are going to pass global variable $x as $x_outside to see what
# happens. Place '&' before $x_an_array to make it call by reference!

function change_array( $an_array )

{
  # Attempt to change values
  $an_array[ 0 ] = 25;
  $an_array[ 1 ] = 30;
  $an_array[ 2 ] = 35;
  $an_array[ 3 ] = 40;

  echo '<h2>Inside the function change_array</h2>', "\n";
  echo "<p>Here are the new values in \$an_array:</p>\n";

  foreach ( $an_array as $idx )
  {
    echo $idx, ' ';
  }
  echo "<br/>\n";
}

#----------------------------------------------------------------------
#                      Test Globals / Locals
#----------------------------------------------------------------------

display( $x ); # Call the function to see the values there
echo '<h2>Outside the function</h2>', "\n";
echo "<p>Global Variable \$x = $x;</p>\n";

echo '<h2>Values of Global Array $line</h2>', "\n";

  foreach ( $line as $idx )
  {
    echo $idx, ' ';
  }
  echo "<br/>\n";

echo '<h2>Now calling function change_array with parameter $line</h2>', "\n";

change_array( $line );

echo '<h2>Values of Global Array $line Once Again</h2>', "\n";

  foreach ( $line as $idx )
  {
    echo $idx, ' ';
  }
  echo "<br/>\n";

?>
</body>
</html>
