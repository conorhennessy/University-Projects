<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Example 72</title>
</head>
<body>
<?php
# Connect to a database and access a table
# Use numbers to access columns in table

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

while( $row = mysqli_fetch_array( $result, MYSQLI_NUM ) )
{
  foreach ( $row as $idx => $item )
  {
    echo $idx, ' ', $row[ $idx ], "<br />\n";
  }
  echo '<br/>', "\n";
}

mysqli_free_result( $result );
mysqli_close( $link );
?>
</body>
</html>
