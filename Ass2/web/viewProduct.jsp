<%@ page import="shop.Product"%>

<jsp:useBean id='db'
             scope='session'
             class='shop.ShopDB' />
<jsp:include page="header-1703055.jsp"/>

<html>
<head>
    <style>
        .content {
            margin-top: 25px;
            text-align: center;
            display: inline-block;
            border: #1e56a0;
        }

        table {
            border-collapse: collapse;
            width: 80%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #d6e4f0;
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
        <div class="content">
            <h2> <%= product.title %>  by <%= product.artist %> </h2>
            <img src="<%= product.fullimage %>" />
            <p> <%= product.description %> </p>
            <p> Price &pound;<%= product.getPrice() %> </p>
            <a href='<%="basket.jsp?addItem="+product.PID%>'> Add to basket </a>
        </div>
        <%
    }
%>
</body>
</html>
