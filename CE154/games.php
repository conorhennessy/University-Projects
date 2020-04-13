<!--Conor's Shop; Coursework for CE154 Essex CS module -->
<!-- -->
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Games</title>
	<link rel="stylesheet" type="text/css" href="masterCSS.css">
	<link rel="icon" type="image/x-icon" href="icon.ico">
  </head>
  <body>
      <div class="header">
		<?php
		require('headermenu.php');
		?>
      </div>

      <div class="left">
		<?php
		require('leftmenu.php');
		?>
      </div>

      <div class="content">
        <h2><i>Games</i></h2>
		<?php
		$itemTypeID = 1003;
		require('item_creator.php');
		?>
      </div>

  </body>
</html>
