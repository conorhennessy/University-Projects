<%@ page import="shop.ShopDB" %>
<jsp:useBean id='basket'
             scope='session'
             class='shop.Basket'
/>

<jsp:useBean id='db'
             scope='page'
             class='shop.ShopDB'/>

<jsp:include page="header-1703055.jsp"/>

<html>
<head>
    <style>
        .content {
            margin-top: 35px;
            text-align: center;
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

    <% String custName = request.getParameter("name");

    if (custName != null) {
        // order the basket of items!
        db.order(basket, custName);

        // then empty the basket
        basket.clearBasket();

    %>
<div class="content">
    <h2> Dear <%= custName %>! Thank you for your order. </h2>
    <a href="products.jsp">Return to catalogue</a>
    <h4>[&copy; Credit to <a style="all: unset" href="http://www.bevjonesart.co.uk">Bev Jones 2019</a> for all work previews featured]</h4>
    <%
    } else {
    %>
    <h2> Please go back and supply a name! </h2>
    <%
        }

    %>
</div>

</html>
