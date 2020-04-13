-- NOTE: All tables names are in lower case; Database name is
-- all lower case as well.

-- **IMPORTANT**
-- Change ch17811 to your username on the next 3 lines before running this script!
DROP DATABASE IF EXISTS ch17811;
CREATE DATABASE ch17811;
USE ch17811;

-- Create tables

-- Create inventory_group table
CREATE TABLE inventory_group (
  group_code INT NOT NULL AUTO_INCREMENT,
  group_name VARCHAR(20),
  PRIMARY KEY(group_code)
);

-- Create inventory table
CREATE TABLE inventory (
  item_code CHAR(8) NOT NULL,
  item_name VARCHAR(40),
  item_description VARCHAR(140),
  item_author VARCHAR (60),
  item_image_loc VARCHAR(140), 
  item_group INT,
  item_price DECIMAL(10,2),
  item_stock_location VARCHAR (10),  
  item_stock_count INT,
  item_order_count INT,
  PRIMARY KEY(item_code),
  FOREIGN KEY(item_group) REFERENCES inventory_group(group_code) ON DELETE SET NULL
);

-- Create customer table
CREATE TABLE customer (
  customer_number INT NOT NULL AUTO_INCREMENT,
  surname VARCHAR(40),
  initials VARCHAR(10),
  firstname VARCHAR(40),
  title ENUM('Mr', 'Mrs', 'Miss', 'Ms', 'Dr', 'Prof', 'Rev'),
  address1 VARCHAR(60),
  address2 VARCHAR(60),
  city VARCHAR(30),
  county VARCHAR(30),
  postcode VARCHAR(8),
  passwd VARCHAR(128),
  passphrase VARCHAR(128),
  PRIMARY KEY(customer_number)
);

-- Create customer_order table
CREATE TABLE customer_order (
  order_number INT NOT NULL AUTO_INCREMENT,
  order_date DATETIME NOT NULL,
  delivered BOOLEAN,
  shipping_date DATETIME, 
  customer_number INT NOT NULL,
  PRIMARY KEY(order_number),
  FOREIGN KEY(customer_number) REFERENCES customer(customer_number) ON DELETE CASCADE
);  
  
-- Create order_item Table
CREATE TABLE order_item (
  item_code CHAR(8) NOT NULL,
  value DECIMAL(10,2),
  order_number INT NOT NULL,
  quantity INT NOT NULL,
  PRIMARY KEY(item_code, order_number),
  FOREIGN KEY(order_number) REFERENCES customer_order(order_number) ON DELETE CASCADE,
  FOREIGN KEY(item_code) REFERENCES inventory(item_code)
);

-- Create manager table
CREATE TABLE manager (
  manager_number INT NOT NULL,
  surname VARCHAR(40),
  initials VARCHAR(10),
  firstname VARCHAR(40),
  passwd VARCHAR(128),
  passphrase VARCHAR(128),
 PRIMARY KEY(manager_number)
);

-- Create review table
CREATE TABLE review (
  review_number INT NOT NULL AUTO_INCREMENT,
  customer_number INT,
  item_code CHAR(8),
  rating INT NOT NULL DEFAULT 3,
  PRIMARY KEY(review_number),
  UNIQUE(customer_number,item_code),
  FOREIGN KEY(customer_number) REFERENCES customer(customer_number) ON DELETE SET NULL,
  FOREIGN KEY(item_code) REFERENCES inventory(item_code) ON DELETE CASCADE
);

-- Create promotion_code table
CREATE TABLE promotion_code (
  code VARCHAR(20),
  discount INT NOT NULL DEFAULT 0,
  PRIMARY KEY(code)
);

-- Populate inventory group
INSERT INTO inventory_group VALUES (1001, "Books");
INSERT INTO inventory_group VALUES (1002, "Music");
INSERT INTO inventory_group VALUES (1003, "Games");
INSERT INTO inventory_group VALUES (1004, "DVDs");

-- BOOKS

INSERT INTO inventory VALUES (
"AA01-001",
"The Maze Runner",
"When the doors of the lift crank open, the only thing Thomas can remember is his first name.",
"James Dashner",
"aa01-001.jpg",
1001,
3.55,
"Colchester",
1,
15 );

INSERT INTO inventory VALUES (
"AA01-002",
"The Catcher in the Rye",
"Holden narrates the story of a couple of days in his 16-year-old life, just after he has been expelled from school",
"J. D. Salinger",
"aa01-002.jpg",
1001,
4.99,
"Southend",
0,
5 );

