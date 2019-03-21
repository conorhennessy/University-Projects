<!DOCTYPE html>
<html lang="en">

<!-- Submitted by Reg Number: 1703055-->

<head>
    <!-- Here in the head the tittle text, some attributes are set up to help with styling and accessibility and the CSS sheet is called-->
    <title>I am Colin Ritman</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="css/assignment2-main.css"/>
    <!-- The following is a style sheet call purely for the Open Sans font-->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans">
    <!-- The following is a style sheet call purely for the Open Sans font-->
</head>

<body>
<div class="topBar">
    <div class="title">
        <h1> I am Colin Ritman </h1>
    </div>

    <!-- DIV set up purely for the navigation bar, featuring clickable buttons for navigating to anchor tags in the page-->
	<!-- The php header included rather than repeating that div every page!-->
	<?php
	require('headermenu.php');
	?>

    <a href="#aboutMe">
    <div class="scrollArrow"></div>
    </a>
</div>

<!-- Div set up for the remainder of the page, the content itself. Containing further child divs for each section -->
<div class="content">

    <div class="section" id="aboutMe">
        <h2>About...</h2>
        <img class="about" src="images/image-general1.jpg"
             alt="About image one - Showing multiple people looking at a computer with Colin at the center.">
        <!-- img SOURCE: https://www.express.co.uk/showbiz/tv-radio/1070864/Black-Mirror-Bandersnatch-Charlie-Brooker-inspiration-Ian-Livingstone-Netflix Retrieved 18/02/2019-->
        <img class="about" src="images/image-general2.jpg"
             alt="About image two - A personal image of Colin showing him holding a baby with his partner behind him.">
        <!-- img SOURCE: https://divulgantemorte.blogspot.com/2019/01/criticamorte-black-mirror-bandersnatch.html Retrieved 18/02/2019-->
        
<p>
            As an <a style="color: white" href="awards.php">award</a> wining game developer I have developed a number of titles achieving an average of <i>3.25 </i> in the last four games released!
			Some may say that games are developed by committee and that fate has no decision in the forming of a game. But with discussion and planning I envisage to develop
			games with a story in mind and turn the imagination into reality.
        </p>
		<p>
			I am currently looking to broaden my experience by joining a keen development group and so I am open to invitations and offers. </br>
			Why not contact me <a style="color: white" href="contact.php">by clicking here</a>?
		</p>
		
    </div>

</div>
</body>
</html>