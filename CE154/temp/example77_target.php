<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Example 77 Target</title>
</head>
<body>
<?php
# We are Forwarded to here from Example 77
# Only if Username and Password are correct

# We must start session to gain access to $_SESSION
session_start();
echo '<h2>You have successfully logged in</h2>', "\n";
echo '<p>Your Customer Number is: ', $_SESSION[ 'username' ], '</p>', "\n";
?>
</body>
</html>
