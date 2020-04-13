<!--Conor's Shop; Coursework for CE154 Essex CS module -->
<!-- -->
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Search Results</title>
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
        <h2><i>Search results</i></h2>
        <?php
		$dbname = 'ch17811';
		$dbuser = 'ch17811';
		$dbpass = 'obscure';
		$dbhost = 'localhost';

		$link = mysqli_connect( $dbhost, $dbuser, $dbpass )
		or die( "Unable to Connect to '$dbhost'" );

		mysqli_select_db( $link, $dbname )
		or die("Could not open the db '$dbname'");

		# search for items contain string in Database inventory table
		$searchTerm = $_GET[ 'search'];
		$query = "SELECT * FROM inventory WHERE item_description LIKE '%$searchTerm%'";
		$result = mysqli_query( $link, $query );
		$num = 0;
		
		while( $row = mysqli_fetch_array( $result, MYSQLI_ASSOC ) )
		{
		$num = $num + 1;
		echo "<div>";
		echo "<img width=\"250\" height=\"250\" src=\"images/", $row[ 'item_image_loc' ], "\"></img>";
		echo "<h2>", $row[ 'item_name' ], "<h2>";
		echo "<h3>", $row[ 'item_author' ], "     £", $row[ 'item_price' ], "</h3>\n";
		echo "<p>", $row[ 'item_description' ], "</p>";
		if ($row['item_stock_count'] > $row['item_order_count'] ) {
			echo "<a class=\"buy\" href=\"item.php?item_code=", $row[ 'item_code' ],
			"&item_price=", $row[ 'item_price' ], "\">Buy <br/> Instock: ", $row[ 'item_stock_count' ], "</a>";
			}
		else {
			echo "<a class=\"sold\" href=\"\">Out Of Stock</a>";
			}
		  echo "<hr></div>";
		}
		if ($num == 0) {
			echo "<h4><i>Sorry! No search results found!</i></h4>";
		}
		
		
		mysqli_free_result( $result );
		mysqli_close( $link );
		?>
      </div>

  </body>
</html>
