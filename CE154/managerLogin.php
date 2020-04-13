<!--Conor's Shop; Coursework for CE154 Essex CS module -->
<!-- -->
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Manager Login</title>
	<link rel="stylesheet" type="text/css" href="masterCSS.css">
	<link rel="icon" type="image/x-icon" href="icon.ico">
	
	<script>
	function loginCheck() {
		var usrName = document.forms["login"]["username"].value;
		if (isNaN(parseFloat(usrName))) {
			alert("This username was incorect, this should be a number.\nPlease try again!");
			return false;
		}
		var pass = document.forms["login"]["password"].value;
		if (pass == "") {
			alert("No password entered.\nPlease enter a password!");
			return false;
		}
	}
</script>
  </head>
  <body>
      <div class="header">
		<?php
		require('headermenu.php');
		?>
      </div>

      <div class="left">
		<?php
		require('leftmenu.php');
		?>
      </div>

      <div class="content">
        <h2><i>Manager Login</i></h2>
		<?php
		# Manager login which checks username and password in the database.
		# Uses Post Back and $_SESSION
		# I made use of example 77 to help me with this

		echo '<form name="login" action = "managerLogin.php" method = "GET" autocomplete="off" onsubmit="return loginCheck()">', "\n",
		'<p><label for = "a">Username:</label>',
		'<input id = "a" type = "text" name = "username" /></p>', "\n",
		'<p><label for = "b">Password:</label>',
		'<input id = "b" type = "password" name = "password" /></p>', "\n",
		'<input type = "submit" value = "login" />', "\n",
		'</form>', "\n";
		
		#logout script
		$_SESSION = array();
		session_destroy();

		if ( isset( $_GET[ 'username' ] ) && isset( $_GET[ 'password' ] ) )
		{
		  $username = $_GET[ 'username' ];
		  $password = $_GET[ 'password' ];

	      $dbname = 'ch17811';
		  $dbuser = 'ch17811';
	      $dbpass = 'obscure';
		  $dbhost = 'localhost';

		  $link = mysqli_connect( $dbhost, $dbuser, $dbpass )
		  or die( "Unable to Connect to '$dbhost'" );

		  mysqli_select_db( $link, $dbname )
		  or die("Could not open the db '$dbname'");

		  $password_query = "select * from manager where manager_number = '" .
		  $username . "' and passwd = MD5( '" . $password . "' )";
		  $result = mysqli_query( $link, $password_query );

		  if ( mysqli_num_rows( $result ) == 1 ) # Number of result rows
		  {
			session_start();
			$_SESSION[ 'username' ] = $username;
			$_SESSION[ 'manager' ] = 1;  #set to '1' as manager is true
			header( 'Location: stats.php' );
		  }

		  else
		  {
			echo '<p style="color:red"><strong>Login failed. Please try again!</strong></p>', "\n";
		  }
		}
		
		echo '<p><i>Please click <a style="all:unset; text-decoration: underline;" href="managerLogin.php">here</a> for manager login</i></p>';

		?>
      </div>

  </body>
</html>
