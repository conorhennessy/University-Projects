<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Example 69 Form</title>
  <style>
  body {
    text-align: center;
    background-color: red;
	padding: 30%;
	color: white;
    }
  </style>
</head>
<body>
<?php

$firstname = $_GET[ 'firstname' ];
$lastname = $_GET[ 'lastname' ];

echo "<p><strong>First Name = $firstname</p></strong>\n";
echo "<p><strong>Last Name = $lastname</p></strong>\n";
?>
</body>
</html>
