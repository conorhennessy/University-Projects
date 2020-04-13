<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Example 78</title>
  <style type="text/css">
    form  { display: table; padding-bottom: 15px; }
    p     { display: table-row; }
    label { display: table-cell; padding-bottom: 15px; }
    input { display: table-cell; }
  </style>
</head>
<body>
<?php
# Login which checks username and password in the database.
# In addition, this version also terminates any previous session before
# processing the login.
#
# Visiting this page is thus equivalent to logging out.
# Uses Post Back and $_SESSION
# We are using GET method which is not secure but you can see
# attributes/values URL encoded which is good for testing

echo '<form action = "example78.php" method = "GET">', "\n",
'<p><label for = "a">Username:</label>',
'<input id = "a" type = "text" name = "username" /></p>', "\n",
'<p><label for = "b">Password:</label>',
'<input id = "b" type = "text" name = "password" /></p>', "\n",
'<input type = "submit" value = "login" />', "\n",
'<p></form></p>', "\n";

# End any previous session, if any.
# If you visit this page, you are effectively logged out
# and need to log in again.
session_start();
$_SESSION = array();
session_destroy();

if ( isset( $_GET[ 'username' ] ) && isset( $_GET[ 'password' ] ) )
{
  $username = $_GET[ 'username' ];
  $password = $_GET[ 'password' ];

	$dbname = 'ch17811';
	$dbuser = 'root';
	$dbpass = 'obscure';
	$dbhost = 'localhost';

  $link = mysqli_connect( $dbhost, $dbuser, $dbpass )
  or die( "Unable to Connect to '$dbhost'" );

  mysqli_select_db( $link, $dbname )
  or die("Could not open the db '$dbname'");

  $password_query = "select * from customer where customer_number = '" .
  $username . "' and passwd = MD5( '" . $password . "' )";
  $result = mysqli_query( $link, $password_query );

  if ( mysqli_num_rows( $result ) == 1 ) # Number of result rows
  {
    session_start();
    $_SESSION[ 'username' ] = $username;
    header( 'Location: example78_target.php' );
    exit();
  }

  else
  {
    echo '<p>Login failed. Please try again.</p>', "\n";
    '</p>';
  }
}

?>
</body>
</html>
