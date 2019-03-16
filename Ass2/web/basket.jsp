<%@ page import="shop.Product" %><%@ page import="java.util.Map" %><jsp:useBean id='basket'             scope='session'             class='shop.Basket'/><%    String empty = request.getParameter("emptyBasket");    if (empty != null) {        basket.clearBasket();    }    String item = request.getParameter("addItem");    basket.addItem(item);%><html><head>    <script>        function checkBasket() {            if (document.getElementById("name").value == "") {                alert("Please input a name!");                return false;            } else {                return true;            }        }    </script></head><body><table>    <tr>        <th> Preview </th> <th> Title</th> <th> Price</th> <th> Quantity</th> <th> Total</th>            <%            for (Product product : basket.getItems().keySet() ) {%>    <tr>        <td><img src="<%= product.thumbnail %>"/>        </td>        <td><%= product.title %>        </td>        <td><%= product.getPrice() %>        </td>        <td><%= basket.getQuantity(product) %>        </td>        <td>test        </td></tr>        <%    }%></table>    <p> </br>Order total = £<%= basket.getTotalString() %>            <%    if ( basket.getTotal() > 0) {        %>    <form action="order.jsp" method="post" name="order" onsubmit="return checkBasket()">        <input type="text" value="Name" name="name" id="name" size="20">        <input type="submit" value="Place Order"/>    </form>    <form action="basket.jsp" method="get">        <input type="hidden" name="emptyBasket" value="yes">        <input type="submit" value="Empty Basket"/>    </form>        <%    }%></body></html>