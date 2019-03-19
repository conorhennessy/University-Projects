<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Art Shop</title>

    <style>
        /* Style body */
        body {
            font-family: Arial;
            margin: 0;
            text-align: center;
        }

        /* Header */
        .header {
            padding: 0px;
            background: #163172;
            color: white;
            font-size: 30px;
        }

        .content a:link, a:visited {
            background-color: #1e56a0;
            color: #f6f6f6;
            padding: 14px 25px;
            text-decoration: none;
            display: inline-block;
        }

        .content a:hover, a:active {
            background: #d6e4f0;
            color: #1e56a0;
        }

    </style>
</head>
<body>
<div class="header">
    <h1>Art Shop</h1>
    <p><i>Lots of contemporary art!</i></p>
    <div class="content">
        <a href="products.jsp">Art Catalogue</a> <a href="basket.jsp">View basket</a>
    </div>
</div>
</body>
</html>
