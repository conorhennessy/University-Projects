<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Example 70</title>
  </head>
  <body>
    <div id="content">
      <form action="example70_form.php" method="GET">
        <input type="radio" name="term" value="aut" />Autumn
        <input type="radio" name="term" value="spr" checked />Spring
        <input type="radio" name="term" value="sum" />Summer
        <br />
        <select name="dept">
          <option value="csee">CSEE</option>
          <option value="lang_ling">Language and Linguistics</option>
          <option value="psych">Psychology</option>
        </select>
        <br />
        <textarea name="message" rows="4" cols="30">Feedback.</textarea>
        <br />
        <button type="button" onclick="alert('Hello')">Alert</button>
        <br />
        <input type="reset" value="Reset" />
        <br />
        <input type="submit" value="Submit" />
      </form> 
    </div>
  </body>
</html>
