<%@ page import="shop.Product" %>

<jsp:useBean id='db'
             scope='session'
             class='shop.ShopDB'/>
<jsp:include page="header-1703055.jsp"/>


<html>
<head>
    <style>
        .content {
            margin-top: 25px;
            text-align: center;
            display: inline-block;
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

        img {
            width: 100px;
        }
    </style>
</head>
<body>
<div class="content">
    <table>
        <tr>
            <th> Title</th>
            <th> Price</th>
            <th> Preview</th>
        </tr>
        <%
            for (Product product : db.getAllProducts()) {
                // there should also be a way of selecting
                // pictures from a particular artist...
        %>
        <tr>
            <td><%= product.title %>
            </td>
            <td>&pound;<%= product.getPrice() %>
            </td>
            <td><a href='<%="viewProduct.jsp?pid="+product.PID%>'> <img src="<%= product.thumbnail %>"/> </a></td>
        </tr>
        <%
            }
        %>
    </table>
    <h3>[&copy; Credit to <a style="all: unset" href="http://www.bevjonesart.co.uk">Bev Jones 2019</a> for all art previews featured]</h3>
</div>
</body>
</html>
