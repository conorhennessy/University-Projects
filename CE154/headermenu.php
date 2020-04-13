<?php
echo "<h1> Conor's Shop Emporium</h1>";
# As this PHP script runs on all pages I have included the session start code here
session_start();
echo "<ul>";
echo "<li><a href=\"reset.php\">Reset DB</a></li>";
if ( isset($_SESSION[ 'manager' ]) ) {
		echo "<li><a href=\"stats.php\">Manager Stats</a></li>" ;
}
if ( !isset($_SESSION[ 'username' ]) ) {
	echo "<li><a href=\"login.php\">Login</a></li>";
}
else {
	echo "<li><a href=\"logout.php\">Logout</a></li>" ;
}
echo "<li><a href=\"index.php\">Home</a></li>";
echo "</ul>";
echo '<form name="search" action = "search.php" method = "GET">';
echo '<p class="search">Search:<input type = "text" name = "search" />';
echo '<input type="submit" value="Submit"/></p></form>';
?>