INSERT INTO inventory VALUES (
"AA01-003",
"The Fault in Our Stars",
"Hazel Grace has terminal cancer. When Hazel attends a Cancer Kid Support Group she meets Augustus Waters",
"John Green",
"aa01-003.jpg",
1001,
3.99 ,
"Colchester",
5,
0 );

INSERT INTO inventory VALUES (
"AA01-004",
"Paris",
"This epic novel weaves a gripping tale of four families across the centuries",
"Edward Rutherfurd",
"aa01-004.jpg",
1001,
8.83 ,
"Southend",
12,
10 );

-- Additional books, 005 & 006
INSERT INTO inventory VALUES (
"AA01-005",
"One Man and His Bike",
"What would happen if you were cycling to the office and just kept on pedalling?",
"Mike Carter",
"aa01-005.jpg",
1001,
7.99 ,
"Southend", 
12,
10 );

INSERT INTO inventory VALUES (
"AA01-006",
"Rebecca",
"Last night I dreamt I went to Manderley again . . .",
"Daphne Du Maurier",
"aa01-006.jpg",
1001,
6.99 ,
"Colchester",
15,
5 );
-- MUSIC

INSERT INTO inventory VALUES (
"AA01-007",
"Purpose",
"His fourth studio album",
"Justin Bieber",
"aa01-007.jpg",
1002,
9.99 ,
"Colchester",
11,
7 );

INSERT INTO inventory VALUES (
"AA01-008",
"Netsky",
"A drum and bass album that can stand up to regular playing",
"Netsky",
"aa01-008.jpg",
1002,
6.99 ,
"Southend",
0,
10 );

INSERT INTO inventory VALUES (
"AA01-009",
"Queen of the Clouds",
"Debut studio album by the Swedish recording artist",
"Tove Lo",
"aa01-009.jpg",
1002,
4.99 ,
"Colchester",
4,
15 );

INSERT INTO inventory VALUES (
"AA01-010",
"Skream",
"Much more of a reggae (even ska) feel than some other dubstep",
"Skream",
"aa01-010.jpg",
1002,
9.99 ,
"Southend",
2,
0 );

-- STUDENT ADDS TWO CDs HERE, 011 & 012
INSERT INTO inventory VALUES (
"AA01-011",
"Whenever You Need Somebody",
"NGGYU NGLYD NGRAADY",
"Rick Astley",
"aa01-011.jpg",
1002,
4.60 ,
"Colchester",
8,
0 );

INSERT INTO inventory VALUES (
"AA01-012",
"Demon days",
"Demon Days is the second studio album by British virtual band Gorillaz",
"Gorillaz",
"aa01-012.jpg",
1002,
5.99 ,
"Southend",
12,
3 );

-- GAMES

INSERT INTO inventory VALUES (
"AA01-013",
"Minecraft",
"A game which has something for everyone and offers hundreds of hours of fun",
"Mojang",
"aa01-013.jpg",
1003,
14.00 ,
"Colchester",
1,
10 );

INSERT INTO inventory VALUES (
"AA01-014",
"FIFA 16",
"FIFA 16 innovates across the entire pitch to deliver a balanced, authentic, and exciting football experience",
"Electronic Arts",
"aa01-014.jpg",
1003,
32.85 ,
"Southend",
0,
15 );

INSERT INTO inventory VALUES (
"AA01-015",
"Madden NFL 16",
"Be the playmaker from the draft room to the gridiron",
"Electronic Arts",
"aa01-015.jpg",
1003,
29.99 ,
"Colchester",
10,
15 );

INSERT INTO inventory VALUES (
"AA01-016",
"DiRT 3",
"Boasts more cars, more locations, more routes and more events than any other game in the series",
"Codemasters Limited",
"aa01-016.jpg",
1003,
37.50 ,
"Southend",
10,
15 );

-- STUDENT ADDS TWO GAMES HERE, 017 & 018
INSERT INTO inventory VALUES (
"AA01-017",
"Human Fall Flat",
"A quirky, open-ended physics-based puzzle and exploration game set in floating dreamscapes",
"No Breaks Games",
"aa01-017.jpg",
1003,
11.99 ,
"Colchester",
33,
15 );

