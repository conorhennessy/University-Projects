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
        // now use HTML literals to create the table
        // with JSP expressions to include the live data
        // but this page is unfinished - the thumbnail
        // needs a hyperlink to the product description,
        // and there should also be a way of selecting
        // pictures from a particular artist
        %>
        <tr>
             <td> <%= product.title %> </td>
             <td> <%= product.price %> </td>
             <td> <a href = '<%="viewProduct.jsp?pid="+product.PID%>'> <img src="<%= product.thumbnail %>"/> </a> </td>
        </tr>
        <%
    }
 %>
 </table>
</body>
</html>
