<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Example 71</title>
</head>
<body>
<?php
# Connect to a database and access a table

$dbname = 'ch17811'; # Change to your username
$dbuser = 'root';
$dbpass = 'obscure';
$dbhost = 'localhost';

$link = mysqli_connect( $dbhost, $dbuser, $dbpass )
or die( "Unable to Connect to '$dbhost'" );

mysqli_select_db( $link, $dbname )
or die("Could not open the db '$dbname'");

$test_query = "select * from inventory";
$result = mysqli_query( $link, $test_query );

while( $row = mysqli_fetch_array( $result, MYSQLI_ASSOC ) )
{
  echo $row[ 'item_code' ], ' ', $row[ 'item_name' ], ' ',
  $row[ 'item_author' ], ' ', $row[ 'item_price' ], "<br />\n";
}

mysqli_free_result( $result );
mysqli_close( $link );
?>
</body>
</html>
