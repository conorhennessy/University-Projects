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

$result = mysqli_query( $link, "SELECT * FROM inventory WHERE item_group = $itemTypeID" );

while( $row = mysqli_fetch_array( $result, MYSQLI_ASSOC ) )
{
  echo "<div>";
  echo "<img width=\"250\" height=\"250\" src=\"images/", $row[ 'item_image_loc' ], "\" alt=\"Image of product\">";
  echo "<h2>", $row[ 'item_name' ], "</h2>";
  echo "<h4>", $row[ 'item_code' ], "</h4>";
  echo "<h3>", $row[ 'item_author' ], "     £", $row[ 'item_price' ], "</h3>\n";
  echo "<p>", $row[ 'item_description' ], "</p>";
  if ($row['item_stock_count'] == 0 ) {
	echo "<a class=\"sold\" href=\"\">Out Of Stock</a>";
  }
  else {
	echo "<a class=\"buy\" href=\"item.php?item_code=", $row[ 'item_code' ],
	"&item_price=", $row[ 'item_price' ], "\">Buy <br/> Instock: ", $row[ 'item_stock_count' ], "</a>";
  }
  echo "<hr></div>";
}

mysqli_free_result( $result );
mysqli_close( $link );
?>