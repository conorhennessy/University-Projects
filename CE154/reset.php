<?php
$dbname = 'ch17811';
$dbuser = 'ch17811';
$dbpass = 'obscure';
$dbhost = 'localhost';

$returnURL = "index.php"; 
if($_SERVER['REQUEST_METHOD'] == 'POST'){
	if(isset($_POST["returnURL"])){
		$returnURL = $_POST["returnURL"];
	}
}else{
	if(isset($_GET["returnURL"])){
		$returnURL = $_GET["returnURL"];
	}
}


if($_SERVER['REQUEST_METHOD'] == 'POST'){
	require 'data.php';	
	echo "<h2> RESETTING DATABASE: $dbname </h2>";

	# Connect to a database and access a table
	$link = mysqli_connect( $dbhost, $dbuser, $dbpass )
	or die( "Unable to Connect to '$dbhost'" );

	mysqli_select_db( $link, $dbname )
	or die("Could not open the db '$dbname'");

	// Order is important because of foreign key constraints
	$tableNames = [
		"order_item",
		"customer_order",
		"customer",
		"manager",
		"review",
		"inventory",
		"promotion_code",
		"inventory_group"
	];
	
	// Delete all content from tables
	foreach($tableNames as $tableName){
		mysqli_query($link, "DELETE FROM $tableName;");
	}

	// Optionally merge the student data with the provided data
	if($_POST["includeStudent"] == "Yes"){
		require 'student_data.php';
		echo "<p> Included student data </p>";
		$inventory = array_merge($inventory, $student_inventory);
	}else{
		echo "<p> Did not include student data </p>";
	}

	// Join all insert queries for ease of use
	$tables = [$groups, $inventory, $customers, $customer_orders,
	$order_items, $managers, $reviews, $promotion_codes];
	// Execute all queries
	foreach ($tables as $table){
		foreach ($table as $query){
		  mysqli_query($link, $query);
		}
	}
}
?>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Reset Database <?php echo "$dbname"; ?></title>
</head>
<body>
<?php
	if($_SERVER['REQUEST_METHOD'] == 'POST'){
		// Prove there are at least correct number of tables
		echo "<br /><br /><h3> Database Counts </h3>";
		echo "<table><thead><tr><th>Table</th><th>Records</th></tr>";
		echo "</thead><tbody>";
		foreach($tableNames as $tableName){
			echo "<tr><td>$tableName</td>";
			$result = mysqli_query($link,
			"SELECT COUNT(*) FROM $tableName;");
			$row = mysqli_fetch_row($result);
			//foreach($row as $item){
				echo "<td>$row[0]</td>";
			//}
			echo "</tr>";
			mysqli_free_result($result);
		}
		echo "</tbody></table>";

		// Close the link
		mysqli_close( $link );
	}else{
?>
<h3>Reset form</h3>
<form action="reset.php" method="POST">
	<label for="includeStudent">Include Student Data?</label>
	<select name="includeStudent">
		<option value="Yes" selected>Yes</option>
		<option value="No">No</option>
	</select>
	<br />
	<input type="hidden" name="returnURL"
	value="<?php echo $returnURL; ?>" />
	<br />
	<input type="submit" name="submit" />
</form>
<br />
<br />
<?php } ?>
<br />
<a href="<?php echo "$returnURL"; ?>"> Return</a>
</body>
</html>
