<!--Conor's Shop; Coursework for CE154 Essex CS module -->
<!-- -->
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Manager Page</title>
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
		if ( !isset( $_SESSION[ 'manager' ] ) ){
			echo "<h4><i>Manager Page</i></h4>";
			echo "<h2><i>Access Denied, you must be logged in as manager to see this!</i></h2>";
		}
		else {
		echo "<h2><i>Manager Page</i></h2>";
		
		# Access All tables
		# Construct a table using all the data
		$dbname = 'ch17811';
		$dbuser = 'ch17811';
		$dbpass = 'obscure';
		$dbhost = 'localhost';

		$link = mysqli_connect( $dbhost, $dbuser, $dbpass )
		or die( "Unable to Connect to '$dbhost'" );

		mysqli_select_db( $link, $dbname )
		or die("Could not open the db '$dbname'");

		$tables = ['inventory', 'inventory_group', 'manager', 'customer', 'customer_order', 'order_item', 'promotion_code', 'review'];
		
		for ($i = 0; $i < 7; $i++) {
			$query = "SELECT * FROM " . $tables[$i];
			$result = mysqli_query($link, $query);
			$row2 = mysqli_fetch_array($result, MYSQLI_ASSOC);
			
			echo "<h1>" . $tables[$i] . " table...</h1>";
			echo "<table>";
			echo "<tr>";
			foreach ($row2 as $key => $value) {
					echo '<th>' . $key . '</th>';
			}
			echo "</tr>";
			
			echo "<tr>";
			foreach ($row2 as $key => $value) {
					echo '<td>' . $value . '</td>';
			}
			echo "</tr>";			
			
			while ($row = mysqli_fetch_array($result, MYSQLI_ASSOC)) {
				echo "<tr>";
				foreach ($row as $key => $value) {
					echo '<td>' . $value . '</td>';
				}
				echo "</tr>";
			}
			echo "</table>";
			
			mysqli_free_result($result);
		}
		}
		mysqli_close( $link );
		?>
      </div>

  </body>
</html>
