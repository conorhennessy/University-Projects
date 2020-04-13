<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Example 73</title>
</head>
<body>
<?php
# Access a Database Table
# Construct a table using the data

$dbname = 'ch17811'; # Change to your username
$dbuser = 'ch17811';
$dbpass = 'obscure';
$dbhost = 'localhost';

$link = mysqli_connect( $dbhost, $dbuser, $dbpass )
or die( "Unable to Connect to '$dbhost'" );

mysqli_select_db( $link, $dbname )
or die("Could not open the db '$dbname'");

$test_query = "select * from inventory";
$result = mysqli_query( $link, $test_query );

echo '<table>';

echo "<tr><th>Code</th><th>Item</th><th>Author</th><th>Price</th></tr>\n";

while( $row = mysqli_fetch_array( $result, MYSQLI_ASSOC ) )
{
  echo "<tr>\n";
  echo '<td>', $row[ 'item_code' ], '</td>',
  '<td>', $row[ 'item_name' ], '</td>',
  '<td>', $row[ 'item_author' ], '</td>',
  '<td>', $row[ 'item_price' ], '</td>', "\n";
  echo "</tr>\n";
}

echo '</table>';

mysqli_free_result( $result );
mysqli_close( $link );
?>
</body>
</html>
