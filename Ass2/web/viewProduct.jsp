<%@ page import="shop.Product"%>

<jsp:useBean id='db'
             scope='session'
             class='shop.ShopDB' />

<html>
<head>
<title>My Shop</title>
</head>
<body>
<%
    String pid = request.getParameter("pid");
    Product product = db.getProduct(pid);
    // out.println("pid = " + pid);
    if (product == null) {
        // do something sensible!!!
        out.println( product );
    }
    else {
        %>
        <div align="center">
        <h2> <%= product.title %>  by <%= product.artist %> </h2>
        <img src="<%= product.fullimage %>" />
        <p> <%= product.description %> </p>
        <p> add to basket (make this work!!!)</p>
        </div>
        <%
    }
%>
</body>
</html>
