<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Example 76 Target</title>
</head>
<body>
<?php
# We are Forwarded to here from Example 76
# Only if Username and Password are correct

# We must start session to gain access to $_SESSION
session_start();
echo '<h2>You have successfully logged in</h2>', "\n";
echo '<p>Your Username is: ', $_SESSION[ 'username' ], '</p>', "\n";
?>
</body>
</html>
