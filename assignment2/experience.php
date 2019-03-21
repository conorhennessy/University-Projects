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
<div style="background-color: initial" class="container">
	<?php
	require('headermenu.php');
	?>
</div>

<!-- Div set up for the remainder of the page, the content itself. Containing further child divs for each section -->
<div class="content">
    <div class="section" id="experience">
        <h2>Recent Experience</h2>
            <img class="example" src="images/thumb-nohzdyve1.gif" alt="First image depicting the loading screen from Nohzdyve.">
            <img class="example" src="images/thumb-nohzdyve2.gif" alt="Image with minor start of game play from Nohzdyve.">
            <img class="example" src="images/thumb-nohzdyve3.gif" alt="Image featuring some game play from the aclaimed Nohzdyve game as the player falls through the level.">
			<!-- ALl three of the above images came from the same source SOURCE: https://tuckersoft.net/ealing20541/nohzdyve/ Retrieved 20/02/2019-->
        <p>
			 Colin is a passionate developer and artist. His strong expertise has been built over the past 10 years, dedicating his time between academia and the gaming industry. 
			 He started his career with Tuckersoft after developing many games out of his own house hold. Now working at Tuckersoft, Colin fully explores his creativity, tearing down the wall between art and gaming. 
			 Prior to that, he has been working as a free lance developer, where he discovered his passion for graphics and audio design. His titles include the puzzle game "Pig in a poke" and the upcoming game depicted above - Nohzdyve.   
        </p>
		
		<p>
            Recent projects include Nohzdyve, pictured above, a single plat-former game. Where the user falls to cat all the points required to pas onto the next level!
			</BR>
			With this Colin has particular experience in developing for the <i>ZX spectrum</i> - a particularly niche bit of technology in todays field of work!
        </p>

		<p>
			I am currently looking to broaden my experience by joining a keen development group and so I am open to invitations and offers. </br>
			Why not contact me <a style="color: white" href="contact.php">by clicking here</a>?
		</p>
    </div>

    <div class="section" id="myWork">
        <h2>Prior work @ <a href="https://tuckersoft.net/ealing20541/"><img class="logo"
                                                                            src="images/icon-tuckersoftLogo.gif"
                                                                            alt="TUCKERSOFT"></a></h2>
        <!-- The TUCKERSOFT logo came from this page SOURCE: https://tuckersoft.net/ealing20541/ Retrieved 20/02/2019-->
        <div class="preview">
            <a href="https://tuckersoft.net/ealing20541/nohzdyve/"><img class="game" src="images/game-nohzdyve.gif"
                                                                        alt="A small preview of the Nohzdyve game cover."></a>
            <!-- nohzdyve img SOURCE: https://tuckersoft.net/ealing20541/history/ Retrieved 20/02/2019-->
            <div class="caption">
                <a href="https://tuckersoft.net/ealing20541/nohzdyve/"><p>Nohzdyve - 4 / 5 Stars IMDB</p></a>
            </div>
        </div>
        <div class="preview">
            <a href="https://tuckersoft.net/ealing20541/metlhedd/"><img class="game" src="images/game-metlhedd.gif"
                                                                        alt="Second picture in the series with a small preview of the Metlhedd game cover."></a>
            <!-- metlhedd img SOURCE: https://tuckersoft.net/ealing20541/history/  Retrieved 20/02/2019-->
            <div class="caption">
                <a href="https://tuckersoft.net/ealing20541/metlhedd/"><p>Metlhedd - 3.5 / 5 Stars</p></a>
            </div>
        </div>
        <div class="preview">
            <a href="https://tuckersoft.net/ealing20541/piginapoke/"><img class="game" src="images/game-piginapoke.gif"
                                                                          alt="Photo of Colin's third most recent game developed. A picture of 'Pig in a poke' game cover."></a>
            <!-- piginapoke img SOURCE: https://tuckersoft.net/ealing20541/piginapoke/ Retrieved 20/02/2019-->
            <div class="caption">
                <a href="https://tuckersoft.net/ealing20541/piginapoke/"><p>Pig in a poke - 2.5 / 5 Stars</p></a>
            </div>
        </div>
        <div class="preview">
            <a href="https://tuckersoft.net/ealing20541/rollingroad/"><img class="game"
                                                                           src="images/game-rollingroad.gif"
                                                                           alt="A small preview of the Rolling road game cover. Depicting a laser shooting robot ontop of a motorbike."></a>
            <!-- roolling road img SOURCE: https://tuckersoft.net/ealing20541/rollingroad/ Retrieved 19/03/2019-->
            <div class="caption">
                <a href="https://tuckersoft.net/ealing20541/rollingroad/"><p>Rolling Road - 3 / 5 Stars</p></a>
            </div>
        </div>
    </div>

</div>
</body>
</html>