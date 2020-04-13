<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Example 56</title>
  </head>
  <body>
    <?php
      # Integer, Double, and Double Quoted Strings
      $x = 1;
      $pi = 3.14;
      $quote = "This is a string";
      echo "<p>", "variable \$x has value ", $x, "</p>";
      echo "<p>", "variable \$pi has value ", $pi, "</p>";
      echo "<p>", "variable \$quote has value '", $quote, "'</p>";
      # Here, ' does not need quoting within "..."
      # However, $ and others do need quoting to stand for themselves
    ?>
  </body>
</html>
