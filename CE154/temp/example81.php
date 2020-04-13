<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Example 81</title>
  <style type="text/css">
    form  { display: table; padding-bottom: 15px; }
    p     { display: table-row; }
    label { display: table-cell; padding-bottom: 15px; }
    input { display: table-cell; }
  </style>
</head>
<body>
<!-- Demonstration of 'sticky' form fields, input validation and Regex -->

<form action = "example81.php" method = "GET">
<p>
<label for = "a">Address:</label>
<input id = "a" type = "text" name = "address"
value ="<?php if ( isset( $_GET[ 'address' ] ) ) echo $_GET[ 'address' ];?>" />
</p>
<p>
<label for = "b">Telephone:</label>
<input id = "b" type = "text" name = "telephone"
value ="<?php if ( isset( $_GET[ 'telephone' ] ) ) echo $_GET[ 'telephone' ];
?>" />
</p>
<p>
<label for = "b">Email:</label>
<input id = "b" type = "text" name = "email"
value ="<?php if ( isset( $_GET[ 'email' ] ) ) echo $_GET[ 'email' ];
?>" />
</p>
<input type = "submit" value = "Submit" />
</form>

<?php
if ( isset( $_GET[ 'address' ] ) && $_GET[ 'address' ] != '' )
{
  echo '<h3>Address is good</h3>';
}
else
{
  echo '<h3>Please enter a non-empty address</h3>';
}

if ( isset( $_GET[ 'telephone' ] ) && ctype_digit( $_GET[ 'telephone' ] ) )
{
  echo '<h3>Telephone number is good</h3>';
}
else
{
  echo '<h3>Please enter a numeric telephone number with no spaces</h3>';
}

$email_regex = '/^([a-z0-9_\.-]+)@([0-9a-z\.-]+)\.([a-z]{2,6})$/';
if ( isset( $_GET[ 'email' ] ) &&
     preg_match( $email_regex, $_GET[ 'email' ] ) )
{
  echo '<h3>Email address is good</h3>';
}
else
{
  echo '<h3>Please enter a valid email address</h3>';
}

?>
</body>
</html>
