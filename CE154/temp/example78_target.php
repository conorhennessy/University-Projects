<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Example 78 Target</title>
</head>
<body>
<?php
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
