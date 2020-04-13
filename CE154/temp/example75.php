<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Example 75</title>
</head>
<body>
<?php
# $_SESSION and Forwarding using header() Function

session_start();
$_SESSION[ 'id' ] = 'my_id';
header( 'Location: example75_target.php' );

# Exit to finish
exit();
?>
</body>
</html>
