<!--Conor's Shop; Coursework for CE154 Essex CS module -->
<!-- -->
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Buy Item</title>
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
		# 'Purchase' item in Database Table
		# using hyperlink and URL encoding
		$dbname = 'ch17811';
		$dbuser = 'ch17811';
		$dbpass = 'obscure';
		$dbhost = 'localhost';

		$link = mysqli_connect( $dbhost, $dbuser, $dbpass )
		or die( "Unable to Connect to '$dbhost'" );

		mysqli_select_db( $link, $dbname )
		or die("Could not open the db '$dbname'");

		$test_query = "SELECT * FROM inventory WHERE item_code =\"" . $_GET[ 'item_code' ] . "\"";
		$result = mysqli_query( $link, $test_query );
		
		$row = mysqli_fetch_array( $result);
		
		echo "<div>";
		echo "<img width=\"250\" height=\"250\" src=\"images/", $row[ 'item_image_loc' ], "\" alt=\"Image of product\"></img>";
		echo "<h2>", $row[ 'item_name' ], "<h2>";
		echo "<h3>", $row[ 'item_author' ], "     £", $row[ 'item_price' ], "</h3>\n";
		echo "<p>", $row[ 'item_description' ], "</p>";

		# If not logged in, send back to login page:
		if ( !isset( $_SESSION[ 'username' ] ) )
		{
			echo "<a class=\"buy\" style=\"width: 240px;\" href=\"login.php\"\>To purchase you must be logged in!</a>";
			exit();
		}
		else
		{
		echo "<a class=\"buy\" href=\"buy.php?item_code=", $row[ 'item_code' ], "&item_price=", $row[ 'item_price' ], "\">Complete Purchase!<br/>Instock: ", $row[ 'item_stock_count' ], "</a>";
		echo '<form name="promoCode" action = "buy.php" method = "GET">';
		echo '<p class="search">Promo Code:<input id = "a" type = "text" name = "promo_code" /></p>';
		echo '<input type="hidden" name="item_code" value=', $row[ 'item_code' ], ' ></input>';
		echo '<input type="hidden" name="item_price" value=', $row[ 'item_price' ], ' ></input>';
		echo '<input type="submit" value="Apply"/></p></form>';
		}
		echo "</div>";
		
		mysqli_free_result( $result );
		mysqli_close( $link );
		?>
      </div>

  </body>
</html>
