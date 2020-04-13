<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Example 58</title>
  </head>
  <body>
    <?php
      # Integer, Double, and String concatenation
      $x = 1;
      $pi = 3.14;
      $quote = "This is a string";
      # Double quoted form:
      echo "<p>" . "\$x is " . $x .  ", \$pi is " . $pi .
      ", \$quote is '" . $quote . "'" . "</p>";
      # Here, we are concatenating (joining) all strings into one
      # Single quoted form:
      echo '<p>' . '$x is ' . $x .  ', $pi is ' . $pi . ', $quote is \'' .
      $quote . '\'' . '</p>';
      ?>
    
  </body>
</html>
