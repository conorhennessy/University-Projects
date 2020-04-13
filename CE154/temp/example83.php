<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Example 83</title>
  <style type="text/css">
    form  { display: table; padding-bottom: 15px; }
    p     { display: table-row; }
    label { display: table-cell; padding-bottom: 15px; }
    input { display: table-cell; }
  </style>
</head>
<body>
<!-- Demonstration of shopping cart -->

<form action = "example83.php" method = "GET">
<p>
<label for = "a">item_code:</label>
<input id = "a" type = "text" name = "item_code"
value ="<?php if ( isset( $_GET[ 'item_code' ] ) ) 
echo $_GET[ 'item_code' ];?>" />
</p>
<p>
<label for = "b">item_name:</label>
<input id = "b" type = "text" name = "item_name"
value ="<?php if ( isset( $_GET[ 'item_name' ] ) ) echo $_GET[ 'item_name' ];
?>" />
</p>
<p>
<label for = "b">item_price:</label>
<input id = "b" type = "text" name = "item_price"
value ="<?php if ( isset( $_GET[ 'item_price' ] ) ) echo $_GET[ 'item_price' ];
?>" />
</p>
<p>
<label for = "b">quantity:</label>
<input id = "b" type = "text" name = "quantity"
value ="<?php if ( isset( $_GET[ 'quantity' ] ) ) echo $_GET[ 'quantity' ];
?>" />
</p>
<input type = "submit" value = "Add to Cart" />
</form>

<?php
session_start();
if ( isset( $_GET[ 'item_code' ] ) &&
     isset( $_SESSION[ 'cart' ] [ $_GET[ 'item_code' ] ] ) )
{
  # Already in cart, just increase the quantity
  $_SESSION[ 'cart' ] [ $_GET[ 'item_code' ] ] [ 'quantity' ] +=
    (int) $_GET[ 'quantity' ];
}
else
{
  # Not in cart. Add it

  if ( isset( $_GET[ 'item_code' ] ) )
  {
    $_SESSION[ 'cart' ] [ $_GET[ 'item_code' ] ] [ 'quantity' ] =
      (int) $_GET[ 'quantity' ];

    $_SESSION[ 'cart' ] [ $_GET[ 'item_code' ] ] [ 'item_price' ] =
      (int) $_GET[ 'item_price' ];

    $_SESSION[ 'cart' ] [ $_GET[ 'item_code' ] ] [ 'item_name' ] =
      $_GET[ 'item_name' ];
  }
}

# Show the contents of the Shopping Cart

if ( isset( $_SESSION[ 'cart' ] ) )
{
  foreach ( $_SESSION[ 'cart' ] as $code => $details )
  {
    if ( $code == '' ) continue;
    echo '<p>';
    echo 'item_code=', $code, ' ',
    'item_name=', $details[ 'item_name' ], ' ',
    'item_price=', $details[ 'item_price' ], ' ',
    'quantity=', $details[ 'quantity' ];  
    echo '</p>';
  }
}
else
{
  echo '<h3>Cart Empty</h3>';
}

?>
</body>
</html>
