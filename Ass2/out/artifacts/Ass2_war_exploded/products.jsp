<%@ page import="shop.Product"%>

<jsp:useBean id='db'
             scope='session'
             class='shop.ShopDB' />

<html>
<head>
<title>My Shop</title>
</head>
<body>
<table>
<tr>
<th> Title </th> <th> Price </th> <th> Picture </th>
</tr>
<%
    for (Product product : db.getAllProducts() ) {
        // there should also be a way of selecting
        // pictures from a particular artist...
        %>
        <tr>
             <td> <%= product.title %> </td>
             <td> <%= product.getPrice() %> </td>
             <td> <a href = '<%="viewProduct.jsp?pid="+product.PID%>'> <img src="<%= product.thumbnail %>"/> </a> </td>
        </tr>
        <%
    }
 %>
 </table>
</body>
</html>
