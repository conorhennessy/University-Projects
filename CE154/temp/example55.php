<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Example 55</title>
  </head>
  <body>
    <?php
      # Integer, Double, and Single Quoted Strings
      $x = 1;
      $pi = 3.14;
      $quote = 'This is a string';
      echo '<p>', 'variable $x has value ', $x, '</p>';
      echo '<p>', 'variable $pi has value ', $pi, '</p>';
      echo '<p>', 'variable $quote has value \'', $quote, '\'</p>';
      # Only ' and \ can be preceded by \ to mean themselves,
      # i.e. \' and \\
    ?>
  </body>
</html>