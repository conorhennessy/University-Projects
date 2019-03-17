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
    if (product == null) {
%>
    <h2> Oh no!  No product to show, please return to the products page <a href='<%= "products.jsp" %>'>here</a></h2>
<%
    }
    else {
        %>
        <div align="center">
            <h2> <%= product.title %>  by <%= product.artist %> </h2>
            <img src="<%= product.fullimage %>" />
            <p> <%= db.getProduct(product.PID).description %> </p>
            <p> Price &pound;<%= product.getPrice() %> </p>
            <a href='<%="basket.jsp?addItem="+product.PID%>'> Add to basket </a>
        </div>
        <%
    }
%>
</body>
</html>