INSERT INTO inventory VALUES (
"AA01-018",
"rust",
"The only aim in Rust is to survive. To do this you will need to overcome struggles of hunger, thirst and cold.",
"Facepunch Studios",
"aa01-018.jpg",
1003,
27.79 ,
"Southend",
10,
15 );

-- DVDs

INSERT INTO inventory VALUES (
"AA01-019",
"Star Wars: The Force Awakens",
"135 minutes of glorious Star Wars escapism",
"Walt Disney Studios Home Entertainment",
"aa01-019.jpg",
1004,
15.99,
"Colchester",
10,
15 );

INSERT INTO inventory VALUES (
"AA01-020",
"Inception",
"Blockbuster sci-fi thriller",
"Warner Home Video",
"aa01-020.jpg",
1004,
4.97 ,
"Southend",
0,
4 );

INSERT INTO inventory VALUES (
"AA01-021",
"The Big Bang Theory - Season 8",
"Leonard and Sheldon are brilliant physicists but socially challenged otherwise",
"Warner Home Video",
"aa01-021.jpg",
1004,
12.99 ,
"Colchester",
6,
20 );

INSERT INTO inventory VALUES (
"AA01-022",
"Suits",
"In the high-stakes legal world, contentment does not last long",
"Universal Pictures UK",
"aa01-022.jpg",
1004,
10.00 ,
"Colchester",
3,
10 );

-- STUDENT ADDS TWO FILMS HERE, 023 & 024
INSERT INTO inventory VALUES (
"AA01-023",
"Hot fuzz",
"A skilled London police officer is transferred to a small town that's harbouring a dark secret.",
"Universal Pictures UK",
"aa01-023.jpg",
1004,
7.99 ,
"Colchester",
9,
2 );

INSERT INTO inventory VALUES (
"AA01-024",
"Grabbers",
"Residents of an island off the coast of Ireland learn that the only way to survive an invasion of blood-sucking aliens is to stay drunk.",
"Irish Film Board",
"aa01-024.jpg",
1004,
10.00 ,
"Colchester",
6,
1 );

-- CUSTOMERS

INSERT INTO customer VALUES (
1001,
"Scott",
"",
"Mollie",
"Ms",
"63 Wenlock Terrace",
"Pettycur",
"Kirkcaldy",
"Fife",
"KY3 8XD",
MD5("mollie"),
"brevity is the soul of wit" );

INSERT INTO customer VALUES (
1002,
"Barrett",
"",
"Jake",
"Mr",
"18 High St",
"Thorpe Mandeville",
"Oxford",
"Oxfordshire",
"OX17 3SJ",
MD5("tiffany"),
"to be or not to be" );

INSERT INTO customer VALUES (
1003,
"de Ree",
"",
"Jantiene",
"Mrs",
"54 Gloddaeth Street",
"Bildeston",
"Ipswich",
"Suffolk",
"IP7 1QL",
MD5("jantiene"),
"i like this place and willingly could waste my time in it" );

INSERT INTO customer VALUES (
1004,
"Neudorf",
"",
"Maik",
"Dr",
"81 Castledore Road",
"Tuxford",
"Nottingham",
"Nottinghamshire",
"NG22 3XF",
MD5("maik"),
"the world is mine oyster" );

INSERT INTO customer VALUES (
1005,
"Villalobos", 
"",
"Geraldine",
"Prof",
"24 Telford Street",
"Barber Booth",
"Sheffield",
"Yorkshire",
"S30 7EY",
MD5("geraldine"),
"nothing will come of nothing" );

INSERT INTO customer VALUES (
1006,
"Cousteau",
"",
"Karel",
"Mr",
"47 Shore Street",
"Stocksfield",
"Newcastle upon Tyne",
"Northumberland",
"NE43 4JA",
MD5("karel"),
"folly and ignorance" );

INSERT INTO customer VALUES (
1007,
"Wieczorek",
"",
"Wiktoria",
"Dr",
"8 Rowland Rd",
"Ormesby St Margaret",
"Norwich",
"Norfolk",
"NR29 9RQ",
MD5("wiktoria"),
"nature teaches beasts to know their friends" );

INSERT INTO customer VALUES (
1008,
"Novosad",
"",
"Martin",
"Mr",
"54 Harrogate Road",
"Runwell",
"Southend-on-Sea",
"Essex",
"SS11 8EE",
MD5("martin"),
"and summer's lease hath all too short a date" );

