CREATE DATABASE orderdb;
USE orderdb;
CREATE TABLE customers (custid SMALLINT, name VARCHAR(30), email VARCHAR(30));
CREATE TABLE orders(orderid SMALLINT, custid SMALLINT, goods VARCHAR(50), price DOUBLE(7,2));