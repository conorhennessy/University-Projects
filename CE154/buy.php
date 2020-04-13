<!--Conor's Shop; Coursework for CE154 Essex CS module -->
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Purchase complete</title>
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

		#Update stock and raise stock count by one and order number one
		$stockQuery = $_GET[ 'item_code' ];
		mysqli_query( $link, "update inventory set item_stock_count = item_stock_count - 1 where item_code='$stockQuery'");
		
		if( isset( $_GET[ 'promo_code' ] ) ){
			$promoQuery = mysqli_query( $link, "SELECT * FROM promotion_code WHERE code = '" . $_GET[ 'promo_code' ] . "'");
			if ( mysqli_num_rows( $promoQuery ) != 0)
			{
				#do stuff that changes price as promo code was found
				
				$row = mysqli_fetch_array($promoQuery);
				$discountAmmount = $row[ 'discount' ];
			}
			
			$query = "SELECT * FROM inventory WHERE item_code =\"" . $_GET[ 'item_code' ] . "\"";
			$result = mysqli_query( $link, $query );
			
			$row = mysqli_fetch_array( $result);
			
			$price = $row[ 'item_price' ] - ($row[ 'item_price' ] * ($discountAmmount/100));
		}
		else {
			$query = "SELECT * FROM inventory WHERE item_code =\"" . $_GET[ 'item_code' ] . "\"";
			$result = mysqli_query( $link, $query );
			
			$row = mysqli_fetch_array( $result);
			
			$price = $row[ 'item_price' ];
		}
		$price = round($price, 2);
		
		#Scrip to add order to customer_order table and then order_item table
		$customerOrderInsertQuery = "INSERT INTO customer_order (order_date,delivered,shipping_date,customer_number) VALUES (now(), FALSE, adddate(now(), interval 3 day)," . $_SESSION[ 'username' ] . ");";
		$result = mysqli_query( $link, $customerOrderInsertQuery);
		
		$lastOrderNum = mysqli_fetch_array( mysqli_query( $link, "SELECT MAX(order_number) FROM customer_order") );
		
		$orderItemInsertQuery = "INSERT INTO order_item VALUES ('" . $row[ 'item_code'] . "'," . $price . "," . $lastOrderNum['MAX(order_number)'] . ", 1);";
		$result = mysqli_query( $link, $orderItemInsertQuery);
					
		echo "<h><i>Purchase complete!</i></h>";
		echo "<img width=\"250\" height=\"250\" src=\"images/", $row[ 'item_image_loc' ], "\" alt=\"Image of product\">";
		echo "<h2>", $row[ 'item_name' ], "</h2>";
		echo "<h3>", $row[ 'item_author' ], "     £", $price, "</h3>\n";
		echo "<p>", $row[ 'item_description' ], "</p>";
		echo "<a class=\"buy\" href=\"", $row[ 'item_code' ], "&item_price=", $price, "\">Now Instock: ", $row[ 'item_stock_count' ], "</a>";
		
		mysqli_free_result( $result );
		mysqli_close( $link );
		?>
      </div>

  </body>
</html>
