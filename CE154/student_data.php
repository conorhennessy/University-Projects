<?php 
$student_inventory = [
	'INSERT INTO inventory VALUES (
	"AA01-005",
	"One Man and His Bike",
	"What would happen if you were cycling to the office and just kept on pedalling?",
	"Mike Carter",
	"aa01-005.jpg",
	1001,
	7.99 ,
	"Southend", 
	12,
	10 );',
	'INSERT INTO inventory VALUES (
	"AA01-006",
	"Rebecca",
	"Last night I dreamt I went to Manderley again . . .",
	"Daphne Du Maurier",
	"aa01-006.jpg",
	1001,
	6.99 ,
	"Colchester",
	15,
	5 );',
	
	'INSERT INTO inventory VALUES (
	"AA01-011",
	"Whenever You Need Somebody",
	"NGGYU NGLYD NGRAADY",
	"Rick Astley",
	"aa01-011.jpg",
	1002,
	4.60 ,
	"Colchester",
	8,
	0 );',
	'INSERT INTO inventory VALUES (
	"AA01-012",
	"Demon days",
	"Demon Days is the second studio album by British virtual band Gorillaz",
	"Gorillaz",
	"aa01-012.jpg",
	1002,
	5.99 ,
	"Southend",
	12,
	3 );',
	
	'INSERT INTO inventory VALUES (
	"AA01-023",
	"Hot fuzz",
	"A skilled London police officer is transferred to a small town that\'s harbouring a dark secret.",
	"Universal Pictures UK",
	"aa01-023.jpg",
	1004,
	7.99 ,
	"Colchester",
	9,
	2 );',
	'INSERT INTO inventory VALUES (
	"AA01-024",
	"Grabbers",
	"Residents of an island off the coast of Ireland learn that the only way to survive an invasion of blood-sucking aliens is to stay drunk.",
	"Irish Film Board",
	"aa01-024.jpg",
	1004,
	10.00 ,
	"Colchester",
	6,
	1 );',
	
	'INSERT INTO inventory VALUES (
	"AA01-017",
	"Human Fall Flat",
	"A quirky, open-ended physics-based puzzle and exploration game set in floating dreamscapes",
	"No Breaks Games",
	"aa01-017.jpg",
	1003,
	11.99 ,
	"Colchester",
	33,
	15 );',
	'INSERT INTO inventory VALUES (
	"AA01-018",
	"rust",
	"The only aim in Rust is to survive. To do this you will need to overcome struggles of hunger, thirst and cold.",
	"Facepunch Studios",
	"aa01-018.jpg",
	1003,
	27.79 ,
	"Southend",
	10,
	15 );'
];

# The above adds two hypothetical two books, CDs, DVDs and Games to the database. 
#
# Not that each INSERT is a single-quote delimited string, ends in a semi-colon
# and has commas between the arguments.
?>