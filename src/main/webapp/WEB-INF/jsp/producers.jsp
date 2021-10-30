<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Producers</title>
        <style>
            <%@include file="/style.css" %>
        </style>
    </head>
    <body>
    <c:import url="/navibar.jsp"/>
        <h2>Producers</h2>
        <p>
        <table border=1 cellpadding=8>
        <tr>
             <th>ID</th>
             <th>Name</th>

             <th>"UPDATE"</th>
             <th>"DELETE"</th>
        </tr>
        <c:forEach var="producer" items="${producers}">
             <tr>
             <td><c:out value="${producer.id}"/></td>
             <td><a href="${PageContext.request.contextPath}/find?id=${producer.id}"><c:out value="${producer.name}"/></a></td>

             <td><button onclick="location.href='/updateProducer?id=${producer.id}'"  class="button"/>UPDATE</button></td>
             <td><button onclick="location.href='/delete?id=${producer.id}'"  class="button"/>DELETE</button></td>
             </tr>
        </c:forEach>
        </table>
        </p>
    </body>
</html>