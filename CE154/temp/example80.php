<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Example 80</title>
  <style type="text/css">
    form  { display: table; padding-bottom: 15px; }
    p     { display: table-row; }
    label { display: table-cell; padding-bottom: 15px; }
    input { display: table-cell; }
  </style>
</head>
<body>
<?php
# Test various validation functions
$w = null;
$x = 1;
# $y is not defined

echo '<h3>isset()</h3>', "\n";
echo var_dump( isset( $x ) ), "\n"; # True
echo var_dump( isset( $y ) ), "\n"; # False, note that $y is not defined

$z = '';
echo '<h3>empty()</h3>', "\n";
echo var_dump( empty( $y ) ), "\n"; # True as does not exist
echo var_dump( empty( $z ) ), "\n"; # True as empty string
$z = 'hello';
echo var_dump( empty( $z ) ), "\n"; # False as no longer empty string

echo '<h3>is_null()</h3>', "\n";
echo var_dump( is_null( $w ) ), "\n"; # True as it is null
echo var_dump( is_null( $z ) ), "\n"; # False as empty string

echo '<h3>is_numeric()</h3>', "\n";
echo var_dump( is_numeric( '10' ) ), "\n"; # True as all digits
echo var_dump( is_numeric( '10.1' ) ), "\n"; # True as decimal point . allowed
echo var_dump( is_numeric( '10,1' ) ), "\n"; # False as , not allowed

echo '<h3>ctype_digit()</h3>', "\n";
echo var_dump( ctype_digit( '10' ) ), "\n"; # True as all digits
echo var_dump( ctype_digit( '10.1' ) ), "\n"; # False as . not allowed 

echo '<h3>trim()</h3>', "\n";
echo '"', trim( '   hello     ' ), '"', "\n"; # No leading/trailing blanks
?>
</body>
</html>
