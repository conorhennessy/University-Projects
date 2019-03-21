<!DOCTYPE html>
<html lang="en">

<!-- Submitted by Reg Number: 1703055-->

<head>
    <!-- Here in the head the tittle text, some attributes are set up to help with styling and accessibility and the CSS sheet is called-->
    <title>Colin Ritman - experience</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="css/assignment2-pages.css"/>
    <!-- The following is a style sheet call purely for the Open Sans font-->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans">
    <!-- The following is a style sheet call purely for the Open Sans font-->
</head>

<body>
<!-- Div for the navigation bar, featuring click-able buttons for navigating to anchor tags in the page-->
<div class="container">
	<?php
	require('headermenu.php');
	?>
</div>

<!-- Div set up for the remainder of the page, the content itself. Containing further child divs for each section -->

<div class="content">

<div class="container">
  <form>
    <label for="name">Your name:</label>
    <input type="text" id="name" name="name" placeholder="Your name...">

    <label for="email">Email:</label>
    <input type="text" id="email" name="email" placeholder="Your email...">

    <label for="msg">What would you like to say?</label>
    <textarea id="msg" name="msg" placeholder="Write something here!" style="height:200px"></textarea>

    <input type="submit" value="Send">
</form>

</div>
</div>
</body>
</html>