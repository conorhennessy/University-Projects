<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Example 74 Buy</title>
</head>
<body>
<?php
# Called from example74.php when a 'purchase' is made
# Reports back the item_code and item_price
# These are passed to this script URL encoded

$item_code = $_GET[ 'item_code' ];
$item_price = $_GET[ 'item_price' ];

echo "<p>Item Code = $item_code</p>\n";
echo "<p>Item Price = $item_price</p>\n";

echo "<p>We can now create an order or process in any way we choose.</p>\n";
?>
</body>
</html>