-- Create some customer orders
INSERT INTO customer_order VALUES (1231, SUBDATE(NOW(), INTERVAL 53 DAY), TRUE, SUBDATE(NOW(), INTERVAL 50 DAY),  1001);
INSERT INTO customer_order VALUES (1232, SUBDATE(NOW(), INTERVAL 40 DAY), TRUE, SUBDATE(NOW(), INTERVAL 37 DAY), 1003);
INSERT INTO customer_order VALUES (1233, SUBDATE(NOW(), INTERVAL 30 DAY), TRUE, SUBDATE(NOW(), INTERVAL 27 DAY), 1001);
INSERT INTO customer_order VALUES (1234, SUBDATE(NOW(), INTERVAL 21 DAY), TRUE, SUBDATE(NOW(), INTERVAL 18 DAY), 1004);
INSERT INTO customer_order VALUES (1235, SUBDATE(NOW(), INTERVAL 14 DAY), FALSE, '2020/01/01', 1006);
INSERT INTO customer_order VALUES (1236, SUBDATE(NOW(), INTERVAL 8 DAY), TRUE, SUBDATE(NOW(), INTERVAL 5 DAY), 1003);
INSERT INTO customer_order VALUES (1237, SUBDATE(NOW(), INTERVAL 6 DAY), TRUE, SUBDATE(NOW(), INTERVAL 3 DAY), 1001);
INSERT INTO customer_order VALUES (1238, SUBDATE(NOW(), INTERVAL 4 DAY), TRUE, SUBDATE(NOW(), INTERVAL 1 DAY), 1008);
INSERT INTO customer_order VALUES (1239, SUBDATE(NOW(), INTERVAL 4 DAY), FALSE, '2020/01/01', 1005);
INSERT INTO customer_order VALUES (1240, SUBDATE(NOW(), INTERVAL 12 DAY), TRUE, SUBDATE(NOW(), INTERVAL 9 DAY), 1007);
INSERT INTO customer_order VALUES (1241, SUBDATE(NOW(), INTERVAL 1 DAY), FALSE, '2020/01/01', 1004);
INSERT INTO customer_order VALUES (1242, SUBDATE(NOW(), INTERVAL 17 DAY), TRUE, SUBDATE(NOW(), INTERVAL 14 DAY), 1006);
INSERT INTO customer_order VALUES (1243, NOW(), FALSE, '2020/01/01', 1002);

-- Add order items to the orders, one item per order
INSERT INTO order_item VALUES ("AA01-001", 3.55, 1231 ,1);
INSERT INTO order_item VALUES ("AA01-002", 4.99, 1232 ,1);
INSERT INTO order_item VALUES ("AA01-007", 9.99, 1233 ,1);
INSERT INTO order_item VALUES ("AA01-019", 15.99, 1234 ,1);
INSERT INTO order_item VALUES ("AA01-010", 9.99, 1235 ,1);
INSERT INTO order_item VALUES ("AA01-015", 29.99, 1236 ,1);
INSERT INTO order_item VALUES ("AA01-013", 14.00, 1237 ,1);
INSERT INTO order_item VALUES ("AA01-022", 10.00, 1238 ,1);
INSERT INTO order_item VALUES ("AA01-009", 4.99, 1239 ,1);
INSERT INTO order_item VALUES ("AA01-007", 9.99, 1240 ,1);
INSERT INTO order_item VALUES ("AA01-014", 32.85, 1241 ,1);
INSERT INTO order_item VALUES ("AA01-004", 8.83, 1242 ,1);
INSERT INTO order_item VALUES ("AA01-003", 3.99, 1243 ,1);

-- Create two managers
INSERT INTO manager VALUES(100, "Mancini", "", "Luigia", MD5("luigia"), "better three hours too soon than a minute too late" );
INSERT INTO manager VALUES(101, "Jones", "", "Adam", MD5("adam"), "listen to many, speak to a few" );

-- Create initial reviews
INSERT INTO review VALUES (NULL, 1001,"AA01-001",1);
INSERT INTO review VALUES (NULL, 1002,"AA01-007",5);

-- Create promotional code
INSERT INTO promotion_code VALUES ("spring01",10);

-- running this script!
GRANT DELETE,SELECT,INSERT,UPDATE ON ch17811.* TO 'ch17811'@'localhost' IDENTIFIED BY 'obscure';
