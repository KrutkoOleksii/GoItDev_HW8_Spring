<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Products</title>
        <style>
            <%@include file="/style.css" %>
        </style>
    </head>
    <body>
    <c:import url="/navibar.jsp"/>
        <h2>Products</h2>
        <p>
        <table border=1 cellpadding=8>
        <tr>
             <th>ID</th>
             <th>Name</th>
             <th>Price</th>
             <th>Producer</th>

             <th>"UPDATE"</th>
             <th>"DELETE"</th>
        </tr>
        <c:forEach var="product" items="${products}">
             <tr>
             <td><c:out value="${product.id}"/></td>
             <td><a href="${PageContext.request.contextPath}/find?id=${product.id}"><c:out value="${product.name}"/></a></td>
             <td><c:out value="${product.price}"/></td>
             <td><c:out value="${product.producer.name}"/></td>

             <td><button onclick="location.href='/updateProduct?id=${product.id}'"  class="button"/>UPDATE</button></td>
             <td><button onclick="location.href='/delete?id=${product.id}'"  class="button"/>DELETE</button></td>
             </tr>
        </c:forEach>
        </table>
        </p>
    </body>
</html>