<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Product</title>
        <style>
            <%@include file="style.css" %>
        </style>
    </head>
    <body>
    <c:import url="navibar.jsp"/>
        <h2>Product details</h2>
        <p>
        <table border=1 cellpadding=8>
        <tr>
            <th>ID</th>
            <td><c:out value="${product.id}"/></td>
        </tr>
        <tr>
            <th>Name</th>
            <td><c:out value="${product.name}"/></td>
        </tr>
        <tr>
            <th>Price</th>
            <td><c:out value="${product.price}"/></td>
        </tr>
        <tr>
            <th>Producer</th>
            <td><c:out value="${product.producer.name}"/></td>
        </tr>
        </table>
        </p>
    </body>
</html>