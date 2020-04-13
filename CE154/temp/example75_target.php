<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Example 75 Target</title>
</head>
<body>
<?php
# We are Forwarded to here from Example 75

# We must start session to gain access to $_SESSION
session_start();
echo '<h2>You have been forwarded.</h2>', "\n";
echo '<p>Your Session ID is: ', $_SESSION[ 'id' ], '</p>', "\n";
?>
</body>
</html>
