<!--Conor's Shop; Coursework for CE154 Essex CS module -->
<!-- -->
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Logged in!</title>
	<link rel="stylesheet" type="text/css" href="masterCSS.css">
	<link rel="icon" type="image/x-icon" href="icon.ico">
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
		<?php
			
			# If not logged in, send back to login page...
			if ( !isset( $_SESSION[ 'username' ] ) )
			{
				header( 'Location: login.php' );
				exit();
			}
			
			echo '<h1><i> Sucessfully logged in!</i> </h1>';
			echo '<p> Customer number: ', $_SESSION[ 'username' ], '</p>';
		?>
      </div>

  </body>
</html>
