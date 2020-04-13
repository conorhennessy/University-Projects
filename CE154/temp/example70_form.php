<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Example 70 Form</title>
</head>
<body>
<?php
foreach( $_GET as $field => $value )
{
  echo "<p>$field = $value</p>\n";
}

?>
</body>
</html>
