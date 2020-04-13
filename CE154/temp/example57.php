<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Example 57</title>
  </head>
  <body>
    <?php
      # Integer, Double, and Double Quoted Mixed Strings
      # References to variables are *inside* the double quoted strings
      $x = 1;
      $pi = 3.14;
      $quote = "This is a string";
      echo "<p>", "\$x is $x, \$pi is $pi, \$quote is '$quote'", "</p>";
      # Here, ' does not need quoting within "..."
      # However, $ and others do need quoting to stand for themselves
      # $quote with no backslash is a reference to the variable
      # The value of the variable is substituted into the string
    ?>
  </body>
</html>
