<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Example 76</title>
  <style type="text/css">
    form  { display: table; padding-bottom: 15px; }
    p     { display: table-row; }
    label { display: table-cell; padding-bottom: 15px; }
    input { display: table-cell; }
  </style>
</head>
<body>
<?php
# Basic Login using Post Back and $_SESSION
# We are using GET method which is not secure but you can see
# attributes/values URL encoded which is good for testing

echo '<form action = "example76.php" method = "GET">', "\n",
'<p><label for = "a">Username:</label>',
'<input id = "a" type = "text" name = "username" /></p>', "\n",
'<p><label for = "b">Password:</label>',
'<input id = "b" type = "text" name = "password" /></p>', "\n",
'<input type = "submit" value = "login" />', "\n",
'<p></form></p>', "\n";

if ( isset( $_GET[ 'username' ] ) && isset( $_GET[ 'password' ] ) )
{
  $username = $_GET[ 'username' ];
  $password = $_GET[ 'password' ];
  if ( $password == 'secret' )
  {
    session_start();
    $_SESSION[ 'username' ] = $username;
    header( 'Location: example76_target.php' );
    exit();
  }

  else
  {
    echo '<p>Login failed. Please try again.</p>', "\n";
  }
}

?>
</body>
</html>
