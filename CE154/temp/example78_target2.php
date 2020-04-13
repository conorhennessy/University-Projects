<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Example 78 Target 2</title>
</head>
<body>
<?php
# This is identical to example78_target.php
# It is to demonstrate that:
# 1. You can visit 78 Target or 78 Target 2 if you are logged in.
# 2. You cannot visit 78 Target or 78 Target 2 if you are not logged in.
#
# Remember, visiting Example 78 will automatically log you off.

# We are Forwarded to here from Example 78
# Only if Username and Password are correct
#
# This version sends you back to the login page if you are not logged in.
# Every page of your website should do this to ensure it cannot be accessed
# before logging in.

# We must start session to gain access to $_SESSION
session_start();

# If not logged in, send back to login page:
if ( !isset( $_SESSION[ 'username' ] ) )
{
      header( 'Location: example78.php' );
    exit();
}

echo '<h2>You are logged in</h2>', "\n";
echo '<p>Your Customer Number is: ', $_SESSION[ 'username' ], '</p>', "\n";
?>
</body>
</html>
